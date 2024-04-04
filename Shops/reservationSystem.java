package Shops;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class reservationSystem {
    private int year, month, day, hour, minute;
    private String formattedReservationTime;

    public void reservationTime(int year, int month, int day, int hour, int minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        // gets the reservation time
        LocalDateTime reservationTime = LocalDateTime.of(this.year, this.month, this.day, this.hour, this.minute);
        // Formats the times
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");

        this.formattedReservationTime = reservationTime.format(formatter);

        System.out.println("\t\t\tReservation Time: " + formattedReservationTime);
    }


}