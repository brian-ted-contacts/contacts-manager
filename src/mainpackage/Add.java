package mainpackage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Add extends Main{
    public static void add_contact() throws IOException {
        File file1 = new File(System.getProperty("user.dir")+"/src/contacts.txt");
        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        OutputStreamWriter writer1 = new OutputStreamWriter(
                new FileOutputStream(System.getProperty("user.dir")+"/src/contacts.txt", true), StandardCharsets.UTF_8);
        BufferedWriter writer = new BufferedWriter(writer1);
        Scanner input= new Scanner(System.in);
        boolean duplicate, valid;
        String currentLine1;
        String f1 = "";
        String f2 = "";
        String f5 = "";
        String f6 = "";
        String f8 = "";
        int f3 = -1;
        int f4 = -1;
        int f7 = -1;
        int f9 = -1;
        String str;
        System.out.println("Give Name: ");
        f1 = input.nextLine();
        System.out.println("Give Surname: ");
        f2 = input.nextLine();
        do {
            duplicate = false;
            valid = true;
            System.out.println("Give Phone: ");

            try {
                f3 = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                valid = false;
                System.out.println("Phone must be number.");

            }
            while((currentLine1 = reader1.readLine()) != null) {
                String[] words1=currentLine1.split(",");
                if(words1[2].equals(String.valueOf(f3))) {
                    duplicate=true;
                    System.out.println("Phone must be unique among the contacts.");
                }
            }
            reader1 = new BufferedReader(new FileReader(file1));
        }while (duplicate || !valid);
        do {
            duplicate = false;
            valid = true;
            System.out.println("Give Mobile phone: ");

            try {
                f4 = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {

                System.out.println("Mobile phone must be number.");
                valid = false;
            }
            while((currentLine1 = reader1.readLine()) != null) {
                String[] words1=currentLine1.split(",");
                if(words1[3].equals(String.valueOf(f4))) {
                    duplicate=true;
                    System.out.println("Mobile Phone must be unique among the contacts.");
                }
            }
            reader1 = new BufferedReader(new FileReader(file1));
        }while (duplicate || !valid);
        do {
            duplicate = false;
            System.out.println("Give E-mail: ");
            f5 = input.nextLine();
            while((currentLine1 = reader1.readLine()) != null) {
                String[] words1=currentLine1.split(",");
                if(words1[4].equals(f5)) {
                    duplicate=true;
                    System.out.println("E-mail must be unique among the contacts.");
                }
            }
            reader1 = new BufferedReader(new FileReader(file1));
        }while (duplicate);
        System.out.println("Give Street: ");
        f6 = input.nextLine();
        System.out.println("Give street number: ");

        do {
            valid = true;
            try {
                f7 = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {

                System.out.println("Street number must be a number.");
                valid = false;
            }
        }while(!valid);
        System.out.println("Give town: ");
        f8 = input.nextLine();
        System.out.println("Give Zip code: ");

        do {
            valid = true;
            try {
                f9 = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {

                System.out.println("Zip code must be a number.");
                valid = false;
            }
        }while(!valid);
        if(f1.equals("") || f2.equals("") || f5.equals("") || f6.equals("") || f8.equals("") || f3 == -1 || f4 == -1 || f7 == -1 || f9 == -1) {
            System.out.println("You gave false inputs, adding new contact wasn't successful: ");
        }
        else {
            str = f1 + "," + f2 + "," + f3 + "," + f4 + "," + f5 + "," + f6 + "," + f7 + "," + f8 + "," + f9;
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file1, true)));
            out.println(str);
            out.close();
        }
        writer.close();
        reader1.close();
    }

}