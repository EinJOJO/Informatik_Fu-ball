
public class Spieler
{
    private String name;
    private int trikotNummer;


    public Spieler(String name, int trikotNummer) {
        this.name = name;
        this.trikotNummer = trikotNummer;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrikotNummer() {
        return this.trikotNummer;
    }

    public void setTrikotNummer(int trikotNummer) {
        this.trikotNummer = trikotNummer;
    }
}
