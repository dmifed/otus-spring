package hwsolution.service.data;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.*;

public class CSVData implements Data{

    @Override
    public Map<String, List<String>> getData(File csvFile) {
        Map<String, List<String>> data = new HashMap<>();
        try {
            CSVReader csvReader = new CSVReader(new FileReader(csvFile));
            List<String[]> rawData = csvReader.readAll();
            //0 position its a headers of columns
            for(int i = 1; i < rawData.size(); i++){
                String question = rawData.get(i)[0];
                List<String> varAnswers = Arrays.asList(rawData.get(i)[1].split("&&"));
                data.put(question, varAnswers);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public List<String> getQuestions(Map<String, List<String>> data){
        return new ArrayList<>(data.keySet());
    }

    @Override
    public List<List<String>> getVarAnswers(Map<String, List<String>> data){
        return new ArrayList<>(data.values());
    }




}
