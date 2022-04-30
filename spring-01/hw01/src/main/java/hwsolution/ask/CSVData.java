package hwsolution.ask;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.Getter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CSVData {
    private String path;
    private static boolean noData = true;

    @Getter
    private static List<String> questions;
    @Getter
    private static List<String> answers;

    public CSVData() {
        if(noData){
            Properties properties = new Properties();
            try {
                properties.load(new FileInputStream(new File("src\\main\\resources\\config.properties")));
                this.path = properties.getProperty("path.to.test");
                init();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void init(){
        try {
            CSVReader csvReader = new CSVReader(new FileReader(new File(path)));
            List<String[]> data = csvReader.readAll();
            questions = new ArrayList<>();
            answers = new ArrayList<>();
            for (int i = 1; i < data.size(); i++){
                questions.add(data.get(i)[0]);
                answers.add(data.get(i)[1]);
            }
            noData = false;
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
