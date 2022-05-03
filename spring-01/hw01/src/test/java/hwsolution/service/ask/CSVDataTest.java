package hwsolution.service.ask;

import hwsolution.domain.CSVData;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Deprecated
class CSVDataTest {
    private Path tempPath;
    private CSVData csvData;

    @BeforeAll
    private void createData(){
        createTempDataFile();
        fillTestData(tempPath);
    }



    @Test
    void getQuestions() {
    }

    @Test
    void getAnswers() {
    }

    private void createTempDataFile(){
        try {
            tempPath = Files.createTempFile("tempData", ".csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillTestData(Path path){
        try {
            Files.writeString(path, "QuestionTest, AnswerTest");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    private void deleteTempFile(){
        if(tempPath == null) return;
        try {
            Files.delete(tempPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}