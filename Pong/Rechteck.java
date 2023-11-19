import util.Interaktionsbrett;

public class Rechteck {
    private int x;
    private int y;
    private int breite;
    private int hoehe;
    public Rechteck(int x, int y, int breite, int hoehe){
        this.x = x;
        this.y = y;
        this.breite = breite;
        this.hoehe = hoehe;
    }

    int oben(){
        return this.y;
    }
    int unten(){
        return this.y + this.hoehe;
    }
    int links(){
        return this.x;
    }
    int rechts(){
        return this.x + this.breite;
    }
    int breite(){
        return this.breite;
    }
    int hoehe(){
        return this.hoehe;
    }
    int mitteInY(){
        return (oben()+unten())/2;
    }
    int mittelInX(){
        return (links()+rechts())/2;
    }
    public void verschiebe(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }
    public void verschiebenNach(int x, int y){
        this.x = x;
        this.y = y;
    }
    public boolean ueberschneidet(Rechteck o){
        return this.links() < o.rechts() &&
                this.rechts() > o.links() &&
                this.oben() < o.unten() &&
                this.unten() > o.oben();
    }
    public void darstellenRahme (Interaktionsbrett ib){
        ib.neuesRechteck(x, y, breite, hoehe);
    }
    public void dartellenFuellung (Interaktionsbrett ib){

    }
}
