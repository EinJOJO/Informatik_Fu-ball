import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args ){
        
        Fussball game = new Fussball();
        int input = 0;
        while (true) {
            printMenu();
            input = scanner.nextInt();
            handleInput(input, game);
        }

    }

    public static void printMenu() {
        System.out.println("1. Mannschaft hinzufuegen");
        System.out.println("2. Tabelle anzeigen");
        System.out.println("3. Spieler hinzufuegen");
        System.out.println("4. Mannschaft anzeige");
        System.out.println("0. Beenden");
    }

    public static void handleInput(int input, Fussball game) {
        switch (input) {
                case 1:
                    System.out.println("Name der Mannschaft: ");
                    String name = scanner.next();
                    game.MannschaftHinzufuegen(new Mannschaft(name));
                    break;
                case 2:
                    game.tabelleAusgeben();
                    break;
                case 3:
                    System.out.println("Name der Mannschaft: ");
                    String mannschaftName = scanner.next();
                    System.out.println("Name des Spielers: ");
                    String spielerName = scanner.next();
                    System.out.println("Trikotnummer des Spielers: ");
                    int spielerNummer = scanner.nextInt();
                    game.getMannschaftByName(mannschaftName).spielerHinzufuegen(spielerName, spielerNummer);
                    break;
                case 4:
                    System.out.println("Name der Mannschaft: ");
                    String mannschaftName2 = scanner.next();
                    Mannschaft m4_ = game.getMannschaftByName(mannschaftName2);
                    mannschaftAusgeben(m4_);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Falsche Eingabe");
                    break;
            }
    }

    public static void mannschaftAusgeben(Mannschaft m) {
        System.out.println("Mannschaft: " + m.getName());
        System.out.println("Spieler: ");
        for (Spieler s : m.getSpieler()) {
            System.out.println(s.getName() + " " + s.getTrikotNummer());
        }
    }
}
