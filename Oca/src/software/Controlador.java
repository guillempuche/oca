/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software;

import java.util.Map;
import java.util.TreeMap;

public class Controlador {
    private InterficieUsuari iu;
    private Dau dau;
    private Tauler tauler;
    private Map<String,Jugador> jugadores;
    
    public Controlador(InterficieUsuari iu) {
        this.iu = iu;
        this.dau = new Dau(dau.getValor());
        this.tauler = new Tauler();
        TreeMap<String, Jugador> jugadores = new  TreeMap();
       
    }
    
    public int afegeixJugador(String nom, String color){
        if (jugadores.containsKey(color))  
            return -1;
        else {
            jugadores.put(color, new Jugador(nom, dau, jugadores.get(color).getFitxa(), tauler));   
            return 0;
        }
    }
}
