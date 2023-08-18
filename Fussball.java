public class Fussball
{
    private Mannschaft[] mannschaften = new Mannschaft[0];
    private Mannschaft siegerMannschaft = null;
    private String[][] tabelle = new String[0][0];    

    
    
    public Fussball() {
    }


    public Fussball(Mannschaft[] mannschaften) {
        this.mannschaften = mannschaften;
    }



    // Turniertabelle
    public void tabelleFuellen() {
        tabelle = new String[mannschaften.length + 1][4];
        Mannschaft[] mannschaften = getSortierteMannschaftenNachPunkte();
        tabelle[0] = new String[]{"Mannschaft", "Punkte", "Tore", "GegnerTore"}; // Kopfzeile
        for (int i  = 0 ; i < mannschaften.length ; i++) {
            Mannschaft mannschaft = mannschaften[i];
            if (mannschaft == null) continue;
            String name = mannschaft.getName();
            String punkte = String.valueOf(mannschaft.getPunkte());
            String tore = String.valueOf(mannschaft.getGeschosseneTore());
            String gegnerTore = String.valueOf(mannschaft.getGegnerTore());
            String[] zeile = {name, punkte, tore, gegnerTore};
            tabelle[i + 1] = zeile;
        }
    }

    public Mannschaft getMannschaftByName(String name) {
        for (Mannschaft mannschaft : mannschaften) {
            if (mannschaft == null) continue;
            if (mannschaft.getName().equalsIgnoreCase(name)) {
                return mannschaft;
            }
        }
        return null;
    }

    public void tabelleAusgeben() {
        tabelleFuellen();
        System.out.println("Tabelle:");
        /*
        for (int i = 0; i < tabelle.length; i++) {
            String[] zeile = tabelle[i];
            for (int j = 0; j < zeile.length; j++) {
                String spalte = zeile[j];
                System.out.print(spalte + "\t");
            }
            System.out.println();
        }
        */
        FormattedTable.printFormat(tabelle);
        System.out.println();
    }

    public Mannschaft[] getSortierteMannschaftenNachPunkte() {
        Mannschaft[] sortierteMannschaften = new Mannschaft[mannschaften.length];
        for (int i = 0; i < mannschaften.length; i++) { 
            Mannschaft mannschaft = mannschaften[i];
            if (mannschaft == null) continue;
            int punkte = mannschaft.getPunkte();
            for (int j = 0; j < sortierteMannschaften.length; j++) { // Alle Einträge im sortierten Array durchgehen
                if (sortierteMannschaften[j] == null) { // Wenn aktelle Mannschaft noch nicht im sortierten Array ist bzw. noch kein Eintrag vorhanden ist
                                                        // Ist der Fall, wenn das sortierte Array noch leer ist oder wenn die aktuelle Mannschaft mehr Punkte hat als alle anderen
                    sortierteMannschaften[j] = mannschaft; 
                    break;
                } else if (sortierteMannschaften[j].getPunkte() < punkte) { // Wenn die Punkte der aktuellen Mannschaft größer sind als die der Mannschaft in dem sortierten Array
                    for (int k = sortierteMannschaften.length - 1; k > j; k--) { // Alle Einträge nach hinten verschieben
                        sortierteMannschaften[k] = sortierteMannschaften[k - 1]; 
                    }
                    sortierteMannschaften[j] = mannschaft; 
                    break;
                }
            }
        }
        return sortierteMannschaften;
    }

    public static void testRun() {
        Fussball game = new Fussball();
        Mannschaft m1 = new Mannschaft("m1");
        Mannschaft m2 = new Mannschaft("m2");
        game.MannschaftHinzufuegen(m1);
        game.MannschaftHinzufuegen(m2);
        game.matchErgebnisEintragen("m1", "m2", 2, 4);
        game.tabelleAusgeben();
        
        
    }


    
    public void matchErgebnisEintragen(String team1, String team2, int tore1, int tore2) {
        for (Mannschaft mannschaft : mannschaften) {
            if (mannschaft == null) continue;
            if (mannschaft.getName().equalsIgnoreCase(team1)) {
                mannschaft.ergebnisEintragen(tore1, tore2);
            } else if (mannschaft.getName().equalsIgnoreCase(team2)) {
                mannschaft.ergebnisEintragen(tore2, tore1);
            } 
        }
    }

    public void siegerFestlegen() {
        Mannschaft[] sortierteMannschaften = getSortierteMannschaftenNachPunkte();
        this.siegerMannschaft = sortierteMannschaften[0];
    }

    public void siegerAusgeben() {
        System.out.println("Sieger: " + this.siegerMannschaft.getName());
    }

    // Turniertabelle Ende

    public void turnierStarten() {
        //impl.
    }

    public void MannschaftHinzufuegen(Mannschaft mannschaft) {
        if (this.mannschaften.length == 0) {
            this.mannschaften = new Mannschaft[20];
        }
        for (int i = 0; i < this.mannschaften.length ; i++) {
            if (this.mannschaften[i] == null) {
                this.mannschaften[i] = mannschaft;
                break;
            }
        }
    }

    public Mannschaft[] getMannschaften() {
        return this.mannschaften;
    }

    public void setMannschaften(Mannschaft[] mannschaften) {
        this.mannschaften = mannschaften;
    }

    public Mannschaft getSiegerMannschaft() {
        return this.siegerMannschaft;
    }

    public void setSiegerMannschaft(Mannschaft siegerMannschaft) {
        this.siegerMannschaft = siegerMannschaft;
    }
    
    
}
