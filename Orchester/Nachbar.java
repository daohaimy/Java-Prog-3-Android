
public class Nachbar {
    private String vorname;
    private String nachname;

    public String getNachname() {
        return this.nachname;
    }
    public String getVorname() {
        return this.vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    public Nachbar(String vorname, String nachname){
        this.vorname = vorname;
        this.nachname = nachname;
    }

    @Override
    public String toString() {
        return this.vorname + " " + this.nachname;
    }
}
