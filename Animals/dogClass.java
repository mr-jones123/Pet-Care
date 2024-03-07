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
        System.out.println("TESTS AND MEDICAL SERVICES DESCRIPTION");
        System.out.println("=======================================");
        System.out.println();
    
        // Routine Checkup
        System.out.println("Routine Checkup:");
        System.out.println("For a regular checkup and quick assessment of your cat's health. This service includes:");
        System.out.println("  - Physical examination");
        System.out.println("  - Blood tests");
        System.out.println("  - Diagnostic procedures if necessary");
        System.out.println("It is designed to detect potential health issues and provide early intervention.");
        System.out.println("Regular checkups are essential for maintaining your cat's overall well-being.");
        System.out.println();
    
        // Physical Exams
        System.out.println("Physical Exams:");
        System.out.println("A comprehensive examination of your cat's physical health, including:");
        System.out.println("  - Thorough physical examination");
        System.out.println("  - Assessment of vital signs");
        System.out.println("  - Evaluation of overall body condition");
        System.out.println("Physical exams help identify any abnormalities and ensure your cat's good health.");
        System.out.println();
    
        // Dental Checkups
        System.out.println("Dental Checkups:");
        System.out.println("Specialized care for your cat's dental health, including:");
        System.out.println("  - Dental examination");
        System.out.println("  - Teeth cleaning and scaling");
        System.out.println("  - Evaluation of oral hygiene");
        System.out.println("Maintaining dental health is crucial for preventing dental issues in your cat.");
        System.out.println();
    
        // Allergy Testing
        System.out.println("Allergy Testing:");
        System.out.println("Identification of potential allergies through:");
        System.out.println("  - Allergy testing procedures");
        System.out.println("  - Evaluation of allergic reactions");
        System.out.println("Knowing your cat's allergies helps in providing a safe and comfortable environment.");
        System.out.println();
    
        // Geriatric Screening
        System.out.println("Geriatric Screening:");
        System.out.println("Specialized screening for older cats to detect age-related health issues, including:");
        System.out.println("  - Comprehensive health assessment");
        System.out.println("  - Diagnostic tests for geriatric conditions");
        System.out.println("Regular geriatric screening is essential for the well-being of aging cats.");
        System.out.println();
    
        // Emergency Services
        System.out.println("EMERGENCY SERVICES:");
        System.out.println("For critical situations requiring immediate medical attention:");
        System.out.println("  - Bloodwork, X-Rays, Ultrasounds, Oxygen Therapy, Emergency Surgery");
        System.out.println("Our emergency services are available 24/7 to provide prompt and effective care.");
        System.out.println("Our skilled veterinarians and medical staff are trained to handle emergencies.");
        System.out.println("Whether it's a serious injury, sudden illness, or any other emergency, rely on our team.");
        System.out.println();
    
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
        System.out.println("AVAILABLE TESTS FOR DOGS:");
        System.out.println();
    
        // Routine Checkup
        System.out.println("1. Routine Checkup:");
        System.out.println("   A regular checkup and quick assessment of your dog's health, including:");
        System.out.println("   - INCLUSION:");
        System.out.println("   - Physical examination");
        System.out.println("   - Blood tests");
        System.out.println("   - Diagnostic procedures if necessary");
        System.out.println("   Designed to detect potential health issues and provide early intervention.");
        System.out.println("   - $50.00");
        System.out.println();
    
        // Physical Exams
        System.out.println("2. Physical Exams:");
        System.out.println("   A comprehensive examination of your dog's physical health, including:");
        System.out.println("   - INCLUSION:");
        System.out.println("   - Thorough physical examination");
        System.out.println("   - Assessment of vital signs");
        System.out.println("   - Evaluation of overall body condition");
        System.out.println("   Ensures the identification of any abnormalities and maintains your dog's good health.");
        System.out.println("   - $60.00");
        System.out.println();
    
        // Dental Checkups
        System.out.println("3. Dental Checkups:");
        System.out.println("   Specialized care for your dog's dental health, including:");
        System.out.println("   - INCLUSION:");
        System.out.println("   - Dental examination");
        System.out.println("   - Teeth cleaning and scaling");
        System.out.println("   - Evaluation of oral hygiene");
        System.out.println("   Crucial for preventing dental issues and maintaining your dog's overall well-being.");
        System.out.println("   - $70.00");
        System.out.println();
    
        // Allergy Testing
        System.out.println("4. Allergy Testing:");
        System.out.println("   Identification of potential allergies through:");
        System.out.println("   - INCLUSION:");
        System.out.println("   - Allergy testing procedures");
        System.out.println("   - Evaluation of allergic reactions");
        System.out.println("   Knowledge about your dog's allergies helps provide a safe and comfortable environment.");
        System.out.println("   - $80.00");
        System.out.println();
    
        // Geriatric Screening
        System.out.println("5. Geriatric Screening:");
        System.out.println("   Specialized screening for older dogs to detect age-related health issues, including:");
        System.out.println("   - INCLUSION:");
        System.out.println("   - Comprehensive health assessment");
        System.out.println("   - Diagnostic tests for geriatric conditions");
        System.out.println("   Regular geriatric screening is essential for the well-being of aging dogs.");
        System.out.println("   - $90.00");
        System.out.println();
    }
    

    private void printDogMedicalServices() {
        System.out.println("AVAILABLE EMERGENCY SERVICES FOR DOGS:");
        System.out.println();
    
        // Emergency Surgery
        System.out.println("1. Emergency Surgery");
        System.out.println("   Description: Immediate surgical intervention for critical health conditions.");
        System.out.println("   - Price: $5000.00");
        System.out.println();
    
        // Intensive Care Unit (ICU)
        System.out.println("2. Intensive Care Unit (ICU)");
        System.out.println("   Description: 24/7 critical care monitoring and medical support.");
        System.out.println("   - Price: $3000.00");
        System.out.println();
    
        // Diagnostic Imaging
        System.out.println("3. Diagnostic Imaging");
        System.out.println("   Description: Advanced imaging tests for accurate diagnosis.");
        System.out.println("   - Price: $1500.00");
        System.out.println();
    
        // Blood Transfusion
        System.out.println("4. Blood Transfusion");
        System.out.println("   Description: Emergency blood transfusion for severe cases of blood loss.");
        System.out.println("   - Price: $2000.00");
        System.out.println();
    
        // Add more emergency services as needed
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
