package hwsolution.service.student;

import hwsolution.dao.StudentDao;
import hwsolution.domain.Student;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService{
    private StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Optional<Student> getById(int id) {
        return studentDao.findById(id);
    }

    @Override
    public List<Student> getByName(String anyName) {
        return studentDao.findByName(anyName);
    }

    @Override
    public List<Student> getByScore(int score) {
        return studentDao.findByScore(score);
    }
}
