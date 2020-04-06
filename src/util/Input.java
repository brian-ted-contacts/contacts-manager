package util;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in); // Creates Scanner for class

    // Method will capture string input and return it
    public String getString() {
        return scanner.nextLine();
    }

    // Using provided prompt method will then
    // capture and return string input
    public String getString(String prompt) {
        System.out.printf("\n%s", prompt);
        return scanner.nextLine();
    }

    // Method will capture the first character of the input provided.
    // Confirms it is a 'y' or 'n' else waits for correct input
    // then returns a boolean
    public boolean yesNo() {
        char response = scanner.next().trim().toLowerCase().charAt(0);
        if (Character.compare(response, 'y') == 0) {
            return true;
        } else if (Character.compare(response, 'n') == 0) {
            return false;
        } else {
            return yesNo();
        }
    }

    // Shows given prompt first then method
    // capture the first character of the input provided
    // Confirms it is a 'y' or 'n' else waits for correct input
    // then returns a boolean
    public boolean yesNo(String prompt) {
        System.out.printf("\n %s", prompt);
        String response = scanner.nextLine().toLowerCase().trim();
        if (response.startsWith("y")) {
            return true;
        } else if (response.startsWith("n")) {
            return false;
        } else {
            System.out.println("Invalid answer.\n");
            return yesNo();
        }
    }

    // Method captures and return integer
    public int getInt() {
        String userResponse = getString();
        int userInt;
        try {
            userInt = Integer.parseInt(userResponse);
        } catch (NumberFormatException nfe) {
            System.out.print("\tYou need to enter a Integer. Please try again\n > ");
            return getInt();
        }
        return userInt;
    }

    // Using provided prompt Method wil capture and return integer
    public int getInt(String prompt) {
        String userResponse = getString(prompt);
        int userInt;
        try {
            userInt = Integer.parseInt(userResponse);
        } catch (NumberFormatException nfe) {
            System.out.print("\tYou need to enter a Integer. Please try again\n > ");
            return getInt(prompt);
        }
        return userInt;
    }

    // Method captures integer input
    // then returns integer if with range of
    // min and max else prompts for correct
    // integer
    public int getInt(int min, int max) {
        int userNumber = getInt();

        if (userNumber >= min && userNumber <= max) {
            return userNumber;
        } else {
            System.out.printf("That is not a number between %d and %d\n > ", min, max);
            return getInt(min, max);
        }
    }

    // Method will capture integer input
    // then returns integer if with range of
    // min and max else prompts for correct
    // integer
    public int getInt(int min, int max, String prompt) {

        int userNumber = getInt(prompt);

        if (userNumber >= min && userNumber <= max) {
            return userNumber;
        } else {
            System.out.printf("That is not a number between %d and %d\n", min, max);
            return getInt(min, max, prompt);
        }
    }

    // Method will capture and return double
    public double getDouble() {
        String userResponse = getString();
        double userDouble;
        try {
            userDouble = Double.parseDouble(userResponse);
        } catch (NumberFormatException nfe) {
            System.out.print("\tYou need to enter a Double. Please try again\n");
            return getDouble();
        }
        return userDouble;
    }

    // Using provided prompt method will capture
    // and return provided double
    public double getDouble(String prompt) {
        String userResponse = getString(prompt);
        double userDouble;
        try {
            userDouble = Double.parseDouble(userResponse);
        } catch (NumberFormatException nfe) {
            System.out.print("\tYou need to enter a Double. Please try again\n");
            return getDouble(prompt);
        }
        return userDouble;
    }

    // Method will capture and return double if
    // with range of min and max else prompts
    // for correct integer
    public double getDouble(double min, double max) {
        double userNumber = getDouble();
        if (userNumber >= min && userNumber <= max) {
            return userNumber;
        } else {
            System.out.printf("That is not a number between %f and %f\n", min, max);
            return getDouble(min, max);
        }
    }

    // Using provided prompt method will
    // capture and return double if within
    // range of min and max else prompts
    // for correct integer
    public double getDouble(double min, double max, String prompt) {
        double userNumber = getDouble(prompt);
        if (userNumber >= min && userNumber <= max) {
            return userNumber;
        } else {
            System.out.printf("That is not a number between %f and %f\n", min, max);
            return getDouble(min, max, prompt);
        }
    }

    // Method to check is a string is null or Empty
    // returns boolean
    public boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }


}
