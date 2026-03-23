package za.ac.cput.util;

public class Helper {

    // Check if string is null or empty
    public static boolean isNullOrEmpty(String str) {
        return (str == null || str.trim().isEmpty());
    }

    // Check if number is positive
    public static boolean isPositive(int number) {
        return number > 0;
    }

    // Check if dateTime is valid (basic check)
    public static boolean isValidDateTime(String dateTime) {
        return !isNullOrEmpty(dateTime);
        // You can improve this later to check format like "YYYY-MM-DD HH:MM"
    }
}