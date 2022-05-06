package hwsolution.service.data;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by DIMA, on 05.05.2022
 */
class CSVDataTest {
    Path path;
    Data csvData;
    List<String> testQuestions;
    List<List<String>> testAnswers;

    @BeforeEach
    void setUp() {
        try {
            path = Files.createTempFile("testData", ".scv");
            Files.writeString(path, "оккервиль это что?,река", StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            Files.writeString(path, "семки есть?,надо поискать&&а если найду", StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        csvData = new CSVData();
        testQuestions = new ArrayList<>();
        testQuestions.add("оккервиль это что?");
        testQuestions.add("семки есть?");
        testAnswers = new ArrayList<>();
        List<String> first = new ArrayList<>();
        first.add("река");
        List<String> second = new ArrayList<>();
        second.add("надо поискать");
        second.add("а если найду");
        testAnswers.add(first);
        testAnswers.add(second);


    }

    @AfterEach
    void tearDown() {
        path.toFile().deleteOnExit();
    }

    @Test
    void getData() {
        Map<String, List<String>> fileData = csvData.getData(path.toFile());
        assertNotNull(fileData);
        int index = 0;
        for(Map.Entry<String, List<String>> entry : fileData.entrySet()){
            assertEquals(entry.getKey(), testQuestions.get(index));
            index++;
            List<String> ans = entry.getValue();
            for(int ansIndex = 0; ansIndex < ans.size(); ansIndex++){
                assertEquals(ans.get(ansIndex), testAnswers.get(index).get(ansIndex));
            }
        }
    }
}
