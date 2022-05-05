package hwsolution;

import hwsolution.domain.PropertyFile;
import hwsolution.domain.Student;
import hwsolution.exceptions.PropertiesNotFoundException;
import hwsolution.service.ask.Asker;
import hwsolution.service.create.Create;
import hwsolution.service.score.Score;
import hwsolution.service.student.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.lang.NonNull;

import java.io.File;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws PropertiesNotFoundException {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        File data = new PropertyFile().getFile();


        StudentService studentService = context.getBean(StudentService.class);
        Asker asker = context.getBean(Asker.class);
        Score score = context.getBean(Score.class);
        Create create = context.getBean(Create.class);

        Scanner input = new Scanner(System.in);
        PrintStream output = System.out;

        for(int i = 0; i < 2; i++){
            Student student = create.create(input, output);
            List<String> answers = asker.getAnswers(input, output);
            student.setAnswers(answers);
        }

        input.close();

        for(int i = 0; i < 2; i++){
            Student student = studentService.getById(i).orElse(new Student("default", "default"));
            int scoreInt = score.calcScore(student, data);
            student.setScore(scoreInt);
            System.out.println(student.toString());
        }

        output.close();

    }
}
