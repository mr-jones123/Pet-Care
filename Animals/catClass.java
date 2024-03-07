package Animals;

import Interface_Super.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import Customers.queueSystem;

public class catClass extends superClass implements interfaceClass {
    Scanner scan = new Scanner(System.in);
    private int amount, choice;
    queueSystem Queue = new queueSystem();
    superClass x = new superClass();
    HashMap<String, Integer> catMedicalTests = new HashMap<>(x.getTests());
    HashMap<String, Integer> catMedicalServices = new HashMap<>(x.getMedicalServices());

    @Override
    public void pay(HashMap<String, Integer> services) {
        System.out.println();
        System.out.println("Enter Service:");
        System.out.println();
        System.out.print(">");
        String service = scan.nextLine();
        System.out.println();
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
                    printCatTests();
                    pay(catMedicalTests);
                    break;

                } else if (choice == 2) {
                    clearScreen();
                    printCatMedicalServices();
                    pay(catMedicalTests);
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
    
        // Geri~atric Screening
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
    public void amountChecker(String service, int amount, HashMap<String, Integer> services) {
        for (Map.Entry<String, Integer> entry : services.entrySet()) {
            if (service.equalsIgnoreCase(entry.getKey())) {
                if (amount >= entry.getValue()) {
                    int change = amount - entry.getValue();
                    printReceipt(entry.getKey(), amount, change);
                    System.out.println();
                    pressEnterToContinue();
                    Queue.removeFirst();
                    return;
                }
            }
        }
        System.out.println("Insufficient amount or service not available.");
        System.out.println();
        System.out.println("Please check for Spelling errors or check if your payment is sufficient");
        longPause();
        pressEnterToContinue();

    }

    @Override
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void printCatTests() {
        System.out.println("AVAILABLE TESTS FOR CATS: ");
        System.out.println();
    
        // Routine Checkup
        System.out.println("Routine Checkup");
        System.out.println("Estimated Time: 45 minutes");
        System.out.println("Description: Comprehensive health examination including physical checks and basic diagnostics.");
        System.out.println("  - Inclusions:");
        System.out.println("      1. Thorough physical examination");
        System.out.println("      2. Basic blood tests");
        System.out.println("  - Price: $50.00");
        System.out.println("  - Why choose Routine Checkup? Regular checkups are essential to monitor your cat's overall health and detect any potential issues early.");
    
        // Physical Exams
        System.out.println("\nPhysical Exams");
        System.out.println("Estimated Time: 30 minutes");
        System.out.println("Description: Detailed examination focusing on your cat's physical condition and well-being.");
        System.out.println("  - Inclusions:");
        System.out.println("      1. Comprehensive physical assessment");
        System.out.println("      2. Evaluation of vital signs");
        System.out.println("  - Price: $45.00");
        System.out.println("  - Why choose Physical Exams? Physical exams help ensure your cat's overall health and identify any abnormalities or concerns.");
    
        // Dental Checkups
        System.out.println("\nDental Checkups");
        System.out.println("Estimated Time: 40 minutes");
        System.out.println("Description: Specialized examination and care for your cat's dental health.");
        System.out.println("  - Inclusions:");
        System.out.println("      1. Dental examination");
        System.out.println("      2. Teeth cleaning");
        System.out.println("  - Price: $70.00");
        System.out.println("  - Why choose Dental Checkups? Dental health is crucial for cats; regular checkups can prevent dental issues and ensure a healthy smile.");
    
        // Allergy Testing
        System.out.println("\nAllergy Testing");
        System.out.println("Estimated Time: 60 minutes");
        System.out.println("Description: Identification of potential allergies affecting your cat's health.");
        System.out.println("  - Inclusions:");
        System.out.println("      1. Allergy testing panel");
        System.out.println("      2. Consultation with a veterinarian");
        System.out.println("  - Price: $300.00");
        System.out.println("  - Why choose Allergy Testing? Understanding your cat's allergies helps in managing their health and well-being.");
    
        // Geriatric Screening
        System.out.println("\nGeriatric Screening");
        System.out.println("Estimated Time: 50 minutes");
        System.out.println("Description: Specialized health screening for senior cats to monitor and address age-related concerns.");
        System.out.println("  - Inclusions:");
        System.out.println("      1. Geriatric health assessment");
        System.out.println("      2. Comprehensive blood tests");
        System.out.println("  - Price: $110.00");
        System.out.println("  - Why choose Geriatric Screening? Tailored for senior cats, this screening aids in maintaining their health and addressing age-related challenges.");
        
        System.out.println();
        System.out.println();

    }
    

    private void printCatMedicalServices() {
        System.out.println("AVAILABLE MEDICAL SERVICES FOR CATS: ");
        System.out.println();
    
        // Bloodwork
        System.out.println("Bloodwork");
        System.out.println("Description: Comprehensive blood tests to assess your cat's health.");
        System.out.println("  - Inclusions:");
        System.out.println("      1. Blood sample collection");
        System.out.println("      2. Laboratory analysis");
        System.out.println("  - Price: $200.00");
    
        // X-Rays
        System.out.println("\nX-Rays");
        System.out.println("Description: Diagnostic imaging for a detailed view of your cat's internal structures.");
        System.out.println("  - Inclusions:");
        System.out.println("      1. X-ray imaging session");
        System.out.println("      2. Radiologist's interpretation");
        System.out.println("  - Price: $150.00");
    
        // Ultrasounds
        System.out.println("\nUltrasounds");
        System.out.println("Description: Non-invasive imaging technique to visualize internal organs.");
        System.out.println("  - Inclusions:");
        System.out.println("      1. Ultrasound imaging session");
        System.out.println("      2. Interpretation by a specialist");
        System.out.println("  - Price: $600.00");
    
        // Oxygen Therapy
        System.out.println("\nOxygen Therapy");
        System.out.println("Description: Emergency oxygen support for critical situations.");
        System.out.println("  - Inclusions:");
        System.out.println("      1. Oxygen administration");
        System.out.println("      2. Monitoring by trained staff");
        System.out.println("  - Price: $3000.00");
    
        // Emergency Surgery
        System.out.println("\nEmergency Surgery");
        System.out.println("Description: Immediate surgical intervention for critical medical conditions.");
        System.out.println("  - Inclusions:");
        System.out.println("      1. Surgical procedure");
        System.out.println("      2. Anesthesia and post-operative care");
        System.out.println("  - Price: $5000.00");
    
        System.out.println();
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
