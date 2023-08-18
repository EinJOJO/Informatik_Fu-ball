/**
 * Kann genutzt werden, um eine Tabelle mit beliebigen Objekten auszugeben.
 * @author Johannes 14.08.2022
 * 
 * Usage: 
 * 1. FormattedTable.format( table[][] );
 * 2. new FormattedTable( table[][] ).printTable();
 */
public class FormattedTable<T> {

    private T[][] table;
    private int[] columnFormats;

    public FormattedTable(T[][] table) {
        this.table = table;
        calculateColumnFormats();
    }

    public static <T> void printFormat(T[][] test) {
        new FormattedTable<T>(test).printTable();
    }

    private void calculateColumnFormats() {
    int columns = table[0].length;
    this.columnFormats = new int[columns];

    for (int j = 0; j < columns; j++) {
        int maxLengthInColumn = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i][j] == null) continue;
            int length = table[i][j].toString().length();
            if (maxLengthInColumn < length) {
                maxLengthInColumn = length;
            }
        }
        columnFormats[j] = maxLengthInColumn;
    }
    }


    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                Object string = table[i][j];
                if (string == null) continue;
                String value = string.toString();
                String emptySpace = getEmptySpace(columnFormats[j] - value.length() + 1);
                System.out.print(value + emptySpace);
            }
            System.out.println();
        }
    }

    private String getEmptySpace(int length) {
        StringBuilder emptySpace = new StringBuilder();
        for (int i = 0; i < length; i++) {
            emptySpace.append(" ");
        }
        return emptySpace.toString();
    }

    public void setTable(T[][] table) {
        this.table = table;
        calculateColumnFormats();
    }

    public T[][] getTable() {
        return this.table;
    }
}