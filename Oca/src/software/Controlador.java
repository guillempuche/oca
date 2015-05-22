package software;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Controlador {
    private InterficieUsuari iu;
    private Dau dau;
    private Tauler tauler;
    private Map<String,Jugador> jugadores;
    private Scanner lector = new Scanner(System.in);
    
    public Controlador(InterficieUsuari iu) {
        this.iu = iu;
        this.dau = new Dau();
        this.tauler = new Tauler();
        this.jugadores = new TreeMap<String, Jugador>();
    }
    public int afegeixJugador(String nom, String color) throws ColorFitxaExisteixException{        
        if (this.jugadores.containsKey(color) == true) 
            //return -1;
            throw new ColorFitxaExisteixException("Ja hi ha un jugador amb el color "  + color );
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
    public int jugarPartida() throws FaltenJugadorsException{
        int torn = 1, numJugadorsJugatsTorn = 1, numCasellaDesti;
        boolean finalPartida = false;
        List<String> msg = new ArrayList<String>();
        
        // Comprovacio si hi ha menys de 2 jugadors
        if (this.jugadores.size() < 2){
            //return -1;
            throw new FaltenJugadorsException("No hi ha prous jugadors. Haurieu"
                             + "de posar com a mínim dos jugadors");
            
        } else {
            // Comprovacio que s'ha inicialitzat partida
            while (finalPartida == false){
                
                Set<String> keySetColor = new HashSet<String>();
                keySetColor = this.jugadores.keySet();

                Iterator<String> it = keySetColor.iterator();
                while(it.hasNext() && finalPartida == false){
                    String color = it.next();

                    // Sumar +1 a torn, si tots els jugadors ja han jugat en un torn
                    if(numJugadorsJugatsTorn == this.jugadores.size()){
                        // Inicialitzar a 1 numJugadorsJugatsTorn pel proxim torn
                        numJugadorsJugatsTorn = 1;
                        torn++;
                    } else {
                        // Afegir +1 a "numJugadorsJugatsTorn" perque un jugador ja ha tirat en el torn actual
                        numJugadorsJugatsTorn++;
                    }

                    // Comprovar que el jugador no esta a la Preso. Si esta a Preso,
                    // llavors no segueix en el codi de tirar dau ni moure fitxa
                    /*if(this.jugadores.get(color).potTirar() == false){
                        this.jugadores.get(color).decrementaTornsSenseTirar();
                        this.iu.mostraPerPantalla("Juga el seu torn " + this.jugadores.get(color).getNom() +
                                "\nControla la fitxa de color " + color + 
                                "\nSituada a la casella " + this.jugadores.get(color).getFitxa().getCasella().getNumero() +
                                " (" + this.jugadores.get(color).getFitxa().getCasella().getDescripcio() + ")" +
                                "\nEl jugador té la fitxa empresonada i no pot tirar en aquest torn");
                    } else {*/
                        // Clicar tecla ENTER per passar torn a l'altre jugador
                        String text = llegirText("\n      -----------TIRAR DAU " + 
                                this.jugadores.get(color).getNom() 
                                + "-----------");
                        String[] comanda = text.split(" ");
                        if ("\n".equalsIgnoreCase(comanda[0])){
                            this.iu.mostraPerPantalla("");           
                        }
                        // Lectura finalitzada de la tecla ENTER
                        
                        if(numJugadorsJugatsTorn == this.jugadores.size())
                            this.iu.mostraPerPantalla("Torn número " + torn + ":\n");
                          
                        
                        
                        
                        
                        
                        
                        
                        
                        this.iu.mostraPerPantalla("Juga el seu torn " + this.jugadores.get(color).getNom() +
                            "\nControla la fitxa de color " + color + 
                            "\nSituada a la casella " + this.jugadores.get(color).getFitxa().getCasella().getNumero() +
                            " (" + this.jugadores.get(color).getFitxa().getCasella().getDescripcio() + ")");
                        
                        // Comprovar que el jugador no esta en la Preso. Si pot --> tira dau
                        if(this.jugadores.get(color).potTirar() == true){
                            // Es llanca el dau
                            this.jugadores.get(color).getDau().tirar();
                            this.iu.mostraPerPantalla("Valor del dau: " + this.jugadores.get(color).getDau().getValor());
                        }
                        
                        
                        // Comprovar TRUE o FALSE si s'ha arribat a la casella 63                 
                        finalPartida = this.jugadores.get(color).jugarTorn();
                        
                        numCasellaDesti = this.jugadores.get(color).getFitxa().getCasella().getNumero();
                        
                        if(this.jugadores.get(color).potTirar() == true){
                            // Comprovar si ha casella 63 des d'Oca
                            if (this.jugadores.get(color).getFitxa().getCasella().completaJugada(this.jugadores.get(color), msg) == true)
                                finalPartida = true;
                        }
                        
                        // Esscriure per pantalla
                        this.presentaMensajes(msg);
                        // Netejar llista en cada completaJugada()
                        msg.clear();
                        
                       
                                
                                
                                
                        // Comprovar si casella desti esta a Oca, Mort o Preso
                       /* if(numCasellaDesti == 5 || numCasellaDesti == 9 || 
                                numCasellaDesti == 14 || numCasellaDesti == 18 ||
                                numCasellaDesti == 23 || numCasellaDesti == 27 || 
                                numCasellaDesti == 32 || numCasellaDesti == 36 ||
                                numCasellaDesti == 41 || numCasellaDesti == 45 ||
                                numCasellaDesti == 50 || numCasellaDesti == 54 || 
                                numCasellaDesti == 59){
                            this.tauler.getCasella(numCasellaDesti).completaJugada(this.jugadores.get(color), messages)
                            
                        }*/
                    //} 
                        
                                              
                }
            }
            // Sentencia quan GUANYA un jugador
            this.iu.mostraPerPantalla("\n\nHa guanyat la partida!!!!");
            return 0;
        }
    }
    public void presentaMensajes(List<String> messages){
        this.iu.mostraPerPantalla(messages.get(0));
    }
    // Aprofitat d'una practica de laboratori. Comprovacio que s'hagi introduit text
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
