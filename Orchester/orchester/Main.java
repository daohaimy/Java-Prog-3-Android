package orchester;

import audio.adapter.SimpleAudioPlayerAdapter;

import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException{
        URL url = Main.class.getResource("/Drum.wav");

        SimpleAudioPlayerAdapter s = new SimpleAudioPlayerAdapter();
        s.einmaligAbspielen(url);
        s.tonAus();
        s.einmaligAbspielen(url);

        /*
        SimpleAudioPlayer player = new SimpleAudioPlayer(url);
        player.setDebug(false);
        player.verboseLogging(true);
        player.play(0);*/

    }
}
