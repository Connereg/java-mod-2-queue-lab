public class Table {

    private String tableOccupant;

    public void addOccupantToTable(String userInput) {
        tableOccupant = userInput;
    }

    public void removeOccupantFromTable() {
        tableOccupant = null;
    }

    public boolean isTableOccupied() {
        if (tableOccupant == null) {
            System.out.println("Table is Open");
            return false;
        } else {
            System.out.println("This table is full");
            return true;
        }
    }

    public String getTableOccupantName() {
        return tableOccupant;
    }
}
