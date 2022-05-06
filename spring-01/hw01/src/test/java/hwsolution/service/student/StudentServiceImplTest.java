package hwsolution.service.student;

import hwsolution.dao.StudentDao;
import hwsolution.dao.StudentDaoImpl;
import hwsolution.domain.Student;
import hwsolution.domain.StudentHolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {
    Student testStudent;
    List<Student> testStudentList;
    StudentDao studentDaoMock = Mockito.mock(StudentDao.class);
    StudentServiceImpl studentService = new StudentServiceImpl(studentDaoMock);

    @BeforeEach
    void setUp() {
        testStudent = new Student("F", "L");
        testStudent.setId(0);
    }

    @Test
    void getById() {
        Mockito.when(studentDaoMock.findById(0)).thenReturn(Optional.ofNullable(testStudent));
        assertEquals(studentService.getById(0).orElseThrow().getId(), studentDaoMock.findById(0).orElseThrow().getId());
    }

    @Test
    void getByName() {
    }

    @Test
    void getByScore() {
    }
}
