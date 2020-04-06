package contact_management;

import util.Input;

import java.io.IOException;
import java.util.ArrayList;

public class Delete extends Contact {
    static Input input = new Input();

    public static String deleteContact() throws IOException {
        var contacts = getAllContacts();

        // Cycle thru Contacts and post them in a easy to read format
        for (int i = 0; i < contacts.size(); i++){
            System.out.printf("\t%-2d - %-28s | %-12s | %s\n",i+1,contacts.get(i).getName(), contacts.get(i).getPhone(), contacts.get(i).getEmail());
        }
        System.out.print("\t0  - Back to main menu\n");

        // Allow user to select contact and store response
        int contactToDelete = input.getInt(0,contacts.size(),"Which contact do you want to delete : ");

        // If user chose a contact to delete
        if (contactToDelete != 0 ){
            // Confirm user wants to delete selected contact
            String prompt = String.format("Are you sure you want to delete %s? \n\t [y/n] > ",contacts.get(contactToDelete-1).getName());
            boolean confirmDelete = input.yesNo(prompt);
            // If user said they didn't want to delete contact after all
            // then return to delete menu
            if (!confirmDelete) {
                deleteContact();
            }
            // Prompt user that contact has been deleted and update contact.txt
            System.out.printf("\n\t%s has been deleted.\n",contacts.get(contactToDelete-1).getName());
            contacts.remove(contactToDelete-1);
            updateContacts(contacts);
        }

        return "";

    }

}
