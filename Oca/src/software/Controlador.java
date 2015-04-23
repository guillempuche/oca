package software;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Controlador {
    private InterficieUsuari iu;
    private Dau dau;
    private Tauler tauler;
    private Map<String,Jugador> jugadores;
    private int torn;
    private Scanner lector = new Scanner(System.in);
    
    public Controlador(InterficieUsuari iu) {
        this.iu = iu;
        this.dau = new Dau();
        this.tauler = new Tauler();
        this.jugadores = new TreeMap<String, Jugador>();
        this.torn = 0;
    }

    public int afegeixJugador(String nom, String color){        
        if (this.jugadores.containsKey(color) == true) 
            return -1;
        else {
            this.jugadores.put(color, new Jugador(nom, color, this.dau, this.tauler));
            return 0;
        }
        
    }
    
    // Si no hi ha cap jugador amb el color rebut, llavors retorna -1, i sino 0
    public int eliminaJugador(String color){
        if (this.jugadores.containsKey(color) == true){
            this.jugadores.remove(color);
            return 0;
        } else
            return -1;
    }
    
    public int jugarPartida(){
        int numCasillaDesti;
        boolean finalPartida = false;
        
        // Comprovacio si hi ha 2 o menys jugadors
        if (this.jugadores.size() <= 2)
                return -1;
        else
        {
            // Comprovacio s'ha inicialitzat partida
            while (finalPartida == false){
                this.torn++;

                Set<String> keySetColor = new HashSet<String>();
                keySetColor = this.jugadores.keySet();

                Iterator<String> it = keySetColor.iterator();
                while(it.hasNext() && finalPartida == false){
                    String color = it.next();

                    //Clicar ENTER per passar torn a l'altre jugador
                    String text = llegirText("\n      -----------TIRAR DAU " + 
                            this.jugadores.get(color).getNom() 
                            + "-----------");
                    String[] comanda = text.split(" ");
                    if ("\n".equalsIgnoreCase(comanda[0])){
                        System.out.println("");           
                    }
                    // lectura finalitzada d'ENTER

                    System.out.println("Torn número " + this.torn + ":\n\n" +
                        "Juga el seu torn " + this.jugadores.get(color).getNom() +
                        "\nControla la fitxa de color " + color + 
                        "\nSituada a la casella " + this.jugadores.get(color).getFitxa().getCasella().getNumero() +
                        " (Casella convencional)");

                    this.jugadores.get(color).getDau().tirar();
                    System.out.println("Valor del dau: " + this.jugadores.get(color).getDau().getValor());

                    //Comprovar si s'ha arribat a la casella 63                 
                    finalPartida = this.jugadores.get(color).jugarTorn();
                    System.out.println("Casella destí " 
                            + this.jugadores.get(color).getFitxa().getCasella().getNumero() +
                            " (Casella convencional)");
                }
            }
            //Sentencia quan GUANYA JUGADOR
            System.out.println("\n\nHa guanyat la partida!!!!");
            
            return 0;
        }
    }
    
    private String llegirText(String msg) {
        String text = null;
        while (text == null) {
            System.out.print(msg);
            text = lector.nextLine();
            text = text.trim();
        }
        return text;
    }
}
