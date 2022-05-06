package hwsolution.service.student;

import hwsolution.domain.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {
    Student testStudent;
    List<Student> testStudentList;
    StudentServiceImpl studentService = Mockito.mock(StudentServiceImpl.class);

    @BeforeEach
    void setUp() {
        testStudent = new Student("F", "L");
        testStudent.setId(0);
        testStudentList = new ArrayList<>();
        testStudentList.add(testStudent);
    }

    @Test
    void getById() {
        Student optionalStudent =
                (Student) Mockito.when(studentService.getById(0)).thenReturn(Optional.ofNullable(testStudentList.get(0)));
        assertEquals(optionalStudent.getId(), testStudent.getId());


    }

    @Test
    void getByName() {
    }

    @Test
    void getByScore() {
    }
}