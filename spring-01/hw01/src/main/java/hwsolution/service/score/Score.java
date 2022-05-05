package hwsolution.service.score;

import hwsolution.domain.Student;

import java.io.File;

public interface Score {

    int calcScore(Student student, File data);

}
