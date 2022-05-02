package hwsolution.exceptions;

public class NoSuchStudentInDao extends Exception{
    public NoSuchStudentInDao(){
        super("no such student");
    }
}
