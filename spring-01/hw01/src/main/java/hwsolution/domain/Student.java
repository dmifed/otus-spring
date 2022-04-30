package hwsolution.domain;

import hwsolution.dao.StudentDaoImpl;
import lombok.Getter;
import lombok.Setter;

public class Student {
    @Getter
    private final String firstName;

    @Getter
    private final String lastName;

    @Getter
    @Setter
    private int score;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        StudentDaoImpl.addStudent(this);
    }


}
