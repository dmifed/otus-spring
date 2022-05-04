package hwsolution.service.score;

import hwsolution.domain.CSVData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by DIMA, on 04.05.2022
 */
class ScoreImplTest {
    Path path;
    Score score;
    CSVData csvData;

    @BeforeEach
    void setUp() {
        score = new ScoreImpl(csvData);
        try {
            path = Files.createTempFile("testData", ".scv");
            Files.writeString(path, "оккервиль это что?,река", StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            Files.writeString(path, "семки есть?,надо поискать&&а если найду", StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void calcScore() {
    }
}
