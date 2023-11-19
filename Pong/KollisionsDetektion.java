public class KollisionsDetektion {
    Spielfeld spielfeld;
    Spieler spielerLinks;
    Spieler spielerRechts;
    public KollisionsDetektion(Spielfeld spielfeld, Spieler spielerLinks, Spieler spielerRechts){
        this.spielfeld = spielfeld;
        this.spielerLinks = spielerLinks;
        this.spielerRechts = spielerRechts;
    }
    public void checkBeruehrungBallSpielfeldGrenzen(Ball ball){
        if (ball.getY() - spielfeld.getMargin()-2 <= 0 || ball.getY() >= spielfeld.getSpielfeldHoehe()+spielfeld.getMargin()-4) {
            ball.umkehrenDerBewegungInY();
        }
    }
    public void checkBeruehrungBallMitSchlaeger(Ball ball){
        if (ball.getX()-4 >= spielerLinks.getX() && ball.getX()-4 <= spielerLinks.getX() + spielerLinks.getBreiteSpieler()
            && ball.getY() >= spielerLinks.getY() && ball.getY() <= spielerLinks.getY() + spielerLinks.getHoeheSpieler()) {
            if (Math.random() < 0.5) {
                ball.umkehrenDerBewegungInX();
            } else {
                ball.umkehrenDerBewegungInX();
                ball.umkehrenDerBewegungInY();
            }
        }
        if (ball.getX()+4 >= spielerRechts.getX() && ball.getX()+4 <= spielerRechts.getX() + spielerRechts.getBreiteSpieler()
            && ball.getY() >= spielerRechts.getY() && ball.getY() <= spielerRechts.getY() + spielerRechts.getHoeheSpieler()) {
            if (Math.random() < 0.5) {
                ball.umkehrenDerBewegungInX();
            } else {
                ball.umkehrenDerBewegungInX();
                ball.umkehrenDerBewegungInY();
            }
        }
    }

    public enum Ballposition{DRINNEN, DRAUSSEN_LINKS, DRAUSSEN_RECHTS}
    Ballposition checkAusserhalbDesSpielfeldes(Ball ball){
        if(ball.getX()+5 > spielfeld.getSpielfeldBreite()+spielfeld.getMargin()){
            return Ballposition.DRAUSSEN_RECHTS;
        }
        if(ball.getX() < spielfeld.getMargin()){
            return Ballposition.DRAUSSEN_LINKS;
        }
        return Ballposition.DRINNEN;
    }
}
