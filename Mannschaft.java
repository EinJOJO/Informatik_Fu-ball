public class Mannschaft {
    
    private final String name;
    private Spieler[] spieler;
    private int geschosseneTore;
    private int gegnerTore;
    private int punkte;
    
    public Mannschaft(String name) {
        this.spieler = new Spieler[20];
        this.name = name;
    }
    

    public Mannschaft(String name, Spieler[] spieler) {
        this.name = name;
        this.spieler = spieler;
    }

    public void ergebnisEintragen(int eigeneTore, int gegnerTore) {
        this.geschosseneTore = eigeneTore;
        this.gegnerTore = gegnerTore;

        if (eigeneTore == gegnerTore) {
            punkte = 0;
        } else if (eigeneTore > gegnerTore) {
            punkte++;
        } else {
            punkte--;
        }

    }


    public String getName() {
        return this.name;
    }



    public Spieler[] getSpieler() {
        return this.spieler;
    }

    public void setSpieler(Spieler[] spieler) {
        this.spieler = spieler;
    }
    

    public int getGeschosseneTore() {
        return this.geschosseneTore;
    }


    public int getGegnerTore() {
        return this.gegnerTore;
    }

    public int getPunkte() {
        return this.punkte;
    }

    public void spielerHinzufuegen(String name, int trikotNummer) {
        Spieler spieler = new Spieler(name, trikotNummer);
        spielerHinzufuegen(spieler);
    }

    public void spielerHinzufuegen(Spieler spieler) {
        for (int i = 0; i < this.spieler.length; i++) {
            if (this.spieler[i] == null) {
                this.spieler[i] = spieler;
                return;
            }
        }
        System.out.println("Kein Spieler konnte hinzugefügt werden");
    }


    

    

   
    
 
   
}