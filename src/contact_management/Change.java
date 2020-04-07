package contact_management;

import util.Input;

import java.io.IOException;
import java.util.ArrayList;

public class Change extends Contact {
    static Input input = new Input();

    public static String changeContact() throws IOException {
        ArrayList<Contact> contacts = getAllContacts();

        // Cycle thru Contacts and post them in a easy to read format
        for (int i = 0; i < contacts.size(); i++) {
            System.out.printf("\t%-2d - %-28s | %-12s | %s\n", i + 1, contacts.get(i).getName(), contacts.get(i).getPhone(), contacts.get(i).getEmail());
        }
        System.out.print("\t0  - Back to main menu\n");

        // Allow user to select contact and store response
        int contactToChange = input.getInt(0, contacts.size(), "Which contact do you want to change : ");

        // Decide what to do based on selection
        if (contactToChange == 0) {
            return "";
        }
        // Have user change contact name and set it
        System.out.print("\nCurrent name : " + contacts.get(contactToChange - 1).getName());
        String newName = isDuplicate(1, "Enter new name : ");
        contacts.get(contactToChange - 1).setName(newName);

        // Have user change contact phone and set it
        System.out.print("\nCurrent phone : " + contacts.get(contactToChange - 1).getPhone());
        String newPhone = validNumber("Enter new phone : ");
        contacts.get(contactToChange - 1).setPhone(newPhone);

        // Have user change contact email and set it
        System.out.print("\nCurrent email : " + contacts.get(contactToChange - 1).getEmail());
        String newEmail = validEmail("Enter new email : ");
        contacts.get(contactToChange - 1).setEmail(newEmail);

        // Prompt user that contact has been changed and update contact.txt
        updateContacts(contacts);
        return String.format("\n\t%s has been changed.\n", newName);
    }
}
