package orchester;

public enum Instrument {
    TROMPETE("/Baritone.wav"),
    SCHLAGZEUG("/Drum.wav"),
    AKKORDION("/Accordion.wav");
    private String audiodatei;

    Instrument(String audiodatei){
        this.audiodatei = audiodatei;
    }

    String getAudiodatei(){
        return audiodatei;
    }

}