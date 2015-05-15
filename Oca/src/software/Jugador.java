package software;


public class Jugador {
    private String nom;
    private Dau dau;
    private Fitxa fitxa;
    private Tauler tauler;
    private int tornsSenseTirar;

    public Jugador(String nom, String color, Dau dau, Tauler tauler) {
        this.nom = nom;
        this.fitxa = new Fitxa(color, this, tauler.getCasella(1));
        this.dau = dau;
        this.tauler = tauler;
        this.tornsSenseTirar = 0;
    }
    public void decrementaTornsSenseTirar(){
        this.tornsSenseTirar--;
    }
    public String getNom(){
        return this.nom;
    }
    public Dau getDau(){
        return this.dau;
    }
    public Fitxa getFitxa(){
        return this.fitxa;
    }
    public boolean jugarTorn(){
        int numCasella, numCasellaDesti;
        
        // Si la suma de casella + valor del dau > casell numero 63 --> 
        // la fitxa retrocedeix en el tauler, es guarda a "numCasellaDesti"
        if ((this.fitxa.getCasella().getNumero() + dau.getValor()) > 63){
            numCasella = 63 - fitxa.getCasella().getNumero();
            numCasella = dau.getValor() - numCasella;
            numCasellaDesti = 63 - numCasella;
        } else
            numCasellaDesti = fitxa.getCasella().getNumero() + dau.getValor();
        
        this.mouFitxa(numCasellaDesti);
 
        // Comprovacio El jugador només guanya si el valor del dau el permet 
        // moure la seva fitxa EXACTAMENT a l'última casella del tauler.
        if (numCasellaDesti == 63)
            return true;
        else
            return false;
    }
    public void mouFitxa(int numCasellaDesti){
        int numCasellaOrigen = this.fitxa.getCasella().getNumero();
        
        this.tauler.situaFitxa(this.fitxa, numCasellaDesti);
        this.fitxa.setCasella(this.tauler.getCasella(numCasellaDesti));
        this.tauler.eliminaFitxa(this.fitxa, numCasellaOrigen);
    }
    public int numeroCasellaFitxaJugador(){
        return this.fitxa.getCasella().getNumero();
    }
    public boolean potTirar(){
       if(this.tornsSenseTirar == 0)
           return true;
       else
           return false;
    }
    public void setTornsSenseTirar(int nTorns){
        this.tornsSenseTirar = nTorns;
    }
    public int tiraDau(){
        dau.tirar();
        return dau.getValor();
    }
 }