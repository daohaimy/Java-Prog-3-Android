package audio.adapter;

import audio.StdAudioPlayer;
import de.hsos.prog3.audio.SimpleAudioPlayer;
import java.io.IOException;
import java.net.URL;

public class SimpleAudioPlayerAdapter implements StdAudioPlayer {
    private SimpleAudioPlayer s;
    private boolean tonAn = true;
    @Override
    public void einmaligAbspielen(URL url) throws IOException {
        s = new SimpleAudioPlayer(url);
        if(!tonAn){
            tonAus();
        }
        s.play(0);
    }

    @Override
    public void wiederholtAbspielen(URL url, int wiederholungen) throws IOException {
        s = new SimpleAudioPlayer(url);
        if(!tonAn){
            tonAus();
        }
        s.play(wiederholungen);
    }

    @Override
    public void tonAus() {
        s.setDebug(true);
        s.verboseLogging(true);
        tonAn = false;
    }
    @Override
    public void tonAn() {
        s.setDebug(false);
        s.verboseLogging(true);
        tonAn = true;
    }

}
