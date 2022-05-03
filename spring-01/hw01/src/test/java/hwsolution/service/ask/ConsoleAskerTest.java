package hwsolution.service.ask;

import hwsolution.domain.CSVData;
import hwsolution.domain.Student;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleAskerTest {

    private Path tempPath;
    private ConsoleAsker asker;
    String firstName = "D";
    String lastName = "F";

    @BeforeEach
    void setUp() {
        createTempDataFile();
        fillTestData(tempPath);
    }

    @AfterEach
    void tearDown() {
        if(tempPath == null) return;
        try {
            Files.delete(tempPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    void addingNewStudent() {
        asker.addingNewStudent();
    }

    @Test
    void getStudentAnswer() {
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

}