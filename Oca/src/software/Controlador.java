/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software;

import java.util.Map;
import java.lang;
import java.util.TreeMap;

public class Controlador {
    private InterficieUsuari iu;
    private Dau dau;
    private Tauler tauler;
    private Map<Integer,Jugador> jugadores;

    public Controlador(InterficieUsuari iu) {
        this.iu = iu;
        this.dau = new Dau();
        this.tauler = Tauler();
        this.jugadores = new Jugador();
        // crear news dels atributs
    }
    
    public int afegeixJugador(String nom, String color){
        // crear objecto jugador;
    }
}
