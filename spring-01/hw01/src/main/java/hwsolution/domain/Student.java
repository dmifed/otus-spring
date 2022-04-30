package hwsolution.domain;

import hwsolution.dao.StudentDaoImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Student {
    @Getter
    private final String firstName;

    @Getter
    private final String lastName;

    @Getter
    @Setter
    private int score;

    @Getter
    private List<String> answers;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.answers = new ArrayList<>();
        StudentDaoImpl.addStudent(this);
    }


}
