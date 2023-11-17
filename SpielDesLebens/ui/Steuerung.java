package ui;

import logik.BeiAenderung;
import logik.Simulator;
import util.EinUndAusgabe;
import util.Interaktionsbrett;

public class Steuerung implements BeiAenderung {
    private Interaktionsbrett ib = new Interaktionsbrett();
    private SpielfeldDarstellung spielfeldDarstellung = new SpielfeldDarstellung(ib);
    private EinUndAusgabe io = new EinUndAusgabe();
    private NutzerEingabe nutzerEingabe = new NutzerEingabe(io);
    private Simulator simulator = new Simulator();
    public void startDesSpiels(){
        initialisierung();
    }
    private void initialisierung(){
        int anzahlZellen = nutzerEingabe.anzahlZellenDesSpielfelds();
        int wahrscheinlichkeit = nutzerEingabe.wahrscheinlichkeitDerBesiedlung();
        simulator.berechneAnfangsGeneration(anzahlZellen, wahrscheinlichkeit);
        int berechneSchritte;
        do {
            berechneSchritte = nutzerEingabe.anzahlDerSimulationsschritte();
            try {
                simulator.berechneFolgeGeneration(berechneSchritte);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (berechneSchritte > 0);
        if(berechneSchritte < 0){
            System.out.println("Tschuess!!!");
            //System.exit(1);
        }
    }

    @Override
    public void aktualisiere(boolean[][] neu) {
        spielfeldDarstellung.abwischen();
        spielfeldDarstellung.spielfeldDarstellen(neu);
    }
}
