package hwsolution.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class StudentHolder {

    private static long ids;
    @Getter
    private static final List<Student> students = new ArrayList<>();

    public static void addStudent(Student student){
        student.setId(++ids);
        students.add(student);
    }

}
