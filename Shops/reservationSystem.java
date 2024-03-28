package Shops;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
public class reservationSystem {
    private int hoursConvert;
    private String formattedCurrentTime, formattedReservationTime, formattedDurationTime;
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
        
        long hours = durationTime.toHours();
        long minutes = durationTime.toMinutesPart();

        formattedCurrentTime = currentTime.format(formatter);
        formattedReservationTime = reservationTime.format(formatter); 
        // Duration has its own format
        formattedDurationTime = String.format("%02d:%02d", hours, minutes);
        
        
        System.out.println("Current Time: " + formattedCurrentTime);
        System.out.println("Reservation Time: " + formattedReservationTime);
        hoursConvert = (int) hours;
    }
}
