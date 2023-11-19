import util.EinUndAusgabe;
import util.Interaktionsbrett;

public class Pongspiel {
    private EinUndAusgabe ea = new EinUndAusgabe();
    private Spielfeld spielfeld;
    private Spieler spielerLinks;
    private Spieler spielerRechts;
    private Interaktionsbrett ib;
    private Ball ball;
    private KollisionsDetektion detektor;


    public Pongspiel(){
        ib = new Interaktionsbrett();
        ib.willTasteninfo(this);
        startAufstellung();
    }
    private void startAufstellung(){
        spielfeld = new Spielfeld();
        spielerLinks = new Spieler(spielfeld.getMargin()+spielfeld.getMargin(), spielfeld.getMargin()*2);
        spielerRechts = new Spieler(spielfeld.getSpielfeldBreite()-spielfeld.getMargin()/2, spielfeld.getMargin()*2);
        ball = new Ball();
        detektor = new KollisionsDetektion(spielfeld, spielerLinks, spielerRechts);
    }

    public void spiele() throws InterruptedException {
        KollisionsDetektion.Ballposition ballposition;
        while (true){
            ib.abwischen();
            spielfeld.darstellen(ib);
            spielerLinks.getSchlaeger().darstellenRahme(ib);
            spielerRechts.getSchlaeger().darstellenRahme(ib);
            ball.darstellen(ib);
            ball.bewegen(1);

            detektor.checkBeruehrungBallMitSchlaeger(ball);
            detektor.checkBeruehrungBallSpielfeldGrenzen(ball);

            ballposition = detektor.checkAusserhalbDesSpielfeldes(ball);
            if(ballposition == KollisionsDetektion.Ballposition.DRAUSSEN_RECHTS){
                spielerLinks.erhoehePunkte();
                ball = new Ball();
            }
            if(ballposition == KollisionsDetektion.Ballposition.DRAUSSEN_LINKS){
                spielerRechts.erhoehePunkte();
                ball = new Ball();
            }
            if(spielerLinks.getPunkte() == 15 || spielerRechts.getPunkte() == 15){
                System.exit(1);
            }

            ib.neuerText(spielfeld.getSpielfeldBreite()/2, spielfeld.getMargin()*2, Integer.toString(spielerLinks.getPunkte()));
            ib.neuerText(spielfeld.getSpielfeldBreite()/2 + spielfeld.getMargin()+spielfeld.getMargin()/2, spielfeld.getMargin()*2, Integer.toString(spielerRechts.getPunkte()));

            System.currentTimeMillis();
            Thread.sleep(17);
        }
    }

    public void tasteGedrueckt(String s){
        if(s.equals("s")){
            startAufstellung();
        }
        if(s.equals("e")){
            System.exit(1);
        }
        // Spieler
        if(s.equals("a")){
            spielerLinks.aufwaerts();
        }
        if(s.equals("y")){
            spielerLinks.abwaerts();
        }
        if(s.equals("o")){
            spielerRechts.aufwaerts();
        }
        if(s.equals("l")){
            spielerRechts.abwaerts();
        }
    }
}
