package hwsolution.service.score;

import hwsolution.domain.Student;
import hwsolution.service.data.CSVData;
import hwsolution.service.data.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ScoreImpl implements Score{

    @Override
    public int calcScore(List<String> studentAnswers, List<List<String>> originalAnswers) {
        int score = 0;
            for(int i = 0; i < studentAnswers.size(); i++){
            List<String> varsAnswer = originalAnswers.get(i);
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
