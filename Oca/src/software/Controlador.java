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
        this.iu = iu;]
        
        // Dau(...) necessita los parametres Int(=valor)
        // pero no sabem què posar per a què no hi hagi error.
        this.dau = new Dau();
        this.tauler = new Tauler();
        
        // Jugador(...) no es pot convertir a Map<Integer,Jugador>
        // pero si "jugador" ja és Map, no ho entenem.
        this.jugadores = new Jugador();
    }
    
    public int afegeixJugador(String nom, String color){
        // crear objecto jugador;
    }
}
