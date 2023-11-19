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
        if (ball.getY() - spielfeld.getMargin() <= 0 || ball.getY() >= spielfeld.getSpielfeldHoehe()+spielfeld.getMargin()) {
            ball.umkehrenDerBewegungInY();
        }
    }
    public void checkBeruehrungBallMitSchlaeger(Ball ball){
        if (ball.getX() >= spielerLinks.getX() && ball.getX() <= spielerLinks.getX() + spielerLinks.getBreiteSpieler()
            && ball.getY() >= spielerLinks.getY() && ball.getY() <= spielerLinks.getY() + spielerLinks.getHoeheSpieler()) {
            if (Math.random() < 0.5) {
                ball.umkehrenDerBewegungInX();
            } else {
                ball.umkehrenDerBewegungInX();
                ball.umkehrenDerBewegungInY();
            }
        }
        if (ball.getX() >= spielerRechts.getX() && ball.getX() <= spielerRechts.getX() + spielerRechts.getBreiteSpieler()
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
        if(ball.getX() > spielfeld.getSpielfeldBreite()+spielfeld.getMargin()){
            return Ballposition.DRAUSSEN_RECHTS;
        }
        if(ball.getX() < spielfeld.getMargin()){
            return Ballposition.DRAUSSEN_LINKS;
        }
        return Ballposition.DRINNEN;
    }
}
