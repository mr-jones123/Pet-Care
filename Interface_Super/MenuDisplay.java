package Interface_Super;
import Shops.*;
import Customers.*;
import Animals.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuDisplay {
    private int choice;
    private int customerCode;
    menuGraph Graph = new menuGraph();
    customerSystem CustomerFunctions = new customerSystem();
    queueSystem QueueFunctions = new queueSystem();
    mainMenu Menu = new mainMenu();
    Scanner scan = new Scanner(System.in);

    public void registrationDisplay() throws Exception {
        while (true) {
            clearScreen();
            System.out.println("REGISTRATION DISPLAY");
            System.out.println("=========================");
            System.out.println("Hello there!");
            System.out.println("Have you registered?");
            System.out.println();
            System.out.println("Press 1 - yes");
            System.out.println("Press 2 - no");
            System.out.println("Press 3 - show customers");
            System.out.println("Press 0 - exit");
            try {
                System.out.print(">");
                this.choice = scan.nextInt();
                scan.nextLine();
                if (choice == 0) {
                    clearScreen();
                    System.out.println("\t\t\tTHANK YOU FOR USING OUR PETCARE!");
                    break;
                } else if (choice == 1) {
                    clearScreen();
                    loginDisplay();
                    pause();
                    break;
                } else if (choice == 2) {
                    clearScreen();
                    CustomerFunctions.registerCustomer();
                    longPause();
                    pressEnterToContinue();
                } else if (choice == 3) {
                    clearScreen();
                    CustomerFunctions.printCustomers();
                    System.out.println();
                    pressEnterToContinue();
                    clearScreen();
                } else if (choice < 0) {
                    System.out.println();
                    System.out.println("You inputted a negative number! Try again");
                    pressEnterToContinue();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Character! Please try again");
                scan.nextLine();
                System.out.println();
                pressEnterToContinue();
                continue;
            }

        }
    }

    public void loginDisplay() throws Exception {
        while (true) {
            clearScreen();
            System.out.println("LOGIN YOUR CUSTOMER CODE");
            System.out.println("==============================");
            System.out.println();
            System.out.println("Enter Customer Code:");
            try {
            System.out.print(">");
            this.customerCode = scan.nextInt();
            if (QueueFunctions.isInQueue(customerCode) == 2) {
                Graph.shopMenu();
                Menu.MainDisplayServices();
                clearScreen();
                registrationDisplay();
            } else if (QueueFunctions.isInQueue(customerCode) == 1) {
                System.out.println("You have to wait");
                longPause();
                pressEnterToContinue();
                registrationDisplay();
            } else if (customerCode < 0) {
                System.out.println("You entered a negative number! Try again!");
                pressEnterToContinue();
                clearScreen();
            } else {
                System.out.println("Your code is nowhere to be found!");
                longPause();
                pressEnterToContinue();
                registrationDisplay();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Character! Please try again");
            scan.nextLine();
            System.out.println();
            pressEnterToContinue();
            continue;
        }
        }
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void pause() {
        try {
            Thread.sleep(5000); // Pause for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void longPause() {
        try {
            Thread.sleep(5000); // Pause for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void pressEnterToContinue() {
        System.out.println("Press Enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}
