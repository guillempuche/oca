/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software;

import java.util.ArrayList;
import java.util.List;

public class Casella {
    private int numero;
    private String descripcio;
    private List<Fitxa> fitxes;

    public Casella(int numero, String descripcio) {
        this.numero = numero;
        this.descripcio = descripcio;
        ArrayList<Fitxa> fitxes = new ArrayList<Fitxa>(); //new Fitxa(fitxa.getColor(), fitxa.getJugador(), fitxa.getCasella());
    }
    
    public void situaFitxa(Fitxa fitxa){
        fitxes.add(fitxa);
    }
    public void eliminaFitxa(Fitxa fitxa){
        fitxes.remove(fitxa);
    }
    public Fitxa getFitxa(java.lang.String color){
        return this.fitxes.get(fitxes.indexOf(color));
    }
    public int getNumero(){
        return this.numero;
    }
    
    
}
