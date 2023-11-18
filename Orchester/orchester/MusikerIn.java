package orchester;

public class MusikerIn extends Mitglied {
    private Instrument instrument;
    MusikerIn(String name, Instrument instrument){
        super(name);
        this.instrument = instrument;
    }
    Instrument getInstrument(){
        return this.instrument;
    }
}
