package Animals;

import Interface_Super.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import Customers.queueSystem;

public class catClass extends superClass implements interfaceClass {
    Scanner scan = new Scanner(System.in);
    private int continueChoice;
    private int choice;
    queueSystem Queue = new queueSystem();
    superClass x = new superClass();
    ArrayList<String> selectedServices = new ArrayList<>();
    ArrayList<Integer> selectedPrices = new ArrayList<>();

    HashMap<String, Integer> listOfServices = new HashMap<>(x.getListofServices());
    HashMap<String, Integer> listOfTests = new HashMap<>(x.getListofTests());

    HashMap<Integer, Integer> catMedicalTests = new HashMap<>(x.getTests());
    HashMap<Integer, Integer> catMedicalServices = new HashMap<>(x.getMedicalServices());

    @Override
    public int selectionOfService(HashMap<Integer, Integer> services) {
        System.out.println();
        System.out.println("Enter Service:");
        System.out.println();
        System.out.print(">");
        int service = scan.nextInt();
    return service;
    }
    @Override
    public void addServiceCheckout(int serviceNumber,HashMap<Integer, Integer> services, HashMap<String, Integer> listOfServices){
        String serviceName;
        int servicePrice;
        for(Map.Entry<String, Integer> entries: listOfServices.entrySet()){
            if (serviceNumber == entries.getValue()){
                serviceName = entries.getKey();
                selectedServices.add(serviceName);
            }
        }
        for (Map.Entry<Integer,Integer> entries: services.entrySet()){
            if (serviceNumber == entries.getKey()){
                servicePrice = entries.getValue();
                selectedPrices.add(servicePrice);
            }
        }
        System.out.println("Would you like to add another service?");
        System.out.println("1 - Yes | 2 - No");
        System.out.print(">");
        continueChoice = scan.nextInt();

        if (continueChoice == 1){
            mainMenu();
        } else if (continueChoice == 2){
            Checkout checkout = new Checkout(selectedServices, selectedPrices);
            checkout.checkoutFunction();
        }
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
                    int serviceNumber = selectionOfService(catMedicalTests);
                    addServiceCheckout(serviceNumber,catMedicalTests , listOfTests);
                    break;
                } else if (choice == 2) {
                    clearScreen();
                    printCatMedicalServices();
                    int serviceNumber = selectionOfService(catMedicalServices);
                    addServiceCheckout(serviceNumber,catMedicalServices , listOfServices);
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
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void printCatTests() {
        System.out.println("AVAILABLE TESTS FOR CATS: ");
        System.out.println();
    
        // Routine Checkup
        System.out.println("1. Routine Checkup");
        System.out.println("Description: Comprehensive health examination including physical checks and basic diagnostics.");
        System.out.println("  - Price: $50.00");
        System.out.println();
    
        // Physical Exams
        System.out.println("\n2. Physical Exams");
        System.out.println("Description: Detailed examination focusing on your cat's physical condition and well-being.");
        System.out.println("  - Price: $45.00");
        System.out.println();
    
        // Dental Checkups
        System.out.println("\n3. Dental Checkups");
        System.out.println("Description: Specialized examination and care for your cat's dental health.");
        System.out.println("  - Price: $70.00");
        System.out.println();
    
        // Allergy Testing
        System.out.println("\n4. Allergy Testing");
        System.out.println("Description: Identification of potential allergies affecting your cat's health.");
        System.out.println("  - Price: $300.00");
        System.out.println();
    
        // Geriatric Screening
        System.out.println("\n5.Geriatric Screening");
        System.out.println("Description: Specialized health screening for senior cats to monitor and address age-related concerns.");
        System.out.println("  - Price: $110.00");
        System.out.println();

    }
    

    private void printCatMedicalServices() {
        System.out.println("AVAILABLE MEDICAL SERVICES FOR CATS: ");
        System.out.println();
    
        // Bloodwork
        System.out.println("1. Bloodwork");
        System.out.println("Description: Comprehensive blood tests to assess your cat's health.");
        System.out.println("  - Price: $200.00");
    
        // X-Rays
        System.out.println("\n2. X-Rays");
        System.out.println("Description: Diagnostic imaging for a detailed view of your cat's internal structures.");
        System.out.println("  - Price: $150.00");
    
        // Ultrasounds
        System.out.println("\n3. Ultrasounds");
        System.out.println("Description: Non-invasive imaging technique to visualize internal organs.");
        System.out.println("  - Price: $600.00");
    
        // Oxygen Therapy
        System.out.println("\n4. Oxygen Therapy");
        System.out.println("Description: Emergency oxygen support for critical situations.");
        System.out.println("  - Price: $3000.00");
    
        // Emergency Surgery
        System.out.println("\n5. Emergency Surgery");
        System.out.println("Description: Immediate surgical intervention for critical medical conditions.");
        System.out.println("  - Price: $5000.00");
    
        System.out.println();
    }
    public ArrayList<String> getServiceNameList(){
        return selectedServices;
    }
    public ArrayList<Integer> getPriceList(){
        return selectedPrices;
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
