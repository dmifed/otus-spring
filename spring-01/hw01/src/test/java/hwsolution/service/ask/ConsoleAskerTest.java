package hwsolution.service.ask;

import hwsolution.domain.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by DIMA, on 05.05.2022
 */
class ConsoleAskerTest {
    List<String> targetAnswer;
    List<String> testQuestion;
    Asker asker;

    @BeforeEach
    void setUp(){
        asker = new ConsoleAsker();
        targetAnswer = new ArrayList<>();
        targetAnswer.add("a");
        targetAnswer.add("b");
        testQuestion = new ArrayList<>();
        testQuestion.add("a?");
        testQuestion.add("b?");

    }

    @Test
    void getAnswers() {
        Scanner input = new Scanner("a\nb");
        OutputStream outputStream = new ByteArrayOutputStream();

        PrintStream output = new PrintStream(outputStream);
        output.flush();
        List<String> answerResult = asker.getAnswers(input, output, testQuestion);
        input.close();
        output.close();
        assertNotNull(answerResult);
        assertEquals(answerResult.size(), targetAnswer.size());
        for (int i = 0; i < answerResult.size(); i++){
            assertEquals(answerResult.get(i), targetAnswer.get(i));
        }
    }
}
