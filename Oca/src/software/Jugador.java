/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software;


public class Jugador {
    private String nom;
    private Dau dau;
    private Fitxa fitxa;
    private Tauler tauler;

    public Jugador(String nom, Dau dau, Fitxa fitxa, Tauler tauler) {
        this.nom = nom;
        this.dau = dau;
        this.fitxa = fitxa;
        this.tauler = tauler;
    }
    public String getNom(){
        return nom;
    }
    
    public Dau getDau(){
        return dau;
    }
    
    public Fitxa getFitxa(){
        return fitxa;
    }
    
    public Tauler getTauler(){
        return tauler;
    }
    
    
}
