
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.Scanner;

public class rando {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        // Variable to exit application
        int exit = 0;
        // Variable for do-while loop
        int answer;
        // Initial greeting
        System.out.println("Welcome to your contacts application!\n\n");

        // Loop until user wants to exit the app
        do {
            // List options
            System.out.print("Please chose from one of the following options: \n" +
                    "\t1 - View all contacts\n" +
                    "\t2 - Add a new contact\n" +
                    "\t3 - Search for a contact by name\n" +
                    "\t4 - Change an existing contact\n" +
                    "\t5 - Delete an existing contact\n" +
                    "\t0 - Exit contact application\n" +
                    " > ");

            // Capture and store userResponse
            String response = input.nextLine();

            // Spacing Buffer
            System.out.println("");

            // Try to handle the input of the user
            try {

                // Checking to see if response was a Integer
                answer = Integer.parseInt(response);

            // Catch above exceptions
            } catch (NumberFormatException nfe) {

                // send error to error_log.txt
//                e.printStackTrace();

                // Set answer to something other that options to loop
                answer = -1;
            }

            // If user response if valid see what they want to do

            switch (answer){
                case 1:
                    // Print out all contacts
                    Print_ted.showContacts();
                    break;
                case 2:
                    // Add a contact
                    System.out.println("add");
                    break;
                case 3:
                    // Search for contact
                    System.out.println("search");
                    break;
                case 4:
                    // Change contact
                    System.out.println("change");
                    break;
                case 5:
                    // Delete contact
                    System.out.println("delete");
                    break;
                default:
                    break;
            }

            // Spacing Buffer
            System.out.println("");

        }while(answer != exit);

        // Farewell message
        System.out.println("Application terminating...");

    }

}
