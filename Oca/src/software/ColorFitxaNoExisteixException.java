package software;

public class ColorFitxaNoExisteixException extends Exception{
    public ColorFitxaNoExisteixException(){
        super("Error");
    }
    public ColorFitxaNoExisteixException(String msg){
        super("Error: " + msg);
    }
}
