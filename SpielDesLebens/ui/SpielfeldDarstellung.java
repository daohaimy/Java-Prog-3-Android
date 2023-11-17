package ui;

import logik.Simulator;
import util.Interaktionsbrett;

public class SpielfeldDarstellung {
    private Interaktionsbrett ib;
    private final int margin = 20;
    private final int darstellungsBereich = 300;
    public SpielfeldDarstellung(Interaktionsbrett ib){
        this.ib = ib;
    }
    public void spielfeldDarstellen(boolean[][] spielfeld){
        //int x = margin;
        //int y = margin;
        for(int i = 0; i < spielfeld.length; i++){
            for(int j = 0; j < spielfeld[i].length; j++){
                Quadrat q = new Quadrat(margin+j*(darstellungsBereich/spielfeld.length),margin+i*(darstellungsBereich/spielfeld.length),darstellungsBereich/spielfeld.length);
                q.darstellenRahme(ib);
                if(spielfeld[i][j]){
                    q.dartellenFuellung(ib);
                }
               // x+=10;
            }
            //x=margin;
            //y += 10;
        }
    }


    public void abwischen(){
        ib.abwischen();
    }
}
