package software;

import java.util.List;

public class Oca extends Casella{
    public Oca(int numero, String descripcio){
        super(numero, descripcio);
    }
    public boolean completaJugada(Jugador jugador,
                     List<String> messages){
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
        
        messages.add(descripcio);
        if (jugador.getFitxa().getCasella().numero == 63)
            return true;
        else
            return false;
    }
}
