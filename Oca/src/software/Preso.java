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
        messages.add("Casella destí " + this.numero + " (" + this.descripcio + ")"+
                "\nEl jugador té la fitxa empresonada i no pot tirar en aquest torn" +
                
    "\n\n              `/:                 -::`                `::`        "+
    "\n              ./:`.:/:-`      `.::::...-:::-.       `-:::`.++`      "+
    "\n            ./-`ohys+-.-::---:-..:+syosss/-..::---::-.:oyyh/`++.    "+
    "\n          -/-.sy-   -/osssssssss+:.     `-/ossssssssso:.  `+h+`/+.  "+
    "\n         s-`sh-                                             `/d/ oy."+
    "\n         `o`:d.                                              +h`:No "+
    "\n          `+`:m.                                            +h`/N/  "+
    "\n           `o`/d`                                          /d`:N/   "+
    "\n           `o ss                  ARRESTAT                `m-.No     "+
    "\n             /..N`                                        +y sd`    "+
    "\n             -: N.                                        yo ho     "+
    "\n             +.-m                   PER                   /h oy     "+
    "\n            `o yo                                         `m-.m.    "+
    "\n            +`-m`                                          /h +y    "+
    "\n           -:`d:                     LA                     h+`h/   "+
    "\n          `o oy                                             .m..m`  "+
    "\n          +..m`                   POLICIA!                   oy os  "+
    "\n         `o y+                                               `m:`m. "+
    "\n         +.-N`                                                +h oy "+
    "\n         o +y                                                 .N`-N "+
    "\n         + ss                                                 `M..M`"+
    "\n         o`:d`                                                /d +N`"+
    "\n         `o +h`           3 torns sense poder jugar          /d..No "+
    "\n          .+.:ho.                                          :yo`/Ns  "+
    "\n            /+.-syo:`                                  ./sy+`:hd:   "+
    "\n             `+o+../osssssso+:.`            .:/+sssssss+:.:omh/     "+
    "\n                ./ssso+/:-..-:+ssso/. `-+ssso/-..-://+oyhhs/`       "+
    "\n                     .--:/+ossso/-.:oys/-.:oyhhhso+/:--`            "+
    "\n                               `-/ooo-/ydyo:.                       "+
    "\n                                    `/y:                            \n\n");
        return false;
    }
    
}
