import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Add_ted {

    public static void addContact() throws IOException {




        // Adds new info to contacts.txt
        Files.write(
                Paths.get("src", "contacts.txt"), Arrays.asList("eggs,201-998-9999,yolk@email.com"),StandardOpenOption.APPEND);

        List<String> showMe = Files.readAllLines(Paths.get("src", "contacts.txt"));
        System.out.println(showMe);
    }
}
