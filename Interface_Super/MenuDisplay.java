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
            System.out.println("\t\t\t\r\n" + //
                                "█████████████████▀███████████████████████████████████████████████████████████▀█████████████\r\n" + //
                                "█▄─▄▄▀█▄─▄▄─█─▄▄▄▄█▄─▄█─▄▄▄▄█─▄─▄─█▄─▄▄─█▄─▄▄▀███─▄▄─█▄─▄▄▀███▄─▄███─▄▄─█─▄▄▄▄█▄─▄█▄─▀█▄─▄█\r\n" + //
                                "██─▄─▄██─▄█▀█─██▄─██─██▄▄▄▄─███─████─▄█▀██─▄─▄███─██─██─▄─▄████─██▀█─██─█─██▄─██─███─█▄▀─██\r\n" + //
                                "▀▄▄▀▄▄▀▄▄▄▄▄▀▄▄▄▄▄▀▄▄▄▀▄▄▄▄▄▀▀▄▄▄▀▀▄▄▄▄▄▀▄▄▀▄▄▀▀▀▄▄▄▄▀▄▄▀▄▄▀▀▀▄▄▄▄▄▀▄▄▄▄▀▄▄▄▄▄▀▄▄▄▀▄▄▄▀▀▄▄▀");
            System.out.println("===========================================================================================");
            System.out.println("\t\t\tHello there!");
            System.out.println("\t\t\tHave you registered?");
            System.out.println();
            System.out.println("\t\t\tPress 1 - yes");
            System.out.println("\t\t\tPress 2 - no");
            System.out.println("\t\t\tPress 3 - show customers");
            System.out.println("\t\t\tPress 0 - exit");
            try {
                System.out.print("\t\t\t>");
                this.choice = scan.nextInt();
                scan.nextLine();
                if (choice == 0) {
                    clearScreen();
                    System.out.println("\t\t\tTHANK YOU FOR USING OUR PETCARE!");
                    break;
                } else if (choice == 1) {
                    clearScreen();
                    loginDisplay();
                    pressEnterToContinue();
                    break;
                } else if (choice == 2) {
                    clearScreen();
                    CustomerFunctions.registerCustomer();
                    pressEnterToContinue();
                } else if (choice == 3) {
                    clearScreen();
                    CustomerFunctions.printCustomers();
                    System.out.println();
                    pressEnterToContinue();
                    clearScreen();
                } else if (choice < 0) {
                    System.out.println();
                    System.out.println("\t\t\tYou inputted a negative number! Try again");
                    pressEnterToContinue();
                }
            } catch (InputMismatchException e) {
                System.out.println("\t\t\tInvalid Character! Please try again");
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
            System.out.println("\t\t\t \r\n" + //
                                " _                    _                                      _____             _        \r\n" + //
                                "| |                  (_)                                    /  __ \\           | |       \r\n" + //
                                "| |      ___    __ _  _  _ __    _   _   ___   _   _  _ __  | /  \\/  ___    __| |  ___  \r\n" + //
                                "| |     / _ \\  / _` || || '_ \\  | | | | / _ \\ | | | || '__| | |     / _ \\  / _` | / _ \\ \r\n" + //
                                "| |____| (_) || (_| || || | | | | |_| || (_) || |_| || |    | \\__/\\| (_) || (_| ||  __/ \r\n" + //
                                "\\_____/ \\___/  \\__, ||_||_| |_|  \\__, | \\___/  \\__,_||_|     \\____/ \\___/  \\__,_| \\___| \r\n" + //
                                "                __/ |             __/ |                                                 \r\n" + //
                                "               |___/             |___/                                                  \r\n" + //
                                "");
            System.out.println("================================================================================================");
            System.out.println();
            System.out.println("\t\t\tEnter Customer Code:");
            try {
                System.out.print("\t\t\t>");
                this.customerCode = scan.nextInt();
                if (QueueFunctions.isInQueue(customerCode) == 1) {
                    // Graph.shopMenu();
                    Menu.MainDisplayServices();
                    clearScreen();
                    registrationDisplay();
                } else if (QueueFunctions.isInQueue(customerCode) == 2) {
                    System.out.println("\t\t\tYou have to wait");
                    longPause();
                    pressEnterToContinue();
                    registrationDisplay();
                } else if (customerCode < 0) {
                    System.out.println("\t\t\tYou entered a negative number! Try again!");
                    pressEnterToContinue();
                    clearScreen();
                } else {
                    System.out.println("\t\t\tYour code is nowhere to be found!");
                    longPause();
                    pressEnterToContinue();
                    registrationDisplay();
                }
            } catch (InputMismatchException e) {
                System.out.println("\t\t\tInvalid Character! Please try again");
                scan.nextLine(); // Consume invalid input
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
