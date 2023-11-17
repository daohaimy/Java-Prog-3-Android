import ui.NutzerEingabe;
import util.EinUndAusgabe;

public class NutzerEingabeTest {
    public static void main(String[] args) {
        EinUndAusgabe io = new EinUndAusgabe();
        NutzerEingabe n = new NutzerEingabe(io);
        n.anzahlZellenDesSpielfelds();
        n.anzahlDerSimulationsschritte();
        n.wahrscheinlichkeitDerBesiedlung();
    }
}
