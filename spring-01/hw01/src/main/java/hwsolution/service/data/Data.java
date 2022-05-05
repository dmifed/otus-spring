package hwsolution.service.data;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface Data {
    Map<String, List<String>> getData(File file);
    public List<String> getQuestions(Map<String, List<String>> data);
    public List<List<String>> getVarAnswers(Map<String, List<String>> data);
}
