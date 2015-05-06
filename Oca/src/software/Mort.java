package software;

import java.util.List;

public class Mort extends Casella{
    public Mort (int numero, String descripcio){
        super(numero, descripcio);
    }
    
    public boolean completaJugada(Jugador jugador,
                     List<String> messages){
        this.eliminaFitxa(jugador.getFitxa());
        jugador.getFitxa().getCasella().numero = 1;
        jugador.mouFitxa(1);
        messages.add(descripcio);
        return false;
    }
}
