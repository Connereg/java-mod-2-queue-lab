import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // your code here
        Scanner scanner = new Scanner(System.in);
        boolean runAgain = true;

        // generate a queue of customers
        Queue<String> customerQueue = new LinkedList<String>();

        Table leftTable = new Table();
        Table rightTable = new Table();

        while (runAgain) {
            // Welcome to Restaurant
            welcomeMessage();

            // Ask user if they would like to check somone in or out of the restaurant
            String checkInOrOutVal = scanner.nextLine();
            if (checkInOrOutVal.equals("x")) {
                // IF they want to check in - Check if there is available table

                // - if a table is available: Check them in
                System.out.println("Please name the customer you would like to add to the table: ");
                String inputName = scanner.nextLine();

                Boolean leftTableIsOccupied = leftTable.isTableOccupied();
                Boolean rightTableIsOccupied = rightTable.isTableOccupied();

                if (!leftTableIsOccupied) {
                    leftTable.addOccupantToTable(inputName);
                    System.out.println("The Left table is currently occupied by: " + leftTable.getTableOccupantName());
                    System.out.println("The Right table is currently occupied by: " + rightTable.getTableOccupantName());
                } else if (!rightTableIsOccupied) {
                    rightTable.addOccupantToTable(inputName);
                    System.out.println("The Left table is currently occupied by: " + leftTable.getTableOccupantName());
                    System.out.println("The Right table is currently occupied by: " + rightTable.getTableOccupantName());
                } else {
                    // - if a table is not available: Put them on waiting list
                    customerQueue.add(inputName);
                    System.out.println("Person added to queue!");
                    System.out.println("The Left table is currently occupied by: " + leftTable.getTableOccupantName());
                    System.out.println("The Right table is currently occupied by: " + rightTable.getTableOccupantName());
                }
                // ELSE IF they want to check someone out -
            } else {
                System.out.println("Please name the customer you would like to check out of the restaurant: ");
                String inputName = scanner.nextLine();

                String leftPerson = leftTable.getTableOccupantName();
                String rightPerson = rightTable.getTableOccupantName();

                // - Free one of the tables that is taken
                // - immediately assign the table to the NEXT person on waiting list
                if (inputName.equals(leftPerson)) {
                    leftTable.removeOccupantFromTable();
                    String incomingGuest = customerQueue.poll();
                    leftTable.addOccupantToTable(incomingGuest);
                    System.out.println("The Left table is currently occupied by: " + leftTable.getTableOccupantName());
                    System.out.println("The Right table is currently occupied by: " + rightTable.getTableOccupantName());
                } else if (inputName.equals(rightPerson)) {
                    rightTable.removeOccupantFromTable();
                    String incomingGuest = customerQueue.poll();
                    rightTable.addOccupantToTable(incomingGuest);
                    System.out.println("The Left table is currently occupied by: " + leftTable.getTableOccupantName());
                    System.out.println("The Right table is currently occupied by: " + rightTable.getTableOccupantName());
                } else {
                    System.out.println("Nobody Home!");
                    System.out.println("The Left table is currently occupied by: " + leftTable.getTableOccupantName());
                    System.out.println("The Right table is currently occupied by: " + rightTable.getTableOccupantName());
                    return;
                }

            }

        }
        scanner.close();
    }

    public static void welcomeMessage() {
        System.out.println("Welcome to Del Monto's Gastro-Mexicana Restaurant! ");
        System.out.println("Would you like to check someone in or out of the restaurant?");
        System.out.println("Press 'x' to check someone in");
        System.out.println("Press 'o' to check someone out");
    }
}
