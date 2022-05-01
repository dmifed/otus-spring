package hwsolution.service.score;

import hwsolution.domain.Student;

public interface Score {
    int getScore(Student student);
    void calcScore(Student student);
}
