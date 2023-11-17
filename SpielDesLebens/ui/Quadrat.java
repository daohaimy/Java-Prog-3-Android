package ui;

import util.Interaktionsbrett;

public class Quadrat {
    private int x;
    private int y;
    private int seitelaenge;
    public Quadrat(int x, int y, int seitelaenge){
        this.x = x;
        this.y = y;
        this.seitelaenge = seitelaenge;
    }

    public void darstellenRahme (Interaktionsbrett ib){
        ib.neuesRechteck(x, y, seitelaenge, seitelaenge);
    }
    public void dartellenFuellung (Interaktionsbrett ib){
        for (int i = 0; i < seitelaenge; i++){
            ib.neueLinie(x+i,y,x+seitelaenge,y+seitelaenge);
            ib.neueLinie(x,y+i,x+seitelaenge,y+seitelaenge);
        }
    }
}
