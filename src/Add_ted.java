
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Add_ted {
    Contact contacts = new Contact();

    public static void addContact() throws IOException {
        Scanner input = new Scanner(System.in);
        ArrayList<Contact> contactMatch = new ArrayList<>();

        // Prompt user to enter a name
        System.out.print("Please enter contact's name : ");
        String newContactName = input.nextLine();

        // Search contacts for similar name

            // If found prompt user if they want to override this contact

            // If not the addContacts()

        // If no name found then add name to holding list

        // Prompt user for the phone number of the contact

        // Use Contact.validNumber() then Contact.correctPhoneFormat()

        // Add phone number to holding list

        // Prompt user for email

        // Use Contacts.validEmail()

        // Add email to holding list


        // Adds new info to contacts.txt
        Files.write(
                Paths.get("src", "contacts.txt"), Arrays.asList("eggs,201-998-9999,yolk@email.com"),StandardOpenOption.APPEND);

        List<String> showMe = Files.readAllLines(Paths.get("src", "contacts.txt"));
        System.out.println(showMe);
    }

    public static void main(String[] args) {

    }
}
