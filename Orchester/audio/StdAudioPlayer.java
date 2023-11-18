package audio;

import java.io.IOException;
import java.net.URL;
import de.hsos.prog3.audio.SimpleAudioPlayer;
public interface StdAudioPlayer {
    void einmaligAbspielen (URL url) throws IOException;
    void wiederholtAbspielen (URL url, int wiederholungen) throws IOException;
    void tonAn();
    void tonAus();
}
