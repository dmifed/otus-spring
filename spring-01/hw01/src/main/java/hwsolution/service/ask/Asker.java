package hwsolution.service.ask;

import hwsolution.domain.Student;

import java.util.List;

public interface Asker {

    List<String> getStudentAnswer(Student student);
    void close();
}
