package hwsolution.domain;

import hwsolution.exceptions.PropertiesNotFoundException;
import lombok.Getter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

    private File file;

    private File getFileFromProperties(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("spring-01\\hw01\\src\\main\\resources\\config.properties")));
            return new File(properties.getProperty("path.to.test"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public File getFile() throws PropertiesNotFoundException {
        if(file == null){
            file = getFileFromProperties();
            if(file == null){
                throw new PropertiesNotFoundException();
            }
        }
        return file;
    }
}
