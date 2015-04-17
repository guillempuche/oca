/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software;

import java.lang;

/**
 *
 * @author E6510
 */
public class Dau {
    private int valor;

    public Dau(int valor) {
        this.valor = 1;
    }
    
    // escollir numero aleatori
    public void tirar(){
        long a = 0;
        
        while(a == 0){
            a = System.nanoTime();
            a %= 6;  
        }
        
        valor = (int) a;
    }
    
    //El valor se asigna en el matodo tirar(), no necesitamos getVAlor para nada!!
    public int getValor(){
        return 0;
    }
}
