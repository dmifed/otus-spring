package hwsolution.service.ask;

import hwsolution.domain.CSVData;
import hwsolution.domain.Student;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleAsker implements Asker {
    private final CSVData csvData;

    public ConsoleAsker(CSVData csvData) {
        this.csvData = csvData;
    }



    @Override
    public List<String> getAnswers(Scanner input, PrintStream output){
        List<String> answers = new ArrayList<>();
        List<String> questions = csvData.getQuestions();
        for(String q : questions){
            output.print(q + "\n");
            answers.add(input.nextLine());
        }
        return answers;
    }

}
