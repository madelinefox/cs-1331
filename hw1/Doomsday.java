import java.util.Scanner;

public class Doomsday {

    private static int anchorday = 3;
    private static int year;
    private static int month;
    private static int day;
    private static Scanner input = new Scanner(System.in);

    public static void userInformation() {
        System.out.println("Welcome to the Doomsday Calculator!");
        System.out.println("What year are you looking for?");
        year = input.nextInt();
        System.out.println("What month (1-12)?");
        month = input.nextInt();
        System.out.println("What day?");
        day = input.nextInt();
    }

    public static void main(String [] args) {
        userInformation();

        int workingDay = (((year % 100) / 12) + ((year % 100) % 12)
            + (((year % 100) % 12) / 4) + anchorday) % 7;
        int monthDay = -9;
        int weekDay;
        boolean leapYear = false;

        if (year != 1900 && ((year % 4) == 0)) {
            leapYear = true;
        }
        if (month == 1) {
            monthDay = 3;
        }
        /*if (month == 1 && leapYear == true) {
            monthDay = 4;
        }*/
        if (month == 2) {
            monthDay = 28;
        }
        /*if (month == 2 && leapYear == true) {
            monthDay = 29;
        }*/
        if (leapYear == true) {
            monthDay++;
        }
        if (month == 3) {
            monthDay = 7;
        }
        if (month == 4) {
            monthDay = 4;
        }
        if (month == 5) {
            monthDay = 9;
        }
        if (month == 6) {
            monthDay = 6;
        }
        if (month == 7) {
            monthDay = 11;
        }
        if (month == 8) {
            monthDay = 8;
        }
        if (month == 9) {
            monthDay = 5;
        }
        if (month == 10) {
            monthDay = 10;
        }
        if (month == 11) {
            monthDay = 7;
        }
        if (month == 12) {
            monthDay = 12;
        }
        if (month > 12 || month <= 0) {
            System.out.println("Your inputed month doesn't work.");
        }
        int difference = day - monthDay;
        if (difference >= 0) {
            weekDay = (difference + workingDay) % 7;
        } else {
            weekDay = 7 + (difference + workingDay) % 7;
        }
        String dayOfWeek = "";
        if (weekDay == 0) {
            dayOfWeek = "Sunday";
        }
        if (weekDay == 1) {
            dayOfWeek = "Monday";
        }
        if (weekDay == 2) {
            dayOfWeek = "Tuesday";
        }
        if (weekDay == 3) {
            dayOfWeek = "Wednesday";
        }
        if (weekDay == 4) {
            dayOfWeek = "Thursday";
        }
        if (weekDay == 5) {
            dayOfWeek = "Friday";
        }
        if (weekDay == 6) {
            dayOfWeek = "Saturday";
        }
        System.out.println(month + "/" + day + "/" + year
             + " was on a " + dayOfWeek);

    }
}
