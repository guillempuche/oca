package software;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Controlador {
    //private InterficieUsuari iu;
    private Dau dau;
    private Tauler tauler;
    private Map<String,Jugador> jugadores;
    private int torn;
    
    public Controlador(){//InterficieUsuari iu) {
        //this.iu = iu;
        this.dau = new Dau(1); //this.dau.getValor());
        this.tauler = new Tauler();
        TreeMap<String, Jugador> jugadores = new  TreeMap();
        this.torn = 0;
    }

    public static void main(String args[]){
        String nom = "dan", color = "verd";
        Controlador control = new Controlador();
        System.out.println("El valor es: " +control.afegeixJugador(nom, color));

    }
    
    public int afegeixJugador(String nom, String color){
        int numCasellaInici = 1;
        
        if (this.jugadores.containsKey(color))  
            return -1;
        else {
            this.jugadores.put(color, new Jugador(nom, dau, jugadores.get(color).getFitxa(), tauler));
            this.jugadores.get(color).mouFitxa(numCasellaInici);
            return 0;
        }
        
    }
    
    public int eliminaJugador(String color){
        if (this.jugadores.remove(color)==null) 
            return -1;
        else              
            return 0;
    }
    public int jugarPartida(){
        int numCasillaDesti;
        boolean finalPartida = false;
        
        if (this.jugadores.size() <= 2)
                return -1;
        
        while (finalPartida == false){
            this.torn++;

            Set keySetJugador = this.jugadores.keySet();
            Iterator<Set> it = keySetJugador.iterator();
            while(it.hasNext()){
                Set color = it.next();
                System.out.println("Torn número " + torn + ":\n\n" +
                    "Juga al seu torn " + this.jugadores.get(color).getNom() +
                    "\nControla la fitxa de color " + color + 
                    "\nSituada a la casella" + this.jugadores.get(color).getFitxa().getCasella().getNumero() +
                    "(Casella convencional)");
                
                this.jugadores.get(color).getDau().tirar();
                System.out.println("Valor del dau " + this.jugadores.get(color).getDau().getValor()+ "\n");

                numCasillaDesti=this.jugadores.get(color).getDau().getValor()+
                        this.jugadores.get(color).getFitxa().getCasella().getNumero();
                System.out.println("Casella destí " + numCasillaDesti );
                
                finalPartida = this.jugadores.get(color).jugarTorn();
            }            
        }
        System.out.println("Ha guanyat la partida!!!!");
        return 0;
    }
}
