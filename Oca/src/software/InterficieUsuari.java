/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software;

/**
 *
 * @author E6510
 */
public class InterficieUsuari {
    private Controlador controlador;
    
   
    public static void main(String args[]){
        InterficieUsuari programa = new InterficieUsuari();
        programa.start(); 
    }
    
    public void start() {
        System.out.println("Benvinguts a l'aplicació del joc de la oca de MOO!");
         
    }
    
    public String ajuda(){
       return "Introdueix una de les comandes de la llista:\n" +
        "alta - Afegeix un nou jugador a la partida\n" +
        "elimina - Elimina un dels jugadors afegits prèviament a la partida\n" +
        "inicia - Inicia la partida amb els jugadors introduïts\n" +
        "ajuda - Mostra novament les comandes vàlides per a l'aplicació\n" +
        "surt - Surt del joc de la oca";
    }
    
}
