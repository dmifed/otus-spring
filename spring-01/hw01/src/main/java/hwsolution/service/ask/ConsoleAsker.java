package hwsolution.service.ask;

import hwsolution.domain.Student;

import java.util.List;
import java.util.Scanner;

public class ConsoleAsker implements Asker {
    private final CSVData csvData;
    private Scanner scanner;
    private Student student;


    public ConsoleAsker(CSVData csvData) {
        this.csvData = csvData;
    }

    @Override
    public void acquaintance() {
        scanner = new Scanner(System.in);
        System.out.println("enter your first name");
        String firstName = scanner.nextLine();
        System.out.println("enter your second name");
        String secondName = scanner.nextLine();
        this.student = new Student(firstName, secondName);
    }

    @Override
    public void ask(){
        List<String> questions = csvData.getQuestions();
        for(String q : questions){
            System.out.println(q);
            student.getAnswers().add(scanner.nextLine());
        }
        //scanner.close();
    }

    @Override
    public void finish() {
        scanner.close();
    }
}
