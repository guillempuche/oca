package software;

import java.util.List;

public class Mort extends Casella{
    public Mort (int numero, String descripcio){
        super(numero, descripcio);
    }
    
    @Override
    public boolean completaJugada(Jugador jugador,
                     List<String> messages){
        this.eliminaFitxa(jugador.getFitxa());
        jugador.getFitxa().getCasella().numero = 1;
        jugador.mouFitxa(1);
        messages.add("Casella destí " + 58 + " (" + this.descripcio + ")\n" +                

 "\n                               .:+oyyhhhhhhhhhyo+:.                    "+
 "\n                           .+hhy+:-`          `-/oyhh+.                "+
 "\n                         -hd+`                      `+dy-              "+
 "\n                        sm:                            /ms             "+
 "\n                      `dh`                              `hh`           "+
 "\n                     yd`                                `ms            "+
 "\n                     .N/ +s                            os /N`          "+
 "\n                     -M- ds                            +N .M-          "+
 "\n                     `N/ yd                            yd -M-          "+
 "\n                      yd .N+                          :N- sd           "+
 "\n                      .No hh  .:/+oss/      :sso+/:.  sd /N-           "+
 "\n                       -msdy yMMMMMMMM/    :MMMMMMMMh`omsm-            "+
 "\n                        `yM/`mMMMMMMMm.    `mMMMMMMMN`-My`             "+
 "\n               sdhy-     +N` -NMMMMMh`      `yMMMMMN:  dy     :hhdy    "+
 "\n              :M. /N/    om   .odmh:  `soos`  :ydds.   hh    +N- .M:   "+
 "\n             :dh   -hho- -N/         `dMssMm`         -N/`:ohh-   hd:  "+
 "\n            yd-      `:shhdMdo/.     /MMssMM/     ./ohMmhho:`      -dy "+
 "\n            sdhyhhhy+-   `:ohMhNds`  .Nd--dN-  `odNhMho:`   -+yhhhyhdo "+
 "\n               `   `/shho:`  +N++sm`           hho+N+  `:ohhs/.   `    "+
 "\n                       `:ohhs/Noy.h+/:/::/::_+/h-y+N/shho:`            "+
 "\n                          `:sdM+`oy/s:y+oy:s:/yo`+Mhs/.                "+               
 "\n                          `:sdM+`oy/s:y+  :s:/yo`+Mhs/.                "+
 "\n                 ...``./shho- sm` `:/o/s+os/o/:` `dy -+yhy+-``..`      "+
 "\n               -myosyys+-   `:sNm:              :mNs:`   ./syysoym:    "+
 "\n               .dy-      -ohho- -hdo:.``  ``./ody- -ohho:`     .sm-    "+
 "\n                 :mo   sms:`      `:+syyyyyys+-`      `-ody`  +N/      "+
 "\n                  om .dh`                                 yd. hh       "+
 "\n                  .hhh/                                    /hhh.     \n\n");
        return false;
    }
}
