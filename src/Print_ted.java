import java.io.IOException;
import java.util.ArrayList;

public class Print_ted{

    public static void showContacts() throws IOException {
        ArrayList<Contact> contacts = Contact.getAllContacts();

        // Cycle thru Contacts and post them in a easy to read format
        for (Contact contact : contacts){
            System.out.printf("\t%-28s | %-12s | %s\n",contact.getName(), contact.getPhone(), contact.getEmail());
        }
    }

}
