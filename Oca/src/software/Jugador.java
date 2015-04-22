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
        return this.nom;
    }
    
    public Dau getDau(){
        return this.dau;
    }
    
    public Fitxa getFitxa(){
        return this.fitxa;
    }
    public int numeroCasellaFitxaJugador(){
    Casella a;
      a= this.fitxa.getCasella();
      return a.getNumero();
    }
    public int tiraDau(){
        dau.tirar();
        return dau.getValor();
    }
    public void mouFitxa(int numCasellaDesti){
        this.tauler.situaFitxa(this.fitxa, numCasellaDesti);
    }
    public boolean jugarTorn(){
        int numCasella, numCasellaDesti;
        if (fitxa.getCasella().getNumero() + dau.getValor() > 63){
            numCasella= 63-fitxa.getCasella().getNumero();
            numCasella= dau.getValor() - numCasella;
            numCasellaDesti= 63 - numCasella;
        } else
            numCasellaDesti=fitxa.getCasella().getNumero() + dau.getValor();
        
        this.mouFitxa(numCasellaDesti);
 
        if (numCasellaDesti==63)
            return true;
        else
            return false;
    }
 }
