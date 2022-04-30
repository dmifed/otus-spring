package hwsolution.dao;

import hwsolution.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDaoImpl implements StudentDao{


    private static final List<Student> students = new ArrayList<>();

    @Override
    public Optional<Student> findById(int id) {
        if(id >= students.size()){
            return Optional.empty();
        }
        return Optional.of(students.get(id));
    }

    @Override
    public List<Student> findByName(String anyName) {
        List<Student> studentWithSameName = new ArrayList<>();
        for(Student s : students){
            if(s.getFirstName().equalsIgnoreCase(anyName) || s.getLastName().equalsIgnoreCase(anyName)){
                studentWithSameName.add(s);
            }
        }
        return studentWithSameName;
    }

    @Override
    public List<Student> findByScore(int score) {
        List<Student> studentWithSameScore = new ArrayList<>();
        for(Student s : students){
            if(s.getScore() == score){
                studentWithSameScore.add(s);
            }
        }
        return studentWithSameScore;
    }


    public static void addStudent(Student student){
        students.add(student);
    }
}
