package Animals;

import Interface_Super.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import Customers.queueSystem;

public class dogClass extends superClass implements interfaceClass {
    private Checkout checkout;
    private int choice;
    private int continueChoice;
    Scanner scan = new Scanner(System.in);
    queueSystem Queue = new queueSystem();
    superClass x = new superClass();

    ArrayList<String> selectedServices = new ArrayList<>();
    ArrayList<Integer> selectedPrices = new ArrayList<>();

    HashMap<String, Integer> listOfServices = new HashMap<>(x.getListofServices());
    HashMap<String, Integer> listOfTests = new HashMap<>(x.getListofTests());

    HashMap<Integer, Integer> dogMedicalTests = new HashMap<>(x.getTests());
    HashMap<Integer, Integer> dogMedicalServices = new HashMap<>(x.getMedicalServices());

    @Override
    public void clearScreen() {
        System.out.print(   "\033[H\033[2J");
        System.out.flush();
    }

    @Override
    public int selectionOfService(HashMap<Integer, Integer> services) {
        System.out.println("\t\t\tEnter Service:");
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
        System.out.println("\t\t\tWould you like to add another service?");
        System.out.println("\t\t\t1 - Yes | 2 - No");
        System.out.print("\t\t\t>");
        continueChoice = scan.nextInt();

        if (continueChoice == 1){
            mainMenu();
        } else if (continueChoice == 2){
            checkout = new Checkout(selectedServices, selectedPrices);
        try {
            checkout.checkoutFunction();
        } catch (Exception e) {
            System.out.println("\t\t\tUnexpected Error");
        }
           
        }
    }
    
    @Override
    public void mainMenu() {
        clearScreen();
        while (true) {
            clearScreen();
            System.out.println("\t\t\t───▄▀▀▀▄▄▄▄▄▄▄▀▀▀▄───\r\n" + //
                                "\t\t\t───█▒▒░░░░░░░░░▒▒█───\r\n" + //
                                "\t\t\t────█░░█░░░░░█░░█────\r\n" + //
                                "\t\t\t─▄▄──█░░░▀█▀░░░█──▄▄─\r\n" + //
                                "\t\t\t█░░█─▀▄░░░░░░░▄▀─█░░█\r\n" + //
                                "\t\t\t");
System.out.println("  __  __          _ _           _   ____                  _                 \r\n" + //
            " |  \\/  | ___  __| (_) ___ __ _| | / ___|  ___ _ ____   _(_) ___ ___  ___   \r\n" + //
            " | |\\/| |/ _ \\/ _` | |/ __/ _` | | \\___ \\ / _ \\ '__\\ \\ / / |/ __/ _ \\/ __|  \r\n" + //
            " | |  | |  __/ (_| | | (_| (_| | |  ___) |  __/ |   \\ V /| | (_|  __/\\__ \\  \r\n" + //
            " |_|  |_|\\___|\\__,_|_|\\___\\__,_|_| |____/ \\___|_|    \\_/ |_|\\___\\___||___/  \r\n" + //
            "                                                                            ");
System.out.println("==================================================================================");
            System.out.println("\t\t\tPick the best option for your cat: ");
            System.out.println();
            System.out.println("\t\t\tPress 1 - Test");
            System.out.println("\t\t\tPress 2 - Emergency Service");
            System.out.println("\t\t\tPress 3 - For Description");
            System.out.print("\t\t\t>");
            try {
                choice = scan.nextInt();
                scan.nextLine();
                if (choice == 1) {
                    clearScreen();
                    printDogMedicalTests();
                    int serviceNumber = selectionOfService(dogMedicalTests);
                    addServiceCheckout(serviceNumber,dogMedicalTests , listOfTests);
                    break;
                } else if (choice == 2) {
                    clearScreen();
                    printDogMedicalServices();
                    int serviceNumber = selectionOfService(dogMedicalServices);
                    addServiceCheckout(serviceNumber,dogMedicalServices , listOfServices);
                    break;

                } else if (choice == 3) {
                    clearScreen();
                    printDescription();
                    System.out.println();
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
        System.out.println("   _____                                                         \r\n" + //
                        "  (        ___  .___  _   __ `   ___    ___    ____              \r\n" + //
                        "   `--.  .'   ` /   \\ |   /  | .'   ` .'   `  (                  \r\n" + //
                        "      |  |----' |   ' `  /   | |      |----'  `--.               \r\n" + //
                        " \\___.'  `.___, /      \\/    /  `._.' `.___, \\___.'              \r\n" + //
                        "                                                                 \r\n" + //
                        " .___                                        .                   \r\n" + //
                        " /   `    ___    ____   ___  .___  ` \\,___, _/_   `   __.  , __  \r\n" + //
                        " |    | .'   `  (     .'   ` /   \\ | |    \\  |    | .'   \\ |'  `.\r\n" + //
                        " |    | |----'  `--.  |      |   ' | |    |  |    | |    | |    |\r\n" + //
                        " /---/  `.___, \\___.'  `._.' /     / |`---'  \\__/ /  `._.' /    |\r\n" + //
                        "                                     \\                           ");
        System.out.println("===================================================================");
        System.out.println();
    
        // Routine Checkup
        System.out.println("Routine Checkup:");
        System.out.println("For a regular checkup and quick assessment of your dog's health. This service includes:");
        System.out.println("  - Physical examination");
        System.out.println("  - Blood tests");
        System.out.println("  - Diagnostic procedures if necessary");
        System.out.println("It is designed to detect potential health issues and provide early intervention.");
        System.out.println("Regular checkups are essential for maintaining your cat's overall well-being.");
        System.out.println();
    
        // Physical Exams
        System.out.println("Physical Exams:");
        System.out.println("A comprehensive examination of your dog's physical health, including:");
        System.out.println("  - Thorough physical examination");
        System.out.println("  - Assessment of vital signs");
        System.out.println("  - Evaluation of overall body condition");
        System.out.println("Physical exams help identify any abnormalities and ensure your dog's good health.");
        System.out.println();
    
        // Dental Checkups
        System.out.println("Dental Checkups:");
        System.out.println("Specialized care for your dog's dental health, including:");
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
        System.out.println("Knowing your dog's allergies helps in providing a safe and comfortable environment.");
        System.out.println();
    
        // Geriatric Screening
        System.out.println("Geriatric Screening:");
        System.out.println("Specialized screening for older cats to detect age-related health issues, including:");
        System.out.println("  - Comprehensive health assessment");
        System.out.println("  - Diagnostic tests for geriatric conditions");
        System.out.println("Regular geriatric screening is essential for the well-being of aging dogs.");
        System.out.println();
    
        // Emergency Services
        System.out.println("EMERGENCY SERVICES:");
        System.out.println("For critical situations requiring immediate medical attention:");
        System.out.println("  - Bloodwork, X-Rays, Ultrasounds, Oxygen Therapy, Emergency Surgery");
        System.out.println("Our emergency services are available 24/7 to provide prompt and effective care.");
        System.out.println("Our skilled veterinarians and medical staff are trained to handle emergencies.");
        System.out.println("Whether it's a serious injury, sudden illness, or any other emergency, rely on our team.");
        System.out.println();
        pressEnterToContinue();
    
    }
    private void printDogMedicalTests() {
        System.out.println("AVAILABLE TESTS FOR DOGS:");
        System.out.println();
    
        // Routine Checkup
        System.out.println("1. Routine Checkup:");
        System.out.println("   Description: A regular checkup and quick assessment of your dog's health.");
        System.out.println("   -Price: $50.00");
        System.out.println();
    
        // Physical Exams
        System.out.println("2. Physical Exams:");
        System.out.println("   Description: A comprehensive examination of your dog's physical health.");
        System.out.println("   -Price: $60.00");
        System.out.println();


        // Dental Checkups
        System.out.println("3. Dental Checkups:");
        System.out.println("   Description: Specialized care for your dog's dental health, including:");
        System.out.println("   -Price: $70.00");
        System.out.println();
    
        // Allergy Testing
        System.out.println("4. Allergy Testing:");
        System.out.println("   Description: Identification of potential allergies through:");
        System.out.println("   -Price: $80.00");
        System.out.println();
    
        // Geriatric Screening
        System.out.println("5. Geriatric Screening:");
        System.out.println("   Description: Specialized screening for older dogs to detect age-related health issues, including:");
        System.out.println("   -Price: $90.00");
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
    
        // Oxygen Therapy
        System.out.println("5. Oxygen Therapy");
        System.out.println("   Description: Supplemental oxygen for your pet's difficult breathing.");
        System.out.println("   - Price: $1000.00");
        System.out.println();
    }
    public ArrayList<String> getServiceNameList(){
        return selectedServices;
    }
    public ArrayList<Integer> getPriceList(){
        return selectedPrices;
    }
    private void pressEnterToContinue() {
        System.out.println("Press Enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

}
