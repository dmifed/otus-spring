package hwsolution.service.create;

import hwsolution.domain.Student;

import java.io.PrintStream;
import java.util.Scanner;

public class CreatorImpl implements Creator {

    @Override
    public Student create(Scanner input, PrintStream output) {
        String firstName = getName(input, output, "enter your first name \n");
        String lastName = getName(input, output, "enter your last name \n");
        return new Student(firstName, lastName);
    }



    private String getName(Scanner input, PrintStream output, String message){
        output.print(message);
        return input.nextLine();
    }

}
