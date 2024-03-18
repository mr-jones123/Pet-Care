package Animals;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Checkout {
    dogClass DOG = new dogClass();
    catClass CAT = new catClass();
    Scanner  scanner = new Scanner(System.in);
    private String petName;
    private String ownerName;
    private String contactNo;
    private int quantity;
    private int totalCost;
    private ArrayList<String> selectedServices;
    private ArrayList<Integer> selectedPrices;

    public Checkout(ArrayList<String> selectedServices,ArrayList<Integer> selectedPrices ){
        this.selectedServices = selectedServices;
        this.selectedPrices = selectedPrices;
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void checkoutFunction(){
        clearScreen();
        System.out.println("\t \t \t \t--------------------------------------------------------");
        System.out.println("\t \t \t \t||                    CHECKING OUT......              ||");
        System.out.println("\t \t \t \t--------------------------------------------------------");
        System.out.println("  = Please enter the following: PET NAME, OWNER NAME, CONTACT No., and the number of sessions.");
        System.out.println("\t \t \t \t========================================================");

        Scanner scanner = new Scanner(System.in);
        System.out.print("\t \t \t \t$  - Pet Name: ");
        petName = scanner.nextLine();

        // Input validation for pet name (letters only)
        while (!petName.matches("[a-zA-Z]+")) {
            System.out.println("  = Invalid input. Pet name must contain letters only. Please enter a valid pet name.");
            System.out.print("\t \t \t \t$  - Pet Name: ");
            petName = scanner.nextLine();
        }

        System.out.print("\t \t \t \t$  - Owner Name: ");
        ownerName = scanner.nextLine();

        // Input validation for owner name (letters only)
        while (!ownerName.matches("[a-zA-Z]+")) {
            System.out.println("  = Invalid input. Owner name must contain letters only. Please enter a valid owner name.");
            System.out.print("\t \t \t \t$  - Owner Name: ");
            ownerName = scanner.nextLine();
        }

        System.out.print("\t \t \t \t$  - Contact No.: ");
        contactNo = scanner.nextLine();

        // Input validation for contact number (numbers only)
        while (!contactNo.matches("[0-9]+")) {
            System.out.println("  = Invalid input. Contact number must contain numbers only. Please enter a valid contact number.");
            System.out.print("\t \t \t \t$  - Contact No.: ");
            contactNo = scanner.nextLine();
        }

        System.out.print("\t \t \t \t$  - Number of Sessions: ");
        quantity = scanner.nextInt();

        // Input validation for number of sessions (numbers only)
        while (quantity <= 0) {
            System.out.println("  = Invalid input. Number of sessions must be a positive number. Please enter a valid number of sessions.");
            System.out.print("\t \t \t \t$  - Number of Sessions: ");
            quantity = scanner.nextInt();
        }

        totalCost = 0;
        for (int i = 0; i < selectedServices.size(); ++i) {
            totalCost += selectedPrices.get(i) * quantity;
        }

        receipt();
    }
    public void receipt(){
        clearScreen();
        System.out.println("\t \t \t \t--------------------------------------------------------");
        System.out.println("\t \t \t \t||                    RECEIPT                         ||");
        System.out.println("\t \t \t \t--------------------------------------------------------");
        System.out.println("\t \t \t \t$  - Pet Name: " + petName);
        System.out.println("\t \t \t \t$  - Owner Name: " + ownerName);
        System.out.println("\t \t \t \t$  - Contact No.: " + contactNo);
        System.out.println("\t \t \t \t$  - Number of Sessions: " + quantity);
        System.out.println("\t \t \t \t$  - Selected Services:");

        for (int i = 0; i < selectedServices.size(); ++i) {
            System.out.println("\t \t \t \t   " + selectedServices.get(i) + ": $" + selectedPrices.get(i) + " per session");
        }

        System.out.println("\t \t \t \t========================================================");
        System.out.println("\t \t \t \t$  - Total Cost: $" + totalCost);
        System.out.println("\t \t \t \t========================================================");
        System.out.println("\n  = Thank you for choosing our store!");
        System.out.println("  = We look forward to serving you and your pet again!");
        System.out.println("  = Have a wonderful day!");
        System.out.println("\nPress Enter to continue...");

        // Wait for Enter key press
        scanner.nextLine();
    
    }
}
