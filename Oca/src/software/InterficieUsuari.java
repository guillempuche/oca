/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author E6510
 */
public class InterficieUsuari {

    private Controlador controlador;
    private Scanner lector = new Scanner(System.in);

    public static void main(String args[]) {
        InterficieUsuari programa = new InterficieUsuari();
        programa.start();
    }

    public void start() {
        boolean executar = true;
        int comprovadorJugador;
        System.out.println("Benvinguts a l'aplicació del joc de la oca de MOO!");

        while (executar) {
            String text = llegirText("    #> ");
            String[] comanda = text.split(" ");
            switch (comanda.length) {
                case 1:
                    if ("inicia".equalsIgnoreCase(comanda[0])) {
                        executar = false;

                    } else if ("alta".equalsIgnoreCase(comanda[0])) {
                        String nom = llegirText("Nom del jugador:\n");
                        String color = llegirText("Color de fitxa:\n");
                        comprovadorJugador =  controlador.afegeixJugador(nom, color);
                        System.out.println("Alta finalitzada.");

                    } else if ("elimina".equalsIgnoreCase(comanda[0])) {
                         String color = llegirText("\nColor de fitxa:\n");
                        controlador.eliminaJugador(color);
                        
                    } else {
                        System.out.println("Comanda incorrecta.");
                    }
                    break;
                case 2:
                    if ("cerca".equalsIgnoreCase(comanda[0])) {

                //FER: Cerca l'element i mostrar-lo per pantalla
                        //Recordar que l'ISBN escrit pel teclat ja està a "comanda[1]"
                    } else {
                        System.out.println("Comanda incorrecta.");
                    }
                    break;
                default:
                    System.out.println("Comanda incorrecta.");
            }
        }
        System.out.println("Programa finalitzat");
    }

    public String ajuda() {
        return "Introdueix una de les comandes de la llista:\n"
                + "alta - Afegeix un nou jugador a la partida\n"
                + "elimina - Elimina un dels jugadors afegits prèviament a la partida\n"
                + "inicia - Inicia la partida amb els jugadors introduïts\n"
                + "ajuda - Mostra novament les comandes vàlides per a l'aplicació\n"
                + "surt - Surt del joc de la oca";
    }

    /**
     * Llegeix una línia de text des del teclat, garantint que no s'escriu una
     * línia simplement en blanc (ha de tenir algun caràcter vàlid).
     *
     * @param msg Missatge que es mostra a l'usuari
     * @return Text llegit
     */
    private String llegirText(String msg) {
        String text = null;
        while (text == null) {
            System.out.print(msg);
            text = lector.nextLine();
            text = text.trim();
            if (text.matches("[ ]*")) {
                System.out.println("No has escrit res.");
                text = null;
            }
        }
        return text;
    }
}
