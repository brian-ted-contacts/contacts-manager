package mainpackage;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        int exit = 0;
        int answer;
        do {
            System.out.print("1. View contacts.\n" +
                    "2. Add a new contact.\n" +
                    "3. Search a contact by name.\n" +
                    "4. Delete an existing contact.\n" +
                    "5. Exit.\n" +
                    "Enter an option (1, 2, 3, 4 or 5):");
            try {
                answer = input.nextInt();
            } catch (NumberFormatException e) {

                answer = -1;
            }
            if(answer == 1)
                Print.show_contacts();
            else if(answer == 2)
                Add.add_contact();
            else if(answer == 3)
                Search.choose_field();
            else if(answer == 4)
                Change.choose_field();
            else if(answer == 5)
                Delete.choose_field();


        }while(answer != exit);
        System.out.println("Application terminating...");
    }
}