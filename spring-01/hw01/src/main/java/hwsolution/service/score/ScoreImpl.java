package hwsolution.service.score;

import hwsolution.domain.Student;
import hwsolution.service.ask.CSVData;

import java.util.List;

public class ScoreImpl implements Score{
    CSVData csvData;

    public ScoreImpl(CSVData csvData) {
        this.csvData = csvData;
    }

    @Override
    public int getScore(Student student) {
        if(student.getScore() != -1){
            return student.getScore();
        }else {
            calcScore(student);
            return student.getScore();
        }

    }

    @Override
    public void calcScore(Student student) {
        int score = 0;
        List<String> questions = csvData.getQuestions();
        List<String> answers = student.getAnswers();
        for(int i = 0; i < answers.size(); i++){
            if(answers.get(i).equalsIgnoreCase(questions.get(i))){
                ++score;
            }
        }
        student.setScore(score);
    }
}
