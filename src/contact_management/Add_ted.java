package contact_management;

import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Add_ted {
    Contact contacts = new Contact();
    static Input input = new Input();

    public static void addContact() throws IOException {
        Contact newContact = new Contact();

        // Prompt user to enter a name
        System.out.print("Please enter contact's name : ");
        String newContactName = input.getString();

     // Search contacts for similar name in array with all names

        // Create HashMap of all names as keys and values are placement in contacts
        HashMap<String,Integer> names = Contact.getContactInfo(1);

        // Iterate through all names to find all that are similar to given name
        for (int a = 0; a < names.size(); a++) {

            // If similar name is found prompt user if they want to override it
            if (names.containsKey(newContactName)) {
                if (input.yesNo("A contact with the name %s already exists. Do you want to overide it?\n\t [y/n] > ")){
                    // If they want to override contact then change contact

                } else {

                    // If they don't want to override contact then restart addContact method
                    addContact();
                }

            // If no name found then add name to newContact
            } else {
                newContact.setName(newContactName);
            }
        }

        // Prompt user for the phone number of the contact and validate it using validNumber
        String newPhoneNumber = Contact.validNumber("Please enter the contact's phone number using only numbers : ");

        // Add phone number to holding list
        newContact.setPhone(newPhoneNumber);

        // Prompt user for email and validate it user validEmail
        String newEmail = Contact.validEmail("Please enter the contact's email : ");

        // Add email to holding list
        newContact.setEmail(newEmail);

        // Adds new info to contacts.txt
        Files.write(
                Paths.get("src", "contacts.txt"), Arrays.asList(newContact.getName() + "," +  newContact.getPhone() + "," + newContact.getEmail()),StandardOpenOption.APPEND);

        List<String> showMe = Files.readAllLines(Paths.get("src", "contacts.txt"));
        System.out.println(showMe);
    }

    public static void main(String[] args) {

    }
}
