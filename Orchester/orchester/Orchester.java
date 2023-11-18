package orchester;

import audio.StdAudioPlayer;
import audio.adapter.SimpleAudioPlayerAdapter;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;

public class Orchester {
    private String bezeichnung;
    private DirigentIn dirigentIn;
    private HashSet<MusikerIn> musikerInnen = new HashSet<>();
    private Verhalten verhalten;
    private String audioDateiKonzert;
    Orchester(String bezeichnung, String audioDateiKonzert){
        this.bezeichnung = bezeichnung;
        this.audioDateiKonzert = audioDateiKonzert;
    }
    public void setDirigentIn(DirigentIn dirigentIn){
        this.dirigentIn = dirigentIn;
    }
    public void addMusikerIn(MusikerIn musikerIn){
        musikerInnen.add(musikerIn);
    }
    public HashSet<MusikerIn> getMusikerInnen(){
        return this.musikerInnen;
    }
    public URL getAudiodateiKonzert(){
        return Main.class.getResource(audioDateiKonzert);
    }
    public void proben() throws IOException{
        verhalten = new Probe();
    }
    public void auftreten() throws IOException{
        verhalten = new Konzert();
    }
    public void spielen() throws IOException{
        verhalten.spielen(this);
    }
    public void getKonzertSound() throws IOException {
        SimpleAudioPlayerAdapter simpleAudioPlayerAdapter = new SimpleAudioPlayerAdapter();
        simpleAudioPlayerAdapter.einmaligAbspielen(getAudiodateiKonzert());
    }

    private class Probe implements Verhalten {
        @Override
        public void spielen(Orchester orchester) throws IOException{
            try {
                for(MusikerIn musikerIn : orchester.getMusikerInnen()){
                    URL url = Main.class.getResource(musikerIn.getInstrument().getAudiodatei());
                    StdAudioPlayer simpleAudioPlayerAdapter = new SimpleAudioPlayerAdapter();
                    simpleAudioPlayerAdapter.einmaligAbspielen(url);

                }
            } catch (IOException ioException) {
                throw new IOException("Probe wird abgebrochen");
            }
        }
        Probe(){}
    }

    private class Konzert implements Verhalten {
        @Override
        public void spielen(Orchester orchester) throws IOException {
            try {
                orchester.getKonzertSound();
            } catch (IOException ioException) {
                throw new IOException("Auftritt wird abgebrochen");
            }

        }
    }
}


/*
Vorteile:
    - Man muss nicht extra neue Klassedatei erstellen
    - Sichbarkeit auf private und geschützte Sichbarkeit setzen
    - einfache Zugriff aud Instanzvariablen der äußeren Klasse

Nachteile:
    - ist nicht verweiterbar
    - Verberbung ist schwierig, da es Sichbarkeitsproblem gibt
    - Beim Testen der Klasse ist es schwierig, da man die äußere Klasse zugreifen muss.

 */