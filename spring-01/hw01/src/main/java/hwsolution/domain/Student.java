package hwsolution.domain;

import hwsolution.dao.StudentDaoImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private static int ids = -1;

    @Getter
    private final String firstName;

    @Getter
    private final String lastName;

    @Getter
    private int score = -1;

    private final int id;

    @Getter
    private final List<String> answers;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.answers = new ArrayList<>();
        this.id = ++ids;
        StudentHolder.getStudents().add(this);
    }

    public void setScore(int score) {
        if (this.score == -1) {
            this.score = score;
        }
    }
}
