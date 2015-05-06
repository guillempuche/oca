package software;

import java.util.ArrayList;
import java.util.List;

public class Tauler {
    private Casella caselles[];
    private List<Casella> ocas;
    
    public Tauler() {
        caselles = new Casella[64];
        this.ocas = new ArrayList<Casella>();
        for (int i = 1; i <= 63; i++)
            if(i == 5 || i == 9 || i == 14 || i == 18 || i == 23 ||
                i == 27 || i == 32 || i == 36 || i == 41 || i == 45 ||
                i == 50 || i == 54 || i == 59){                  
                caselles[i] = new Casella(i,"Oca");
                this.ocas.add(caselles[i]);
            }
            else if (i == 52)
                caselles[i] = new Casella(i,"Presó");
            else if (i == 58)
                caselles[i] = new Casella(i,"Mort");
            else 
                caselles[i] = new Casella(i,"casella convencional");
       
    }
    public Casella getCasella(int numero){
        return caselles[numero];
    }
    public void situaFitxa(Fitxa fitxa, int numCasellaDesti){
        this.caselles[numCasellaDesti].situaFitxa(fitxa);
    }
    public void eliminaFitxa(Fitxa fitxa, int numCasellaOrigen){
        this.caselles[numCasellaOrigen].eliminaFitxa(fitxa);
    }
    public Casella getSeguentOca(int numero){
        if (numero+1 <= ocas.size())
            return ocas.get(numero+1);
        else
            return null;
    }
}
