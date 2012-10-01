package refactoring.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Program {
    private  boolean loggedIn = false;
    private  String savedLibraryNumber = "";
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

            int i1 = getUserInput(reader);

            menu.choose(i1);

           if (i1 == 3) {
                checkLibraryNumber();
            } else if (i1 == 5) {
                logUserIn(reader);
            } else if (i1 == 9) {
                System.out.println("Quitting...");
                break;
            } else {
                System.out.println("\n");
                System.out.println("Enter a valid integer!!");
            }
        }
    }

    private  void logUserIn(BufferedReader reader) {
        clearLogin();
        System.out.println("Enter your library number");
        try {
            String libraryNumber = reader.readLine();
            if (validLibraryNumber(libraryNumber)) {
                try {
                    System.out.println("Enter your Password: ");
                    String password = reader.readLine();
                    if (validPassword(password)) {
                        loggedIn = true;
                        savedLibraryNumber = libraryNumber;
                    }
                } catch (Exception e) {

                }
            }
        } catch (Exception e) {

        }
    }

    private  void checkLibraryNumber() {
        if (loggedIn()) {
            System.out.println("\n");
            System.out.println("Your library number is " + savedLibraryNumber);
        } else {

            System.out.println("\n");
            System.out.println("Please talk to Librarian. Thank you.");
        }
    }

    protected void checkOutBook(BufferedReader reader) {
        System.out.println(" Please enter the number of the book you wish to checkout: ");

        switch (getUserInput(reader)) {
            case 1:
                System.out.println("\n");
                System.out.println(" Thank You! Enjoy the book.");
                break;
            case 2:
                System.out.println("\n");
                System.out.println(" Thank You! Enjoy the book.");
                break;
            case 3:
                System.out.println("\n");
                System.out.println(" Thank You! Enjoy the book.");
                break;
            case 4:
                System.out.println("\n");
                System.out.println(" Thank You! Enjoy the book.");
                break;
            default:
                System.out.println("\n");
                System.out.println("Sorry we don't have that book yet.");
        }
    }

    public  int getUserInput(BufferedReader reader) {
        int i1 = 0;
        try {
            String value = reader.readLine();
            i1 = Integer.parseInt(value);
        } catch (Exception e) {
            // Do you know what numbers are!!!
            System.out.println("Enter a valid integer!!");
        }
        return i1;
    }

    private  void printMenu() {
        System.out.println("*                Menu                                    *");
        System.out.println("*         =====================                          *");
        System.out.println("*         1. List Book Catalog                           *");
        System.out.println("*         2. Check out Book                              *");
        System.out.println("*         3. Check Library Number                        *");
        System.out.println("*         4. Movie Listing                               *");
        System.out.println("*         5. Login                                       *");
        System.out.println("*         9. Exit                                        *");
        System.out.println("**********************************************************");
        System.out.println("Your Selection: ");
    }

    private  void printWelcome() {
        System.out.println("**********************************************************");
        System.out.println("* Welcome to The Bangalore Public Library System - Biblioteca *");
        System.out.println("**********************************************************");
    }

    private  boolean validPassword(String password) {
        return "bhaisahab".equals(password);
    }

    private  boolean validLibraryNumber(String libraryNumber) {
        return libraryNumber.matches("\\d\\d\\d-\\d\\d\\d\\d");
    }

    private  boolean loggedIn() {
        return loggedIn;
    }


    public  void clearLogin() {
        loggedIn = false;
        savedLibraryNumber = "";
    }

    private  String createMovie(String movieTitle, String movieDirector, String movieRanking) {
        return movieTitle + " - Director: " + movieDirector + " Rating: " + movieRanking;
    }
}

