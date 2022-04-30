package hwsolution.dao;

import hwsolution.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {
    Optional<Student> findById(int id);
    List<Student> findByName(String anyName);
    List<Student> findByScore(int score);
}
