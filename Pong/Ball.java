import util.Interaktionsbrett;

public class Ball {
    private Rechteck form;
    private int bewegungInXProFrame;
    private int bewegungInYProFrame;
    int x = 50;
    int y = 50;
    int breite = 5;
    int hoehe = 5;
    public Ball(){
        form = new Rechteck(x,y,breite,hoehe);
        bewegungInXProFrame = 4;
        bewegungInYProFrame = 1;

    }
    public void bewegen(int anzahlFrames) throws InterruptedException {
        bewegungInXProFrame *= anzahlFrames;
        bewegungInYProFrame *= anzahlFrames;
        x += bewegungInXProFrame;
        y += bewegungInYProFrame;
        form = new Rechteck(x, y, breite, hoehe);
        System.currentTimeMillis();
        Thread.sleep(17);
    }

    public void darstellen(Interaktionsbrett ib){
        form.darstellenRahme(ib);
    }
    public void umkehrenDerBewegungInX(){
        bewegungInXProFrame *= -1;
    }
    public void umkehrenDerBewegungInY(){
        bewegungInYProFrame *= -1;
    }

    public void setBewegungInXProFrame(int bewegungInXProFrame) {
        this.bewegungInXProFrame = bewegungInXProFrame;
    }

    public void setBewegungInYProFrame(int bewegungInYProFrame) {
        this.bewegungInYProFrame = bewegungInYProFrame;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
