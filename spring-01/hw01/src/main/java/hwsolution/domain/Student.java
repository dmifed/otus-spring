package hwsolution.domain;

import hwsolution.dao.StudentDaoImpl;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@ToString
public class Student {

    @Getter
    private final String firstName;

    @Getter
    private final String lastName;

    @Getter
    private int score = -1;

    @Getter
    @ToString.Exclude
    private long id = -1;

    @Getter
    @Setter
    @ToString.Exclude
    private List<String> answers;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.answers = new ArrayList<>();
        StudentHolder.getStudents().add(this);
    }

    public void setScore(int score) {
        if (this.score == -1) {
            this.score = score;
        }
    }

    public void setId(long id){
        if(id == -1){
            this.id = id;
        }
    }
}
