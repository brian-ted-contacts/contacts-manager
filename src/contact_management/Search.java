package contact_management;

import util.Input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Search extends Contact {
    static Input input = new Input();

    public static String searchContact() throws IOException {
        ArrayList<Contact> allContacts = getAllContacts(); // Contains all contacts
        HashMap<String,Integer> contactsFound = new HashMap<>(); // hashMap to hold contacts found with place in main contact list
        ArrayList<String> cfName = new ArrayList<>(); // Array for contacts found keys
        int counter = 0;
        int hashPlace = 0;
        String userSearch;

        // Print out options for search fields, prompt user for response and capture it
        System.out.print("\t1 - Name\n" +
                "\t2 - Phone Number\n" +
                "\t3 - Email\n");
        int userSearchField = input.getInt(1,3,"Which field do you want to search by : ");

        // Depending on field prompt user to enter value and store all found similar value in main contact list to
        // HashMap and ArrayList
        switch (userSearchField){
            case 1: // chose name
                userSearch = input.getString("Enter the name you are looking for : ");

                for (int i = 0; i < allContacts.size(); i++){
                    // Search lowercase name property compared to lowercase user input
                    // if it's similar then add to HashMap with location in main contact
                    // add name to ArrayList of names that are similar
                    // and increase the counter of names found that are similar
                    if (allContacts.get(i).getName().toLowerCase().contains(userSearch.toLowerCase())) {
                        contactsFound.put(allContacts.get(i).getName(), hashPlace);
                        cfName.add(allContacts.get(i).getName());
                        counter++;
                    }
                    // Increase hashPlace counter to kep track of spot in main contact
                    hashPlace++;
                }
                break;
            case 2: // chose phone
                userSearch = Contact.validNumber("Enter the phone number without hyphens that you are looking for : ");

                for (int i = 0; i < allContacts.size(); i++){
                    // Search phone property compared to user input
                    // if it's similar then add to HashMap with location in main contact
                    // add phone to ArrayList of phone numbers that are similar
                    // and increase the counter of numbers found that are similar
                    if (allContacts.get(i).getPhone().contains(userSearch)) {
                        contactsFound.put(allContacts.get(i).getPhone(), hashPlace);
                        cfName.add(allContacts.get(i).getPhone());
                        counter++;
                    }
                    // Increase hashPlace counter to kep track of spot in main contact
                    hashPlace++;
                }
                break;
            default: // chose email
                userSearch = validEmail("Enter the email you are looking for : ");

                for (int i = 0; i < allContacts.size(); i++){
                    // Search lowercase email property compared to lowercase user input
                    // if it's similar then add to HashMap with location in main contact
                    // add email to ArrayList of emails that are similar
                    // and increase the counter of emails found that are similar
                    if (allContacts.get(i).getEmail().toLowerCase().contains(userSearch.toLowerCase())) {
                        contactsFound.put(allContacts.get(i).getEmail(), hashPlace);
                        cfName.add(allContacts.get(i).getEmail());
                        counter++;
                    }
                    // Increase hashPlace counter to kep track of spot in main contact
                    hashPlace++;
                }
                break;
        }

        // Spacing buffer
        System.out.print("");

        // Depending on number of options found display info

        // Found more than 1
        if (counter > 1){
            counter = 1;

            // Iterate through array of similar contacts found and list them
            for (String info : cfName){
                System.out.printf("\t%d - %s\n",counter,info);
                counter++;
            }

            int contactWant = input.getInt(1,counter,"Select which entry you want to see : ");
            String nameWant = cfName.get(contactWant-1); // stores name of option
            int mainPlace = contactsFound.get(nameWant); // stores placement in main contact list

            return String.format("\n\t%-28s | %-12s | %s\n",
                    allContacts.get(mainPlace).getName(),
                    allContacts.get(mainPlace).getPhone(),
                    allContacts.get(mainPlace).getEmail());

        // Found only 1
        } else if (counter == 1){
            int name = contactsFound.get(contactsFound.keySet().toArray()[0]);
            return String.format("\n\t%-28s | %-12s | %s\n",
                    allContacts.get(name).getName(),
                    allContacts.get(name).getPhone(),
                    allContacts.get(name).getEmail());
        }

        // Found none
        return "\n\tNo Contact found.";
    }

    public static void main(String[] args) throws IOException{
        System.out.println(searchContact());
    }

}
