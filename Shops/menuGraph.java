package Shops;
import java.util.*;
// HAVENT TESTED YET.
public class menuGraph {
  
    int ch;
    initializeGraph Graph = new initializeGraph();
    reservationSystem Reserve = new reservationSystem();
    Scanner scan = new Scanner(System.in);
    private void pressEnterToContinue() {
        System.out.println("Press Enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
    public void shopMenu(){
        String destinationCity;
        String cityName;
        System.out.println("WHERE ARE YOU IN THESE AREAS?");
        System.out.println();
        System.out.println("Manila");
        System.out.println("Makati");
        System.out.println("Pasig");
        System.out.println("Taguig");
        System.out.println("Mandaluyong");
        System.out.println("Marikina\n");
        System.out.print(">");
        cityName = scan.nextLine().toUpperCase();
        Set<String> cities = new HashSet<>(Arrays.asList("MANILA", "MAKATI", "TAGUIG", "MANDALUYONG", "MARIKINA", "PASIG"));
        if (cities.contains(cityName)){
            Graph.printGraph(cityName);
            System.out.println();
            System.out.println("Enter the your preferred branch > ");
            destinationCity = scan.nextLine().toUpperCase();
            Graph.distanceBetweenCities(cityName, destinationCity);
            System.out.println();
            System.out.println("Enter Date (Year-Month-Day): ");
            System.out.print(">");
            String date = scan.nextLine();
            String[] dateParts = date.split("-");
        
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);

            System.out.println("Enter Time (Hours:Minutes): ");
            System.out.print(">");
            String hours = scan.nextLine();
            String[] hoursParts = hours.split(":");
            int hour = Integer.parseInt(hoursParts[0]);
            int minutes = Integer.parseInt(hoursParts[1]);
            Reserve.reservationTime(year, month, day, hour, minutes);
            pressEnterToContinue();
        } else {
            System.out.println("Invalid city. Please enter a valid city.");
        }
    }

}
