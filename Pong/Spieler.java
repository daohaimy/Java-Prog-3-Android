import util.EinUndAusgabe;
import util.Interaktionsbrett;

public class Spieler {
    private Spielfeld spielfeld = new Spielfeld();
    private int breiteSpieler = spielfeld.getSpielfeldBreite()/100;
    private int hoeheSpieler = spielfeld.getSpielfeldHoehe()/10;
    private int x;
    private int y;
    private Rechteck schlaeger;

    public Spieler(int x, int y) {
        this.x = x;
        this.y = y;
        schlaeger = new Rechteck(x,y, breiteSpieler, hoeheSpieler);
    }

    private int punkte;


    public Rechteck getSchlaeger(){
        return schlaeger;
    }

    public void aufwaerts(){
        y-=10;
        if(y < spielfeld.getMargin()*2){
            y = spielfeld.getMargin()*2;
        }
        schlaeger = new Rechteck(x,y, breiteSpieler, hoeheSpieler);
    }
    public void abwaerts(){
        y+=10;
        if(y > spielfeld.getSpielfeldHoehe()-spielfeld.getMargin()*2){
            y = spielfeld.getSpielfeldHoehe()-spielfeld.getMargin()*2;
        }
        schlaeger = new Rechteck(x,y, breiteSpieler, hoeheSpieler);
    }
    public void erhoehePunkte(){
        this.punkte++;
    }
    public void setzePunkteZurueck(){
        this.punkte = 0;
    }
    public int getPunkte(){
        return punkte;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getBreiteSpieler() {
        return breiteSpieler;
    }

    public int getHoeheSpieler() {
        return hoeheSpieler;
    }
}
