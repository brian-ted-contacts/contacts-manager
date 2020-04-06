package contact_management;

import util.Input;

import java.io.IOException;
import java.util.ArrayList;

public class Delete_ted {
    static Input input = new Input();

    public static void deleteContact() throws IOException {
        ArrayList<Contact> contacts = Contact.getAllContacts();

        // boolean for do while
        boolean confirmDelete;
        do {
            // Cycle thru Contacts and post them in a easy to read format
            for (int i = 0; i < contacts.size(); i++){
                System.out.printf("\t%-2d - %-28s | %-12s | %s\n",i+1,contacts.get(i).getName(), contacts.get(i).getPhone(), contacts.get(i).getEmail());
            }
            System.out.print("\t0  - Back to main menu\n");

            // Allow user to select contact and store response
            int contactToDelete = input.getInt(0,contacts.size(),"Which contact do you want to delete : ");

            System.out.println(contactToDelete);
            if (contactToDelete >= 1 ){
                // Confirm user wants to delete selected contact
                String prompt = String.format("Are you sure you want to delete %s? \n\t [y/n] > ",contacts.get(contactToDelete-1).getName());
                confirmDelete = input.yesNo(prompt);
                if (!confirmDelete) {
                    deleteContact();
                }
                // Prompt user that contact has been deleted and update contact.txt
                System.out.printf("\n\t%s has been deleted.\n",contacts.get(contactToDelete-1).getName());
                contacts.remove(contactToDelete);
                Contact.updateContacts(contacts);
            }

            confirmDelete = false;
        } while(confirmDelete);

    }

    public static void main(String[] args) throws IOException {
        deleteContact();
    }
}
