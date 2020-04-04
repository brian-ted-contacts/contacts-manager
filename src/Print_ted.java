import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class Print_ted {
    public static List<String> allContacts() throws IOException {
        // Takes information from contact.txt and turns it into an array of strings
        return Files.readAllLines(Paths.get("src","contacts.txt"));
    }

    public static void showContacts() throws IOException {
        // Cycle thru each line of the document
        for (String s : allContacts()) {
            // Turn each line into another array of strings
            // separated at the ","
            String[] contactLine = s.split(",");
            // Print out each element into a easy-to-read format
            System.out.printf("\t%-20s | %-12s | %s \n", contactLine[0], contactLine[1], contactLine[2]);
        }
    }

    public static void main(String[] args) throws IOException {
        // Iterates through contacts to see if a given name is found
        for (String str : allContacts()){
            String res = "Wind";
            String found;
            if (str.toLowerCase().contains(res.toLowerCase())){// If found
                found = str;
                System.out.println("A contact with ");

            }
        }


    }

}
