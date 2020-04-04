import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class Print_ted {
    public static void showContacts() throws IOException {
        // Takes information from contact.txt and turns it into an array of strings
        List<String> showMe = Files.readAllLines(Paths.get("src", "contacts.txt"));

        // Cycle thru each line of the document
        for (String s : showMe) {
            // Turn each line into another array of strings
            // separated at the ","
            String[] contactLine = s.split(",");
            // Print out each element into a easy-to-read format
            System.out.printf("\t%-20s | %-12s | %s \n", contactLine[0], contactLine[1], contactLine[2]);
        }
    }
}
