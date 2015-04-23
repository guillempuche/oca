package software;

public class Tauler {
    private Casella caselles[];

    public Tauler() {
        caselles = new Casella[64]; 
        for (int i = 1; i <= 63; i++)
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
}
