package hwsolution.service.score;

import hwsolution.domain.Student;

import java.io.File;
import java.util.List;

public interface Score {

    int calcScore(List<String> studentAnswers, List<List<String>> originalAnswers);

}
