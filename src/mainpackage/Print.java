package mainpackage;

import java.io.*;

public class Print extends Main{
    public static void show_contacts() throws IOException {
        File file = new File(System.getProperty("user.dir")+"/src/contacts.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine;
        boolean first = false;
        String[] fields = new String[0];
        while((currentLine = reader.readLine()) !=null) {
            if(!first) {
                fields = currentLine.split(",");
                first = true;
            }
            else {
                System.out.println("-------------------");
                String[] info=currentLine.split(",");
                for (int i = 0; i < fields.length; i++ ) {
                    System.out.println(fields[i] +": "+ info[i]);
                }
            }
        }
        System.out.println("-------------------");
        reader.close();
    }
}