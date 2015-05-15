package software;

public class FaltenJugadorsException extends Exception{
    public FaltenJugadorsException(){
        super("Error");
    }
    public FaltenJugadorsException(String msg){
        super("Error: " + msg);
    }
}
