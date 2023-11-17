package logik;

public interface Simulation {
    void berechneAnfangsGeneration(int anzahlDerZellen, int wahrscheinlichkeiDerBesiedlung);
    void berechneFolgeGeneration(int berechnungsschritte) throws InterruptedException;
    void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAenderung);
}
