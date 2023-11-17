package ui;

import util.EinUndAusgabe;
import util.Interaktionsbrett;

public class NutzerEingabe {
    private EinUndAusgabe io;
    private int konstant = 100;
    public NutzerEingabe(EinUndAusgabe io){
        this.io = io;
    }
    public int anzahlZellenDesSpielfelds(){
        System.out.println("Anzahl der Zellen des Spielfelds (1 - 100): ");
        int anzahl = io.leseInteger();
        while (anzahl < 1 || anzahl > konstant){
            System.out.println("nur von 1 bis 100: ");
            anzahl = io.leseInteger();
        }
        return anzahl;
    }
    public int wahrscheinlichkeitDerBesiedlung(){
        System.out.println("Wahrscheinlichtkeit der Besiedlung (1 - 100): ");
        int wahrscheinlichkeit = io.leseInteger();
        while(wahrscheinlichkeit < 1 || wahrscheinlichkeit > 100){
            System.out.println("nur von 1 bis 100: ");
            wahrscheinlichkeit = io.leseInteger();
        }
        return wahrscheinlichkeit;
    }

    public int anzahlDerSimulationsschritte(){
        System.out.println("Anzahl durchzufuehrender Simulationschritte (nur bis 100 Schritte - mehr als 100 wird automatisch 100): ");
        int anzahl = io.leseInteger();
        if (anzahl > 100){
            anzahl = 100;
        }
        return anzahl;
    }
}
