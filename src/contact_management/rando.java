package contact_management;

import util.Input;

import java.io.IOException;

public class rando {
    public static void main(String[] args) throws IOException {
        Input input = new Input();

        // Variable to exit application
        int exit = 0;
        // Variable for do-while loop
        int answer;
        // Initial greeting
        System.out.println("\nWelcome to your contacts application!\n");

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
            answer = input.getInt(0,5);

            // Spacing Buffer
            System.out.println("");

            // Action is based on user response
            switch (answer){
                case 1:
                    // Print out all contacts
                    Print_ted.showContacts();
                    break;
                case 2:
                    // Add a contact
//                    System.out.println("add");
                    Add_ted.addContact();
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
