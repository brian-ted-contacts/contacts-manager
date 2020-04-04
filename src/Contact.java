import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Contact {
    private String name;
    private String number;
    private String email;
    Scanner input = new Scanner(System.in);
    public Contact (){};

    public Contact(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Method used to turn string of numbers into
    // valid phone number format
    public static String correctPhoneFormat(String str, int num){
        // Create Array to hold characters (numbers)
        ArrayList<Character> phone = new ArrayList<>();

        // Iterate through the given string of numbers and place
        // each into the array
        for (int a = 0; a < str.length(); a++){
            phone.add(str.charAt(a));
        }

        // Using the length of the given string determine
        // proper placing of hyphens
        if (num == 10){
            phone.add(3,'-');
            phone.add(7,'-');
        } else {
            phone.add(3,'-');
        }

        // Creat StringBuilder to hold characters in array
        StringBuilder holdnum = new StringBuilder();

        // Iterate through the array of characters to
        // place each into StringBuilder
        for (Character ch : phone){
            holdnum.append(ch);
        }

        // Return StringBuilder as a string
        return holdnum.toString();
    }

    // Method to confirm phone number is valid
    public String validNumber(){
        // Ask user for numbers and store response
        System.out.print("Enter the phone number with only numbers : ");
        String userResponse = input.nextLine();

        // Try to determine is response is valid (only numbers)
        try {
            Integer.parseInt(userResponse);

        // Catch any errors that may occur
        } catch (NumberFormatException nfe) {
            // Print error in error_log


            // Prompt user they entered invalid format and have user retry
            System.out.println("\nYou entered an invalid format.\n");
             return validNumber();
        }

        // Determine using length of numbers if it is a valid number
        if (userResponse.length() == 10 || userResponse.length() == 7){ // is valid

            // use method to turn numbers into valid format
            return correctPhoneFormat(userResponse,userResponse.length());
        } else { // not valid

            // Prompt user that numbers are not valid as numbre and have them retry
            System.out.println("\nInvalid length. Please check the number.\n");
            return validNumber();
        }

    }

    // Method to confirm email is valid
    public String validEmail(String str){
        // Looking to see if string contains @
        if (str.contains("@")){ // true
            return str;
        } else {// false
            // Prompt user for valid email and retry
            System.out.println("Invalid Email format\n\nEnter a valid email : ");
            String userResponse = input.nextLine();
            return validEmail(userResponse);
        }
    }

}
