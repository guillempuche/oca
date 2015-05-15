package software;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Preso extends Casella {
    public static final int TORNS_SENSE_TIRAR = 3;
    private Map<Fitxa,Integer> empresonades;
            
    public Preso (int numero, String descripcio){
        super(numero, descripcio);
        this.empresonades = new HashMap<>();
    }
    @Override
    public boolean completaJugada(Jugador jugador,
                     List<String> messages){
        jugador.setTornsSenseTirar(TORNS_SENSE_TIRAR);
        messages.add("El jugador té la fitxa empresonada i no pot tirar en aquest torn");
        return false;
    }
    
}
