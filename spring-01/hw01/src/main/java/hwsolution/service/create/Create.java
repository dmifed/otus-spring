package hwsolution.service.create;

import hwsolution.domain.Student;

import java.io.PrintStream;
import java.util.Scanner;

public interface Create {
    Student create(Scanner input, PrintStream output);

}
