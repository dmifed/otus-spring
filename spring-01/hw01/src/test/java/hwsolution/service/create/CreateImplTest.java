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
class CreateImplTest {
    private Create create;
    private Student student;

    @BeforeEach
    void setUp() {
        create = new CreateImpl();
        student = new Student("F", "L");
    }

    @Test
    void create() {
        Student testStudent;
        Scanner input = new Scanner("F\nL");
        OutputStream outputStream = new ByteArrayOutputStream();

        PrintStream output = new PrintStream(outputStream);
        output.flush();
        testStudent = create.create(input, output);
        input.close();

        assertNotNull(testStudent);
        assertEquals(testStudent.getFirstName(), student.getFirstName());
        assertEquals(testStudent.getLastName(), student.getLastName());
    }
}
