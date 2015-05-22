package software;

public class ColorFitxaExisteixException extends Exception{
    public ColorFitxaExisteixException(){
        super("Error");
    }
    public ColorFitxaExisteixException(String msg){
        super("Error: " + msg);
    }
}

