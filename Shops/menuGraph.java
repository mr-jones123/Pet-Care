package Shops;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class menuGraph {
    private int year,  month,  day, hour, minute;
    private String formattedCurrentTime;
    int ch;
    LocalDateTime currentTime = LocalDateTime.now();
    initializeGraph Graph = new initializeGraph();
    reservationSystem Reserve = new reservationSystem();
    Scanner scan = new Scanner(System.in);
    private Set<String> cities = new HashSet<>(Arrays.asList("SAMPALOC", "BINONDO", "PACO", "TONDO", "PANDACAN", "SANTA CRUZ", "SANTA MESA", "ERMITA"));
    public void shopMenu(){
        clearScreen();
        LocalDateTime currentTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");

        String destinationCity;
        String cityName;
        this.formattedCurrentTime = currentTime.format(formatter);
    
        System.out.println("\t\t\tWHERE ARE YOU IN THESE AREAS?");
        System.out.println();
        System.out.println("\t\t\tBINONDO" + "\t\tERMITA");
        System.out.println("\t\t\tPACO" + "\t\tTONDO");
        System.out.println("\t\t\tSAMPALOC" + "\tSANTA CRUZ");
        System.out.println("\t\t\tPANDACAN" + "\tSANTA MESA\n");
        System.out.print("\t\t\t>");
        cityName = scan.nextLine().toUpperCase();
        while (!cities.contains(cityName)){
            System.out.println("\t\t\tThat area does not have a branch");
            System.out.println("\t\t\tPlease re-enter");
            System.out.print("\t\t\t>");
            cityName = scan.nextLine().toUpperCase();
        }
        while(cityName.matches("[0-9]+ ")){
            System.out.println("\t\t\tInvalid character detected");
            System.out.println("\t\t\tPlease re-enter");
            System.out.print("\t\t\t>");
            cityName = scan.nextLine().toUpperCase();
        }
        if (cities.contains(cityName)){
            Graph.printGraph(cityName);
            System.out.println();
            System.out.print("\t\t\tEnter the your preferred branch > ");
            destinationCity = scan.nextLine().toUpperCase();
            while (!cities.contains(destinationCity)){
                System.out.println("\t\t\tThat area does not have a branch");
                System.out.println("\t\t\tPlease re-enter");
                System.out.print("\t\t\t>");
                destinationCity = scan.nextLine().toUpperCase();
            }
            while(destinationCity.matches("[0-9]+ ")){
                System.out.println("\t\t\tInvalid character detected");
                System.out.println("\t\t\tPlease re-enter");
                System.out.print("\t\t\t>");
                destinationCity = scan.nextLine().toUpperCase();
            }

            Graph.distanceBetweenCities(cityName, destinationCity);
            System.out.println();
            System.out.println("\t\t\tCurrent Time: " + formattedCurrentTime);
            System.out.println("\t\t\tEnter Year: ");
            System.out.print("\t\t\t>");
            year = scan.nextInt();
            System.out.println("\t\t\tEnter Month: ");
            System.out.print("\t\t\t>");
            month = scan.nextInt();
            System.out.println("\t\t\tEnter Day: ");
            System.out.print("\t\t\t>");
            day = scan.nextInt();
            System.out.println("\t\t\tEnter Hour: ");
            System.out.print("\t\t\t>");
            hour = scan.nextInt();
            System.out.println("\t\t\tEnter Minutes: ");
            System.out.print("\t\t\t>");
            minute = scan.nextInt();
            Reserve.reservationTime(year, month, day, hour, minute);
            pressEnterToContinue();
        } else {
            System.out.println("\t\t\tInvalid city. Please enter a valid city.");
        }
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private void pressEnterToContinue() {
        System.out.println("\t\t\tPress Enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

}
