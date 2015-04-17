/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software;

import java.lang;

/**
 *
 * @author E6510
 */
public class Casella {
    private int numero;
    private String descripcio;
    private Fitxa fitxa;

    public Casella(int numero, lang.String descripcio) {
        this.numero = numero;
        this.descripcio = descripcio;
        
        // Fitxa(...) necessita los parametres String(=color),Jugador,Casella
        // pero no sabem què posar per a què no hi hagi error.
        this.fitxa = new Fitxa();
    }
    
    
}
