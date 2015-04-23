package software;

public class Dau{
    private int valor;

    public Dau(){
        this.valor = 0;
    }
    
    public int getValor(){
        return this.valor;
    }
    
    // escollir numero aleatori
    public void tirar(){
        long a = 0;
        
        while(a == 0){
            a = System.nanoTime();
            a %= 6;  
        }
        
        this.valor = (int) a;
    } 
}