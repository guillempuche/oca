package software;

public class Fitxa {
    private String color;
    private Jugador jugador;
    private Casella casella;

    public Fitxa(String color, Jugador jugador, Casella casella) {
        this.color = color;
        this.jugador = jugador;
        this.casella = casella;
    }
    public void setCasella(Casella casella){
        this.casella = casella;
    }
    public Casella getCasella(){
        return this.casella;
    }
    public String getColor(){
        return this.color;
    }
    public Jugador getJugador(){
        return this.jugador;
    }  
}
