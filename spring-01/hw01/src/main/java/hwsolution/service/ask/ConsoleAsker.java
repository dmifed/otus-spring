package hwsolution.service.ask;

import hwsolution.domain.CSVData;
import hwsolution.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleAsker implements Asker {
    private final CSVData csvData;
    private Scanner scanner;


    public ConsoleAsker(CSVData csvData) {
        this.csvData = csvData;

    }



    @Override
    public List<String> getStudentAnswer(Student student){
        List<String> answers = new ArrayList<>();
        List<String> questions = csvData.getQuestions();
        for(String q : questions){
            System.out.println(q);
            answers.add(scanner.nextLine());
        }
        student.setAnswers(answers);
        return answers;
    }

    @Override
    public void close() {
        scanner.close();
    }
}
