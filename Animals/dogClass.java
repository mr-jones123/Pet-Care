package Animals;

import Interface_Super.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import Customers.queueSystem;

public class dogClass extends superClass implements interfaceClass {
    private int amount, choice;
    Scanner scan = new Scanner(System.in);
    queueSystem Queue = new queueSystem();
    superClass x = new superClass();
    HashMap<String, Integer> dogMedicalTests = new HashMap<>(x.getTests());
    HashMap<String, Integer> dogMedicalServices = new HashMap<>(x.getMedicalServices());

    @Override
    public void clearScreen() {
        System.out.print(   "\033[H\033[2J");
        System.out.flush();
    }

    @Override
    public void pay(HashMap<String, Integer> services) {
        System.out.println("Enter Service:");
        System.out.print(">");
        String service = scan.nextLine();
        System.out.println("Enter amount:");
        System.out.print(">");
        amount = scan.nextInt();
        amountChecker(service, amount, services);
    }

     @Override
    public void mainMenu() {
        while (true) {
            clearScreen();
            System.out.println("MEDICAL SERVICES");
            System.out.println("=============================");
            System.out.println("Pick the best option for your cat: ");
            System.out.println();
            System.out.println("Press 1 - Test");
            System.out.println("Press 2 - Emergency Service");
            System.out.println("Press 3 - For Description");
            System.out.print(">");
            try {
                choice = scan.nextInt();
                scan.nextLine();
                if (choice == 1) {
                    clearScreen();
                    printDogMedicalTests();
                    pay(dogMedicalTests);
                    break;
                } else if (choice == 2) {
                    clearScreen();
                    printDogMedicalServices();
                    pay(dogMedicalServices);
                    break;

                } else if (choice == 3) {
                    clearScreen();
                    printDescription();
                    System.out.println();
                    pressEnterToContinue();
                }

            } catch (InputMismatchException e) {
                System.out.println("WRONG INPUT! TRY AGAIN!");
                scan.nextLine();
                pressEnterToContinue();
                continue;
            }   
        }

    }

    @Override
    public void printDescription() {
        System.out.println(
                "TEST - For checkup and quick test for your dog. This service includes a comprehensive examination of your dog's health, including physical examination, blood tests, and diagnostics if necessary. "
                        +
                        "It is designed to detect any potential health issues and provide early intervention. Our experienced veterinarians will ensure that your dog receives the best care and attention during the testing process. "
                        +
                        "Regular checkups and tests are essential for maintaining your dog's overall well-being and preventing any potential health problems.");
        System.out.println();
        System.out.println(
                "EMERGENCY SERVICES - For surgeries and other medical services. Our emergency services are available 24/7 to provide immediate medical attention to your cat in critical situations. "
                        +
                        "Our skilled veterinarians and medical staff are trained to handle emergencies and perform life-saving procedures. Whether it's a serious injury, sudden illness, or any other emergency, "
                        +
                        "you can rely on our team to provide prompt and effective care.");
    }

    @Override
    public void printReceipt(String service, int amount, int change) {
        clearScreen();
        System.out.println("RECEIPT");
        System.out.println("-----------------------------");
        System.out.println();
        System.out.println("Service: " + service);
        System.out.println("Amount paid: $" + amount);
        System.out.println("Change: $" + change);
    }

    @Override
    public void amountChecker(String service,int amount, HashMap<String, Integer> services){
        for (Map.Entry<String, Integer> entry : services.entrySet()) {
            if (service.equalsIgnoreCase(entry.getKey())){
                if (amount >= entry.getValue()) {
                    int change = amount - entry.getValue();
                    printReceipt(service, amount, change);
                    System.out.println();
                    pressEnterToContinue();
                    Queue.removeFirst();
                    return;
                }
            }
        }
        System.out.println("Insufficient amount or service not available.");
        longPause();
        pressEnterToContinue();
    } 
    private void printDogMedicalTests() {
        System.out.println("AVAILABLE TEST FOR DOGS: ");
        System.out.println();
        for (Map.Entry<String, Integer> entries : dogMedicalTests.entrySet()) {
            System.out.println(entries.getKey() + "  $" + entries.getValue());
        }
    }

    private void printDogMedicalServices() {
        System.out.println("AVAILABLE MEDICAL SERVICES FOR DOGS: ");
        System.out.println();
        for (Map.Entry<String, Integer> entries : dogMedicalServices.entrySet()) {
            System.out.println(entries.getKey() + "  $" + entries.getValue());
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
