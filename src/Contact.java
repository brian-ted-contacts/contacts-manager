import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contact {
    private String name;
    private String phone;
    private String email;
    Scanner input = new Scanner(System.in);

    public Contact (){};

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
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

    // Method to take contact and separate into sections
    public static ArrayList<Contact> getAllContacts() throws IOException {
        ArrayList<Contact> contacts = new ArrayList<>();

        // Takes information from contact.txt and turns it into an array of strings
        List<String> contactList = Files.readAllLines(Paths.get("src","contacts.txt"));

        // Cycle thru each line of the document
        for (String s : contactList) {

            // Turn each line into another array of strings
            // separated at the ","
            String[] contactLine = s.split(",");

            // use the above array to creat a new Contact and add it to ArrayList
            Contact hold = new Contact(contactLine[0], contactLine[1], contactLine[2]);
            contacts.add(hold);
        }

        // Return ArrayList with added contacts.
        return contacts;
    }

    // Method to get list of Contact info
    public static ArrayList<String> getContactInfo(int num) throws IOException {
        // Set contacts to array and set holding array
        ArrayList<Contact> contacts = Contact.getAllContacts();
        ArrayList<String> infoNeeded = new ArrayList<>();

        // Depending on number entered get need info and
        // add it to holding array
        switch (num){
            case 1:
                for (Contact contact : contacts){
                    infoNeeded.add(contact.getName());
                }
                break;
            case 2:
                for (Contact contact : contacts){
                    infoNeeded.add(contact.getPhone());
                }
                break;
            default:
                for (Contact contact : contacts){
                    infoNeeded.add(contact.getEmail());
                }
                break;
        }

        // Return array of info needed
        return infoNeeded;
    }

    public static void updateContacts(ArrayList<Contact> list) throws IOException {
        List<String> updatedContacts = new ArrayList<>();
        Path filepath = Paths.get("src","contacts.txt");

        for (Contact contact : list){
            String holdContacts = contact.getName() + "," +
                    contact.getPhone() + "," +
                    contact.getEmail();
            updatedContacts.add(holdContacts);
        }
        Files.write(filepath, updatedContacts);

    }

    public static void main(String[] args) throws IOException {
        Contact.updateContacts();
    }

}
