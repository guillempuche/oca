package software;

import java.util.ArrayList;
import java.util.List;

public class Casella {
    protected int numero;
    protected String descripcio;
    protected List<Fitxa> fitxes;

    public Casella(int numero, String descripcio) {
        this.numero = numero;
        this.descripcio = descripcio;
        this.fitxes = new ArrayList<Fitxa>();
    }
    
    public void situaFitxa(Fitxa fitxa){
        fitxes.add(fitxa);
    }
    public void eliminaFitxa(Fitxa fitxa){
        fitxes.remove(fitxa);
    }
    public Fitxa getFitxa(String color){
        return this.fitxes.get(fitxes.indexOf(color));
    }
    public int getNumero(){
        return this.numero;
    }
    public String getDescripcio(){
        return this.descripcio;
    }
    
    
}
