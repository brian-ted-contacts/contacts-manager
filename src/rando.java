import java.util.Scanner;

public class rando {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int exit = 0;
        // Loop until user wants to exit the app
        int answer;
        do {
            System.out.print("Welcome to your contacts application!\n\n" +
                    "Please chose from one of the following options: \n" +
                    "\t1 - View all contacts\n" +
                    "\t2 - Add a new contact\n" +
                    "\t3 - Search for a contact by name\n" +
                    "\t4 - Change an existing contact\n" +
                    "\t5 - Delete an existing contact\n" +
                    "\t0 - Exit contact application\n" +
                    " > ");
            String response = input.nextLine();
            try {//we handle the input of the user
                answer = Integer.parseInt(response);
            } catch (NumberFormatException nfe) {
//                e.printStackTrace();
                answer = -1;
            }
            if(answer == 1) {//according to user's input we go to each class
                // Contacts
                System.out.println("contacts");
                break;
            } else if(answer == 2) {
                // Add
                System.out.println("Add");
                break;
            } else if(answer == 3){
                // Search
                System.out.println("search");
                break;
            } else if(answer == 4) {
                // Change
                System.out.println("change");
                break;
            } else if(answer == 5){
                // Delete
                System.out.println("delete");
                break;
            }


        }while(answer != exit);
        System.out.println("Application terminating...");
    }
}
