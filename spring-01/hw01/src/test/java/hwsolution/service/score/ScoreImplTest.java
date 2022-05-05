package hwsolution.service.score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by DIMA, on 04.05.2022
 */
class ScoreImplTest {
    Score score;
    List<List<String>> testAnswers;
    List<String> studentsAnswers;

    @BeforeEach
    void setUp() {
        score = new ScoreImpl();
        List<String> first = new ArrayList<>();
        first.add("река");
        List<String> second = new ArrayList<>();
        second.add("надо поискать");
        second.add("а если найду");
        testAnswers = new ArrayList<>();
        testAnswers.add(first);
        testAnswers.add(second);
        studentsAnswers = new ArrayList<>();
        studentsAnswers.add("[p");
        studentsAnswers.add("а если найду");

    }


    @Test
    void calcScore() {
        int target = 1;
        int test = score.calcScore(studentsAnswers, testAnswers);
        assertEquals(target, test);
    }
}
