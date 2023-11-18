import audio.adapter.SimpleAudioPlayerAdapter;
import orchester.MusikerIn;
import orchester.Orchester;
import orchester.Verhalten;

import java.io.IOException;
import java.net.URL;

/*public class Probe1 implements Verhalten {
    @Override
    public void spielen(Orchester orchester) throws IOException{
        try {
            for(MusikerIn musikerIn : orchester.getMusikerInnen()){
                URL url = orchester.Main.class.getResource(musikerIn.getInstrument().getAudiodatei());
                //SimpleAudioPlayer simple = new SimpleAudioPlayer(url);
                SimpleAudioPlayerAdapter simpleAudioPlayerAdapter = new SimpleAudioPlayerAdapter();
                simpleAudioPlayerAdapter.einmaligAbspielen(url);
            }
        } catch (IOException var4) {
            var4.printStackTrace();
            throw new IOException("Probe wird abgebrochen", var4);
        }
    }
    Probe1(){}
}
*/