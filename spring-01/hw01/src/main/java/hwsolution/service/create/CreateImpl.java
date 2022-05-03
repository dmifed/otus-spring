package hwsolution.service.create;

import hwsolution.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateImpl implements Create{
    Scanner scanner;
    private List<String> acquaintanceQuestions;

    public CreateImpl() {
        acquaintanceQuestions = new ArrayList<>();
        acquaintanceQuestions.add("enter your first name");
        acquaintanceQuestions.add("enter your last name");
        scanner = new Scanner(System.in);
    }

    @Override
    public Student create(String firstName, String lastName) {
        scanner = new Scanner(System.in);
        firstName = getName("enter your first name");
        lastName = getName("enter your last name");
        return new Student(firstName, lastName);
    }



    private String getName(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
