package logik;
import ui.Quadrat;
import ui.SpielfeldDarstellung;
import ui.Steuerung;
import util.Interaktionsbrett;

import java.util.Random;

public class Simulator implements Simulation{
    private boolean[][] spielfeld;
    private int anzahlFelder;
    Interaktionsbrett ib = new Interaktionsbrett();
    SpielfeldDarstellung spielfeldDarstellung = new SpielfeldDarstellung(ib);

    @Override
    public void berechneAnfangsGeneration(int anzahlDerZellen, int wahrscheinlichkeiDerBesiedlung) {
        float wahrscheinlichkeit;

        anzahlFelder = anzahlDerZellen;
        wahrscheinlichkeit = wahrscheinlichkeiDerBesiedlung;
        spielfeld = new boolean[anzahlFelder][anzahlFelder];
        for(int i = 0; i < anzahlFelder; i++){
            for (int j = 0; j < anzahlFelder; j++){
                spielfeld[i][j] = Math.random() < wahrscheinlichkeit/100.0;
            }
        }
        spielfeldDarstellung.spielfeldDarstellen(spielfeld);
    }


    @Override
    public void berechneFolgeGeneration(int berechnungsschritte) throws InterruptedException {
        for (int bs = 0; bs < berechnungsschritte; bs++) {
            boolean[][] naesteGeneration = new boolean[anzahlFelder][anzahlFelder];
            for (int i = 0; i < spielfeld.length; i++) {
                for (int j = 0; j < spielfeld[i].length; j++) {
                    int bewohnteNachbarn = 0;
                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            if (x == 0 && y == 0) {
                                continue;
                            }
                            int newX = x + i;
                            int newY = y + j;
                            if (newX >= 0 && newX < spielfeld.length && newY >= 0 && newY < spielfeld[newX].length) {
                                if (spielfeld[newX][newY]) {
                                    bewohnteNachbarn++;
                                }
                            }
                        }
                    }
                    if (spielfeld[i][j]) {
                        if (bewohnteNachbarn == 2 || bewohnteNachbarn == 3) {
                            naesteGeneration[i][j] = true;
                        } else {
                            naesteGeneration[i][j] = false;
                        }
                    } else {
                        if (bewohnteNachbarn == 3) {
                            naesteGeneration[i][j] = true;
                        } else {
                            naesteGeneration[i][j] = false;
                        }
                    }
                }
            }
            spielfeld = naesteGeneration;
            /*Steuerung steuerung = new Steuerung();
            steuerung.aktualisiere(naechsteGeneration);*/
            spielfeldDarstellung.abwischen();
            spielfeldDarstellung.spielfeldDarstellen(spielfeld);
            Thread.sleep(150);
        }
    }


    @Override
    public void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAenderung) {
        if(beiAenderung != null) {
            beiAenderung.aktualisiere(spielfeld);
        }
    }
}
