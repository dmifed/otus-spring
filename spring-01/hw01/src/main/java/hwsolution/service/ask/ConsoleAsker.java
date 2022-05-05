package hwsolution.service.ask;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleAsker implements Asker {

    @Override
    public List<String> getAnswers(Scanner input, PrintStream output, List<String> questions){
        List<String> answers = new ArrayList<>();
        for(String q : questions){
            output.print(q + "\n");
            answers.add(input.nextLine());
        }
        return answers;
    }

}
