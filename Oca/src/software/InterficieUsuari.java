//          Projecte de l'oca fet per Guillem Puche i Daniel Seijas

package software;
import java.util.Scanner;

public class InterficieUsuari {

    private Controlador controlador;
    private Scanner lector = new Scanner(System.in);
    
    public InterficieUsuari(){
        this.controlador = new Controlador(this);  
    }

    public static void main(String args[]) {
        InterficieUsuari programa = new InterficieUsuari();
        programa.start();
    }

    public void start() {
        boolean executar = true;
        
        System.out.println("            Benvinguts a l'aplicació del joc de la oca de MOO!\n"
                + "Introdueix una de les comandes de la llista:\n"
                + "alta -> Afegeix un nou jugador a la partida\n"
                + "elimina -> Elimina un dels jugadors afegits prèviament a la partida\n"
                + "inicia -> Inicia la partida amb els jugadors introduïts\n"
                + "ajuda -> Mostra novament les comandes vàlides per a l'aplicació\n"
                + "surt -> Surt del joc de la oca");

        while (executar) {
            String text = llegirText("\n    #> ");
            String[] comanda = text.split(" ");
            switch (comanda.length) {
                case 1:
                    if ("alta".equalsIgnoreCase(comanda[0])) {
                        String nom = llegirText("Nom del jugador:\n");
                        String color = llegirText("Color de fitxa:\n");
                        if(controlador.afegeixJugador(nom, color) == -1)
                            System.out.println("Ja hi ha un altre jugador "
                                    + "controlant una fitxa d'aquest color");
                        else
                            System.out.println("Jugador afegit correctament");

                    } else if ("elimina".equalsIgnoreCase(comanda[0])) {
                        String color = llegirText("Color de fitxa:\n");
                        if(controlador.eliminaJugador(color) == -1)
                            System.out.println("No hi ha cap jugador controlant "
                                    + "una fitxa d'aquest color");
                        else System.out.println("Jugador eliminat correctament.");
                        
                    } else if ("inicia".equalsIgnoreCase(comanda[0])) {
                        int estatPartida = this.controlador.jugarPartida();
                        
                        if( estatPartida == -1)
                            System.out.println("No hi ha prous jugadors. Recomenem"
                             + "que poseu més de dos jugadors");                        
                     
                    } else if ("ajuda".equalsIgnoreCase(comanda[0])) {
                        System.out.println("Introdueix una de les comandes de la llista:\n"
                            + "alta -> Afegeix un nou jugador a la partida\n"
                            + "elimina -> Elimina un dels jugadors afegits prèviament a la partida\n"
                            + "inicia -> Inicia la partida amb els jugadors introduïts\n"
                            + "ajuda -> Mostra novament les comandes vàlides per a l'aplicació\n"
                            + "surt -> Surt del joc de la oca");
                        
                    } else if ("surt".equalsIgnoreCase(comanda[0])) {
                        System.out.println("Sortint del joc de la oca...");
                        executar = false;
                        
                    } else                        
                        System.out.println("Comanda incorrecta.");
                        
                    break;
            }
        }
        System.out.println("Programa finalitzat");
    }

    private String llegirText(String msg) {
        String text = null;
        while (text == null) {
            System.out.print(msg);
            text = lector.nextLine();
            text = text.trim();
            if (text.matches("[ ]*")) {
                System.out.println("        VIGILA: no has escrit res.");
                text = null;
            }
        }
        return text;
    }
}
