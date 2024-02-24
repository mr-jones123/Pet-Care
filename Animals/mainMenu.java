package Animals;

import java.util.Scanner;

public class mainMenu {
    catClass Cat = new catClass();
    dogClass Dog = new dogClass();
    Scanner scan = new Scanner(System.in);
    private int choice;

    public void MainDisplayServices() {
        int choice;
        do {
            clearScreen();
            System.out.println("Welcome to Pet Care!");
            System.out.println();
            System.out.println("Do you have a cat or dog? ");
            System.out.println();
            System.out.println("Press 1 - Cat");
            System.out.println("Press 2 - Dog");
            choice = scan.nextInt();
    
            if (choice < 0){
                System.out.println("Negative Number. Please try again");
                System.out.println();
                pressEnterToContinue();
            } else if (choice == 1) {
                Cat.mainMenu();
            } else if (choice == 2) {
                Dog.mainMenu();
            } else {
                System.out.println("Invalid Option. Please try again");
                System.out.println();
                pressEnterToContinue();
            }
        } while (choice < 0);
    }


    private void pressEnterToContinue() {
        System.out.println("Press Enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
