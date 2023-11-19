import util.Interaktionsbrett;

public class Spielfeld {
    private final int spielfeldBreite = 400;
    private final int spielfeldHoehe = 350;
    private final int margin = 20;
    private final Rechteck spielflaeche = new Rechteck(margin, margin,spielfeldBreite, spielfeldHoehe);

    public void darstellen(Interaktionsbrett ib){
        ib.neueLinie(spielfeldBreite/2 + margin,margin, spielfeldBreite/2 + margin, spielfeldHoehe+margin);
        spielflaeche.darstellenRahme(ib);
    }

    public int getMargin() {
        return margin;
    }

    public int getSpielfeldBreite() {
        return spielfeldBreite;
    }

    public int getSpielfeldHoehe() {
        return spielfeldHoehe;
    }

}
