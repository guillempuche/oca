package software;

import java.util.List;

public class Oca extends Casella{
    public Oca(int numero, String descripcio){
        super(numero, descripcio);
    }
    @Override
    public boolean completaJugada(Jugador jugador,
                     List<String> messages){
        int numCasellaAbansMoure=jugador.getFitxa().getCasella().numero;
        
        this.eliminaFitxa(jugador.getFitxa());
        if (jugador.getFitxa().getCasella().numero == 5 || 
                jugador.getFitxa().getCasella().numero == 14 ||
                jugador.getFitxa().getCasella().numero == 23 ||
                jugador.getFitxa().getCasella().numero == 32 ||
                jugador.getFitxa().getCasella().numero == 41 ||
                jugador.getFitxa().getCasella().numero == 50 ||
                jugador.getFitxa().getCasella().numero == 59)
            jugador.mouFitxa(jugador.getFitxa().getCasella().numero + 4);
        else 
            jugador.mouFitxa(jugador.getFitxa().getCasella().numero + 5);   
        
        int numCasellaDespresMoure=jugador.getFitxa().getCasella().numero;
         messages.add("Casella destí " + numCasellaAbansMoure + " (" + this.descripcio + ")" +
                "\nD'Oca a oca i tiro perquè em toca!\nCasella destí " + numCasellaDespresMoure 
         + " (" + this.descripcio + ")");
         
        // Si despres de tirar, el jugador situa fitxa a la casella 63 (ultima Oca)
        // s'acaba el torn
        if (jugador.getFitxa().getCasella().numero == 63)
            return true;
        else
            return false;
    }
}
