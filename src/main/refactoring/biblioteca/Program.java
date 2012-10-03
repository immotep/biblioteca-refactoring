package refactoring.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
    private  Menu menu = new Menu(this);

    InputStreamReader inputStream = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(inputStream);

    public static void main(String[] args) {
        new Program().launchApp();
    }

    private  void launchApp() {

        printWelcome();

        while (true) {

            printMenu();

            try{
                int option = Integer.parseInt(getUserInput("Your Selection: "));

                if (option == 9) {
                    System.out.println("Quitting...");
                    break;
                }

                System.out.println("\n" + menu.choose(option) + "\n");

            } catch(NumberFormatException e){
                    System.out.println("Enter a valid integer!!");
            }
        }
    }

    public  String getUserInput(String variable) {
        System.out.println(variable);
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Enter a valid integer!!";
    }

    private  void printMenu() {
        System.out.println("**********************************************************");
        System.out.println("*                Menu                                    *");
        System.out.println("*         =====================                          *");
        System.out.println("*         1. List Book Catalog                           *");
        System.out.println("*         2. Check out Book                              *");
        System.out.println("*         3. Check Library Number                        *");
        System.out.println("*         4. Movie Listing                               *");
        System.out.println("*         5. Login                                       *");
        System.out.println("*         9. Exit                                        *");
        System.out.println("**********************************************************");
    }

    private  void printWelcome() {
        System.out.println("**********************************************************");
        System.out.println("* Welcome to The Bangalore Public Library System - Biblioteca *");
    }


}

