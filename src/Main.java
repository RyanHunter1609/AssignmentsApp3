import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\nHello, AssignmentsApp!\n");

        //Output the current date-time.
        LocalDateTime today = LocalDateTime.now();
        System.out.println("\nThe current date-time is " + today);

        //Output tomorrow's date using a formatter.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        String formatDateTime = today.format(formatter);
        System.out.println("Tomorrow's formatted date is " + formatDateTime);

        //Add 5 weeks to today's LocalDateTime.
        LocalDateTime fiveWeeksLater = addWeeksToDate(today, 5);
        System.out.println("The five weeks, the date will be " + fiveWeeksLater);

        //Initialize a LocalDateTime object to your birthdate and the time 12:35 PM.
        LocalDateTime birthDate = LocalDateTime.of(1999, 2, 7, 12, 35);
        System.out.println("Your birthdate is " + birthDate);

        //Output the day of the week (Sunday-Saturday) that you were born.
        System.out.println("The day of the week of your birthdate was " + findDayOfDate(birthDate));

        //Output the number of days you've been alive.
        System.out.println("The number of days you have been alive is " + daysBetweenDates(birthDate,today) + " days.");
        
    }

    private static long daysBetweenDates(LocalDateTime earlyDate, LocalDateTime laterDate) {
        return ChronoUnit.DAYS.between(earlyDate,laterDate);
    }

    private static DayOfWeek findDayOfDate(LocalDateTime userDate) {
        return userDate.getDayOfWeek();
    }

    private static LocalDateTime addWeeksToDate(LocalDateTime date, long numWeeks) {
        return date.plusWeeks(5);
    }
    
    
    
}
