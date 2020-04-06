package contact_management;

import util.Input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Search {
    static Input input = new Input();

    public static void searchContact() throws IOException {
        ArrayList<Contact> allContacts = Contact.getAllContacts(); // Contains all contacts
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
            case 1:
                userSearch = input.getString("Enter the name you are looking for : ");

                for (int i = 0; i < allContacts.size(); i++){
                    if (allContacts.get(i).getName().equalsIgnoreCase(userSearch)) {
                        contactsFound.put(allContacts.get(i).getName(), hashPlace);
                        cfName.add(allContacts.get(i).getName());
                        counter++;
                    }
                    hashPlace++;
                }
                break;
            case 2:
                userSearch = Contact.validNumber("Enter the phone number without hyphens that you are looking for : ");

                for (int i = 0; i < allContacts.size(); i++){
                    if (allContacts.get(i).getPhone().equalsIgnoreCase(userSearch)) {
                        contactsFound.put(allContacts.get(i).getPhone(), hashPlace);
                        cfName.add(allContacts.get(i).getPhone());
                        counter++;
                    }
                    hashPlace++;
                }
                break;
            default:
                userSearch = Contact.validEmail("Enter the email you are looking for : ");

                for (int i = 0; i < allContacts.size(); i++){
                    if (allContacts.get(i).getEmail().equalsIgnoreCase(userSearch)) {
                        contactsFound.put(allContacts.get(i).getEmail(), hashPlace);
                        cfName.add(allContacts.get(i).getEmail());
                        counter++;
                    }
                    hashPlace++;
                }
                break;
        }

        // Depending on number of options found display info or ask user which one they want to see
        if (counter > 1){
            counter = 1;
            for (String info : cfName){ // list all options
                System.out.printf("\t%d - %s",counter,info);
            }
            int contactWant = input.getInt(1,counter,"Select which entry you want to see : ");
            String nameWant = cfName.get(contactWant); // stores name of option
            int mainPlace = contactsFound.get(nameWant); // stores placement in main contact list

            System.out.printf("\t%-28s | %-12s | %s\n",
                    allContacts.get(mainPlace).getName(),
                    allContacts.get(mainPlace).getPhone(),
                    allContacts.get(mainPlace).getEmail());


        } else if (counter == 1){
            System.out.printf("\n\t%-28s | %-12s | %s\n",
                    allContacts.get(contactsFound.get(userSearch)).getName(),
                    allContacts.get(contactsFound.get(userSearch)).getPhone(),
                    allContacts.get(contactsFound.get(userSearch)).getEmail());
        } else {
            System.out.println("\n\tNo Contact found.");
        }
    }

}
