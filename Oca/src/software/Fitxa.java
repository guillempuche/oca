/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
   
    public String getColor(){
        return color;
    }
    public Jugador getJugador(){
        return jugador;
    }
    public Casella getCasella(){
        return casella;
    }
    
}
