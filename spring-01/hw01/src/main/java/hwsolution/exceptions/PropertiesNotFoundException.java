package hwsolution.exceptions;

public class PropertiesNotFoundException extends Exception{
    public PropertiesNotFoundException(){
        super("cant acquire properties");
    }
}
