package Animals;

import java.util.Scanner;
import java.util.ArrayList;
import Customers.*;
import Customers.customerSystem.customer;
import Interface_Super.MenuDisplay;
import Shops.menuGraph;
import Shops.reservationSystem;

public class Checkout {
    private dogClass DOG = new dogClass();
    private catClass CAT = new catClass();
    Scanner  scanner = new Scanner(System.in);
    private int customerPayment;
    private int change;
    private String name;
    private String petName;
    private String contactNo;
    private String reservedDate; 
    private int quantity;
    private int totalCost;
    private ArrayList<String> selectedServices;
    private ArrayList<Integer> selectedPrices;

    private customerSystem Customer = new customerSystem();
    private reservationSystem Reserve = new reservationSystem();
    private queueSystem Queue = new queueSystem();
    private MenuDisplay Menu = new MenuDisplay();
    private menuGraph MenuGraph = new menuGraph();
    // we used the new ArrayList to get the copy of the parameters
    //so that we don't modify the original values
    public Checkout(ArrayList<String> selectedServices,ArrayList<Integer> selectedPrices ){
        this.selectedServices = new ArrayList<>(selectedServices);
        this.selectedPrices = new ArrayList<>(selectedPrices);
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void checkoutFunction() throws Exception{
        clearScreen();
        System.out.println("\t \t \t \t--------------------------------------------------------");
        System.out.println("\t \t \t \t||                    CHECKING OUT......              ||");
        System.out.println("\t \t \t \t--------------------------------------------------------");
        System.out.println("  = Please enter the following: PET NAME, OWNER NAME, CONTACT No., and the number of sessions.");
        System.out.println("\t \t \t \t========================================================");

        Scanner scanner = new Scanner(System.in);
        Customer.printCurrentCustomer();

        System.out.print("\t \t \t \t$  - Pet Name: ");
        petName = scanner.nextLine();

        // Input validation for pet name (letters only)
        while (!petName.matches("[a-zA-Z ]+")) {
            System.out.println("  = Invalid input. Pet name must contain letters only. Please enter a valid pet name.");
            System.out.print("\t \t \t \t$  - Pet Name: ");
            petName = scanner.nextLine();
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
            System.out.println("\t\t\t = Invalid input. Number of sessions must be a positive number. Please enter a valid number of sessions.");
            System.out.print("\t \t \t \t$  - Number of Sessions: ");
            quantity = scanner.nextInt();
        }

        totalCost = 0;
        for (int i = 0; i < selectedServices.size(); ++i) {
            totalCost += selectedPrices.get(i) * quantity;
        }
        System.out.println("\t \t \t \t$  -Total Price:" + totalCost);
        System.out.println();
        System.out.print("\t \t \t \t$  -Enter your payment: $");
        customerPayment = scanner.nextInt();
        while (customerPayment < totalCost) {
            System.out.println("  = Your payment is insufficient");
            System.out.print("\t \t \t \t$  - Enter your payment: $");
            customerPayment = scanner.nextInt();
        }
        receipt();
        
    }
    public void receipt() throws Exception{
        clearScreen();
        System.out.println("\t \t \t \t--------------------------------------------------------");
        System.out.println("\t \t \t \t||                    RECEIPT                         ||");
        System.out.println("\t \t \t \t--------------------------------------------------------");
        Customer.printCurrentCustomer();
        name = Customer.getCustomerName();

        System.out.println("\t \t \t \t$  - Reserved Date: " + reservedDate);
        System.out.println("\t \t \t \t$  - Contact No.: " + contactNo);
        System.out.println("\t \t \t \t$  - Number of Sessions: " + quantity);
        System.out.println("\t \t \t \t$  - Selected Services:");
        for (int i = 0; i < selectedServices.size(); ++i) {
            System.out.println("\t \t \t \t   " + selectedServices.get(i) + ": $" + selectedPrices.get(i) + " per session");
        }
        change = totalCost - customerPayment;

        System.out.println("\t \t \t \t========================================================");
        System.out.println("\t \t \t \t$  - Total Cost: $" + totalCost);
        System.out.println("\t \t \t \t$  - Payment Amount: $" + customerPayment);
        System.out.println("\t \t \t \t$  - Change: $" + change);
        System.out.println("\t \t \t \t========================================================");
        System.out.println("\n\t\t\t  = Thank you for choosing our store!");
        System.out.println("\t\t\t  = We look forward to serving you and your pet again!");
        System.out.println("\t\t\t  = Have a wonderful day!");
        System.out.println("\n\t\t\tPress Enter to continue...");
        scanner.nextLine();
        Queue.removeFirst();
        Customer.removeOnMap(name);
        Menu.registrationDisplay();
    }
}
