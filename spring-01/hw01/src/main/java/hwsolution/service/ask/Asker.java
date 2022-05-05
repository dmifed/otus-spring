package hwsolution.service.ask;

import hwsolution.domain.Student;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public interface Asker {

    List<String> getAnswers(Scanner input, PrintStream output,List<String> questions);

}
