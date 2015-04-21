/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software;

public class Casella {
    private int numero;
    private String descripcio;
    private Fitxa fitxa;

    public Casella(int numero, String descripcio) {
        this.numero = numero;
        this.descripcio = descripcio;
        this.fitxa = new Fitxa(fitxa.getColor(), fitxa.getJugador(), fitxa.getCasella());
    }
    
    
}
