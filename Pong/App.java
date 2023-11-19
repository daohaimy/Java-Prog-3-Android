import util.Interaktionsbrett;

public class App {
    public static void main(String[] args) throws InterruptedException {
        /*
        Spielfeld spielfeld = new Spielfeld();
        Spieler spieler = new Spieler();
        spielfeld.darstellen();
        spieler.getSchlaeger1().darstellenRahme(spielfeld.getIb());
        spieler.getSchlaeger2().darstellenRahme(spielfeld.getIb());*/

        Pongspiel pongspiel = new Pongspiel();
        pongspiel.spiele();
    }
}