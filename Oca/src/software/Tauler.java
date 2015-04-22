/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software;


/**
 *
 * @author E6510
 */
public class Tauler {
    private Casella caselles[];

    public Tauler() {
        for (int i=1; i<=63; i++)
            this.caselles[i] = new Casella(i,"casella convencional");
    }
    public Casella getCasella(int numero){
        return caselles[numero];
    }
    public void situaFitxa(Fitxa fitxa, int numero){
        Casella a;
        a = getCasella (numero);
        a.situaFitxa (fitxa);
    }
    public void eliminaFitxa(Fitxa fitxa, int numero){
        Casella a;
        a = getCasella (numero);
        a.eliminaFitxa (fitxa);
    }
}
