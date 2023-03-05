import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        This console program asks the user for the start time and the end time and calculates how many hours, minutes and seconds there are between them
         */

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime startTime = null;
        LocalTime endTime = null;

        //getting user input
        while (startTime == null) {

            System.out.println("Enter start time in the format hours:minutes:seconds (e.g. 12:20:50)");
            String firstInput = sc.nextLine();

            try {
                startTime = LocalTime.parse(firstInput, formatter);
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
            }
        }

        while (endTime == null) {
            System.out.println("Enter end time in the format hours:minutes:seconds (e.g. 14:45:12)");
            String secondInput = sc.nextLine();

            try {
                endTime = LocalTime.parse(secondInput, formatter);
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
            }
        }

        //parsing into necessary variables
        int hoursFromFirstInput = startTime.getHour();
        int minutesFromFirstInput = startTime.getMinute();
        int secondsFromFirstInput = startTime.getSecond();
        int hoursFromSecondInput = endTime.getHour();
        int minutesFromSecondInput = endTime.getMinute();
        int secondsFromSecondInput = endTime.getSecond();

        int hoursBetween = 0;
        int minutesBetween = 0;
        int secondsBetween = 0;

        //calculation of the result
        while (secondsFromFirstInput != secondsFromSecondInput) {
            secondsBetween++;
            secondsFromFirstInput++;
            if (secondsFromFirstInput >= 60) {
                secondsFromFirstInput = 0;
                minutesFromFirstInput++;
            }
        }

        while (minutesFromFirstInput != minutesFromSecondInput) {
            minutesBetween++;
            minutesFromFirstInput++;
            if (minutesFromFirstInput >= 60) {
                minutesFromFirstInput = 0;
                hoursFromFirstInput++;
            }
        }

        while (hoursFromFirstInput != hoursFromSecondInput) {
            hoursBetween++;
            hoursFromFirstInput++;
            if (hoursFromFirstInput >= 24) {
                hoursFromFirstInput = 0;
            }
        }

        //printing the result to the console
        System.out.println("Hours between: " + hoursBetween);
        System.out.println("Minutes between: " + minutesBetween);
        System.out.println("Seconds between: " + secondsBetween);

    }
}