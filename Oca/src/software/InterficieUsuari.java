//          Projecte de l'oca fet per Guillem Puche i Daniel Seijas
package software;

import java.util.Scanner;

public class InterficieUsuari {

    private Controlador controlador;
    private Scanner lector = new Scanner(System.in);

    public InterficieUsuari() {
        this.controlador = new Controlador(this);
    }

    public static void main(String args[]) {
        InterficieUsuari programa = new InterficieUsuari();
        programa.run();
    }

    public void run() {
        boolean executar = true;

        System.out.println("            Benvinguts a l'aplicació del joc de la oca de MOO!\n");
        this.mostraComandes();
        while (executar) {
            String text = llegirText("\n    #> ");
            String[] comanda = text.split(" ");
            switch (comanda.length) {
                case 1:
                    if ("alta".equalsIgnoreCase(comanda[0])) {
                        try{
                            this.altaJugador();
                        } catch (ColorFitxaExisteixException ex){
                            System.err.println(ex.getMessage() + "\n");
                        }
                    } else if ("elimina".equalsIgnoreCase(comanda[0])) {
                        try{
                            this.eliminaJugador();
                        } catch (ColorFitxaNoExisteixException ex){
                            System.err.println(ex.getMessage() + "\n");
                        }
                    } else if ("inicia".equalsIgnoreCase(comanda[0])) {
                        try {
                            this.iniciarPartida();
                        } catch (FaltenJugadorsException ex) {
                            System.err.print(ex.getMessage()  + "\n");
                        }
                    } else if ("ajuda".equalsIgnoreCase(comanda[0])) {
                        this.mostraComandes();
                    } else if ("surt".equalsIgnoreCase(comanda[0])) {
                        System.out.println("Sortint del joc de la oca...");
                        executar = false;
                    } else {
                        System.out.println("Comanda incorrecta.");
                    }

                    break;
            }
        }
        System.out.println ("Programa finalitzat");
    }

    // Aprofitat d'una practica de laboratori. Comprovacio que s'hagi introduit text.
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
    
    public void altaJugador() throws ColorFitxaExisteixException {
        String nom = llegirText("Nom del jugador:\n");
        String color = llegirText("Color de fitxa:\n");
        if (controlador.afegeixJugador(nom, color) == 0) {
            System.out.println("Jugador afegit correctament");
        }
    }
    
    public void eliminaJugador() throws ColorFitxaNoExisteixException {
        String color = llegirText("Color de fitxa:\n");
        if (controlador.eliminaJugador(color) == 0){/*-1) {
            throw new ColorFitxaNoExisteixException("No hi ha cap jugador controlant "
                    + "una fitxa d'aquest color");*/
        //} else {
            System.out.println("Jugador eliminat correctament.");
        }
    }

    public void iniciarPartida() throws FaltenJugadorsException{
        int jugadorsMinims = this.controlador.jugarPartida();
        
        if (jugadorsMinims == -1){
            throw new FaltenJugadorsException("No hi ha prous jugadors. Hauireu"
                    + "de posar com a mínim dos jugadors");
        }
    }

    public void mostraComandes(){
        System.out.println("Introdueix una de les comandes de la llista:\n"
                + "alta -> Afegeix un nou jugador a la partida\n"
                + "elimina -> Elimina un dels jugadors afegits prèviament a la partida\n"
                + "inicia -> Inicia la partida amb els jugadors introduïts\n"
                + "ajuda -> Mostra novament les comandes vàlides per a l'aplicació\n"
                + "surt -> Surt del joc de la oca");
    }
    
    public void mostraPerPantalla(String msg){
        System.out.print(msg);
    }
}
