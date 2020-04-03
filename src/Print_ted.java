import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class Print_ted {
    public static void showContacts() throws IOException {
        List<String> showMe = Files.readAllLines(Paths.get("src", "contacts.txt"));
        String[] contacts = new String[showMe.size()];
        showMe.toArray(contacts);
        for (String s : contacts) {
            String line = s;
            String[] contactLine = s.split(",");
            List<String> fixedList = Arrays.asList(contactLine);
            ArrayList<String> contactLineList = new ArrayList<String>(fixedList);
            System.out.printf("\t%-20s | %-11s | %s \n", contactLineList.get(0), contactLineList.get(1), contactLineList.get(2));
        }
    }
}
