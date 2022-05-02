package hwsolution;

import hwsolution.domain.Student;
import hwsolution.service.ask.Asker;
import hwsolution.service.score.Score;
import hwsolution.service.student.StudentService;
import hwsolution.service.student.StudentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        StudentService studentService = context.getBean(StudentService.class);
        Asker asker = context.getBean(Asker.class);
        Score score = context.getBean(Score.class);

        for(int i = 0; i < 2; i++){
            asker.acquaintance();
            asker.ask();
        }

        asker.finish();

        for(int i = 0; i < 2; i++){
            Student student = studentService.getById(i).orElse(new Student("default", "default"));
            score.calcScore(student);
            System.out.println(student.toString());
        }

    }
}
