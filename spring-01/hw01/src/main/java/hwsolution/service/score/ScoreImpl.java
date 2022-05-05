package hwsolution.service.score;

import hwsolution.domain.Student;
import hwsolution.service.data.CSVData;

import java.util.List;

public class ScoreImpl implements Score{
    CSVData csvData;

    public ScoreImpl(CSVData csvData) {
        this.csvData = csvData;
    }

    @Override
    public int calcScore(Student student) {
        int score = 0;
        List<String> rightAnswers = csvData.getAnswers();
        List<String> studentAnswers = student.getAnswers();
        for(int i = 0; i < studentAnswers.size(); i++){
            String[] varsAnswer = rightAnswers.get(i).split("&&");
            for(String ans : varsAnswer){
                if(studentAnswers.get(i).equalsIgnoreCase(ans)){
                    ++score;
                    break;
                }
            }
        }
        return score;
    }
}
