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
            throw new ColorFitxaExisteixException("Ja hi ha un jugador amb el color "  + color );
        else {
            this.jugadores.put(color, new Jugador(nom, color, this.dau, this.tauler));
            return 0;
        }
    }
    // Si no hi ha cap jugador amb el color rebut, llavors retorna -1, i sino 0
    public int eliminaJugador(String color) throws ColorFitxaNoExisteixException{
        if (this.jugadores.containsKey(color) == true){
            this.jugadores.remove(color);
            return 0;
        } else
            throw new ColorFitxaNoExisteixException("No hi ha cap jugador controlant " +
                    "una fitxa d'aquest color");
    }
    public int jugarPartida() throws FaltenJugadorsException{
        int torn = 1, numJugadorsJugatsTorn = 1, numCasellaDesti;
        boolean finalPartida = false, casellaOca = false;
        String color = "a";
        List<String> msg = new ArrayList<String>();
        
        // Inicialitzar fitxes a la poscio 1 del tauler si usuari torna a iniciar partida
        // amb algun jugador repetit i sense tancar el programa
        Set<String> keySetColorInicial = this.jugadores.keySet();
        Iterator<String> itInicial = keySetColorInicial.iterator();
        while(itInicial.hasNext()){
            color = itInicial.next();
            this.jugadores.get(color).mouFitxa(1);
        }
        
        // Comprovacio si hi ha menys de 2 jugadors
        if (this.jugadores.size() < 2){
            //return -1;
            throw new FaltenJugadorsException("No hi ha prous jugadors. Haurieu"
                             + " de posar com a mínim dos jugadors");
            
        } else {
            // Comprovacio que s'ha inicialitzat partida
            while (finalPartida == false){
                
                Set<String> keySetColor = this.jugadores.keySet();

                Iterator<String> it = keySetColor.iterator();
                while(it.hasNext() && finalPartida == false){
                    // En el cas que jugador esta a casella Oca, no es canvia torn
                    if(casellaOca == false){
                        // Canvia de jugador si el jugador anterior no esta en oca
                        color = it.next();
                        
                        // Sumar +1 a torn, si tots els jugadors ja han jugat en un torn
                        if(numJugadorsJugatsTorn == this.jugadores.size()){
                            // Inicialitzar a 1 numJugadorsJugatsTorn pel proxim torn
                            numJugadorsJugatsTorn = 1;
                            torn++;
                        } else {
                            // Afegir +1 a "numJugadorsJugatsTorn" perque un jugador ja ha tirat en el torn actual
                            numJugadorsJugatsTorn++;
                        }
                    }
                        
                        if(numJugadorsJugatsTorn == this.jugadores.size() && casellaOca == false)
                            this.iu.mostraPerPantalla("\n\nTorn número " + torn + ":");

                        // Clicar tecla ENTER per passar torn a l'altre jugador
                       
                                
                                String text = llegirText("\n      -----------TIRAR DAU " + 
                                this.jugadores.get(color).getNom() 
                                + "-----------");
                        String[] comanda = text.split(" ");
                        if ("\n".equalsIgnoreCase(comanda[0])){
                            this.iu.mostraPerPantalla("");           
                        }
                        // Lectura finalitzada de la tecla ENTER
                        
                        
                      
                        
                        
                        
                        this.iu.mostraPerPantalla("Juga el seu torn " + this.jugadores.get(color).getNom() +
                            "\nControla la fitxa de color " + color + 
                            "\nSituada a la casella " + this.jugadores.get(color).getFitxa().getCasella().getNumero() +
                            " (" + this.jugadores.get(color).getFitxa().getCasella().getDescripcio() + ")");
                        
                        // Comprovar que el jugador no esta en la Preso. Si pot --> tira dau
                        if(this.jugadores.get(color).potTirar() == true){
                            // Es llanca el dau
                            this.jugadores.get(color).getDau().tirar();
                            this.iu.mostraPerPantalla("\nValor del dau: " + this.jugadores.get(color).getDau().getValor() + "\n");
                        }
                        
                        // Comprova que pot tirar, es a dir, no esta a Preso
                        if(this.jugadores.get(color).potTirar() == true){
                            // Comprovar TRUE o FALSE si s'ha arribat a la casella 63                 
                            finalPartida = this.jugadores.get(color).jugarTorn();

                            numCasellaDesti = this.jugadores.get(color).getFitxa().getCasella().getNumero();
                   
                            // Comprovar si ha casella 63 des d'Oca
                            if (this.jugadores.get(color).getFitxa().getCasella().completaJugada(this.jugadores.get(color), msg) == true)
                                finalPartida = true;
                        } else { // si la fitxa esta a Preso  
                            this.jugadores.get(color).decrementaTornsSenseTirar();
                            
                            //Afegim element a la llista de 'msg' l'informacio sobre la Preso
                            msg.add("\nEl jugador té la fitxa empresonada i no pot tirar en aquest torn");
                        }
                        
                        //Comprovar que la fitxa ha caigut a Oca
                        if(this.jugadores.get(color).getFitxa().getCasella().getDescripcio() == "Oca")
                            casellaOca = true;
                        else
                            casellaOca = false;
                        
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
            this.iu.mostraPerPantalla("\n\nHa guanyat la partida!!!!"+ "\n" +
                    "\n                             `-.            " +
                    "\n                            .o--o.          " +
                    "\n                           +:  :+           " +
                    "\n                          `+/   :+          " +
                    "\n                        `/+.   -o`          " +
                    "\n                       /+`    /+`           " +
                    "\n                     `o:      o//////:`     " +
                    "\n        .::::::/:-  -o.              .+:    " +
                    "\n        oo+++++++y/::                 :+    " +
                    "\n        oo+++++++y                   .s-    " +
                    "\n        oo+++++++y                    /:    " +
                    "\n        oo+++++++y                   /+     " +
                    "\n        oo+++++++y                   /+     " +
                    "\n        oo++++/-+y                  :o`     " +
                    "\n        +o++++/:+s//-..............-+:      " +
                    "\n        `--------` `---------------.`       \n" );
            return 0;
        }
    }
    public void presentaMensajes(List<String> messages){
        // Agafa el primer element de la llista, a on hi han tots els missatges
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
