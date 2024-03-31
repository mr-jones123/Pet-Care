package Shops;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
public class reservationSystem {
    private int hoursConvert;
    private String formattedCurrentTime, formattedReservationTime;
// Reservation System
    public void reservationTime(int year, int month, int day, int hour, int minute){
        //Get the local time 
        LocalDateTime currentTime = LocalDateTime.now();
        // gets the reservation time
        LocalDateTime reservationTime = LocalDateTime.of(year, month, day, hour, minute, minute);
        // Computes the time in between the current time and reservation time 
        Duration durationTime = Duration.between(currentTime, reservationTime);

        //Formats the times
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");
        

        formattedCurrentTime = currentTime.format(formatter);
        formattedReservationTime = reservationTime.format(formatter); 
        // Duration has its own format
        
        
        
        System.out.println("Current Time: " + formattedCurrentTime);
        System.out.println("Reservation Time: " + formattedReservationTime);

    }
    public String getFromattedReservationTime(){
        return formattedReservationTime;
    }
    public String getReservationTime(){
        return formattedReservationTime;
    }
}
