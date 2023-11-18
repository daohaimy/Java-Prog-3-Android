package orchester;

import audio.adapter.SimpleAudioPlayerAdapter;
import orchester.Orchester;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        /*HashSet<Nachbar> nachbars = new HashSet<>();
        Nachbar a = new Nachbar("Hai My", "Dao");
        Nachbar b = new Nachbar("Kevin", "Siofer");
        nachbars.add(a);
        nachbars.add(b);
        nachbars.add(a);
        nachbars.add(a);
        nachbars.add(a)

        System.out.print("Hallo ");
        System.out.print(nachbars.toString());*/

        String audioDatei = "/All_Together.wav";
        Orchester orchester = new Orchester("HSOS Titty Twister Orchestra", audioDatei);

        DirigentIn karajan = new DirigentIn("Karjan");
        orchester.setDirigentIn(karajan);

        MusikerIn trompete = new MusikerIn("Dirk Die Lunge Mueller", Instrument.TROMPETE);
        MusikerIn akkordion = new MusikerIn("Akki Taste", Instrument.AKKORDION);
        MusikerIn drum = new MusikerIn("Das Biest", Instrument.SCHLAGZEUG);
        orchester.addMusikerIn(trompete);
        orchester.addMusikerIn(akkordion);
        orchester.addMusikerIn(drum);

        orchester.proben();
        //orchester.auftreten();
        try {
            orchester.spielen();
        }catch (IOException e){
            e.printStackTrace();
        }

    }


}