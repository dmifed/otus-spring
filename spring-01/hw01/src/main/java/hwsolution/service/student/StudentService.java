package hwsolution.service.student;

import hwsolution.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Optional<Student> getById(int id);
    List<Student> getByName(String anyName);
    List<Student> getByScore(int score);
}
