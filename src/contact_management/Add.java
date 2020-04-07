package contact_management;

import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Add extends Contact {
    static Input input = new Input();

    public static String addContact() throws IOException {
        ArrayList<Contact> mainList = getAllContacts();

        // Prompt user to enter a name
        System.out.print("Please enter contact's name : ");
        String newContactName = input.getString();

     // Search contacts for similar name in array with all names

        // Create HashMap of all names as keys and values are placement in contacts
        HashMap<String,Integer> names = getContactInfo(1);

        // If similar name is found prompt user if they want to override it
        if (names.containsKey(newContactName)) {
            if (input.yesNo("A contact with the name %s already exists. Do you want to overide it?\n\t [y/n] > ")){

                // If they want to override contact then change contact info
                mainList.get(names.get(newContactName)).setName(newContactName);

                String newPhoneNumber = Contact.validNumber("\nPlease enter the contact's phone number using only numbers : ");
                mainList.get(names.get(newContactName)).setPhone(newPhoneNumber);

                String newEmail = Contact.validEmail("Please enter the contact's email : ");
                mainList.get(names.get(newContactName)).setEmail(newEmail);
                // Update contact.txt with changes and info user
                updateContacts(mainList);
                return String.format("\n\t%s has been added to your contacts!\n",newContactName);

            } else {

                // If they don't want to override contact then restart addContact method
                addContact();
            }
        }

        // Prompt user for the phone number of the contact and validate it using validNumber
        String newPhoneNumber = Contact.validNumber("Please enter the contact's phone number using only numbers : ");

        // Prompt user for email and validate it user validEmail
        String newEmail = Contact.validEmail("Please enter the contact's email : ");

        // Adds new info to contacts.txt
        Files.write(
                Paths.get("src", "contacts.txt"), Arrays.asList(newContactName + "," +  newPhoneNumber + "," + newEmail),StandardOpenOption.APPEND);

        return String.format("\t%s has been added to your contacts!\n",newContactName);
    }

}
