package orchester;

public abstract class Mitglied {
    private String name;
    String getName(){
        return this.name;
    }

    public Mitglied (String name){
        this.name = name;
    }
}
