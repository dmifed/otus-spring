package hwsolution;

import hwsolution.domain.PropertyFile;
import hwsolution.domain.Student;
import hwsolution.domain.StudentHolder;
import hwsolution.exceptions.PropertiesNotFoundException;
import hwsolution.service.ask.Asker;
import hwsolution.service.create.Creator;
import hwsolution.service.data.Data;
import hwsolution.service.score.Score;
import hwsolution.service.student.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws PropertiesNotFoundException {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        File dataFile = new PropertyFile().getFile();


        StudentService studentService = context.getBean(StudentService.class);
        Asker asker = context.getBean(Asker.class);
        Score score = context.getBean(Score.class);
        Creator creator = context.getBean(Creator.class);
        Data csvData = context.getBean(Data.class);

        Scanner input = new Scanner(System.in);
        PrintStream output = System.out;
        Map<String, List<String>> dataMap = csvData.getData(dataFile);

        List<String> question = csvData.getQuestions(dataMap);
        List<List<String>> originalAnswers = csvData.getVarAnswers(dataMap);

        for(int i = 0; i < 2; i++){
            Student student = creator.create(input, output);
            List<String> answers = asker.getAnswers(input, output, question);
            student.setAnswers(answers);
            StudentHolder.addStudent(student);
        }

        input.close();

        for(int i = 0; i < 2; i++){
            Student student = studentService.getById(i).orElse(new Student("default", "default"));
            int scoreInt = score.calcScore(student.getAnswers(), originalAnswers);
            student.setScore(scoreInt);
            System.out.println(student.toString());
        }

        output.close();

    }
}
