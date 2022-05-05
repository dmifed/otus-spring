package hwsolution.service.create;

import hwsolution.domain.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by DIMA, on 04.05.2022
 */
class CreatorImplTest {
    private Creator creator;
    private Student student;

    @BeforeEach
    void setUp() {
        creator = new CreatorImpl();
        student = new Student("F", "L");
    }

    @Test
    void create() {

        Student testStudent;
        Scanner input = new Scanner("F\nL");
        OutputStream outputStream = new ByteArrayOutputStream();

        PrintStream output = new PrintStream(outputStream);
        output.flush();
        testStudent = creator.create(input, output);
        input.close();
        output.close();

        assertNotNull(testStudent);
        assertEquals(testStudent.getFirstName(), student.getFirstName());
        assertEquals(testStudent.getLastName(), student.getLastName());
    }
}
