package refactoring.biblioteca;

public class CurrentUser {

    private  boolean loggedIn = false;
    private  String savedLibraryNumber = "";
    private Program program;

    public CurrentUser(Program program) {
        this.program = program;
    }

    public  boolean loggedIn() {
        return loggedIn;
    }

    public  void clearLogin() {
        loggedIn = false;
        savedLibraryNumber = "";
    }

    public String getSavedLibraryNumber() {
        return savedLibraryNumber;
    }

    private  boolean validPassword(String password) {
        return "bhaisahab".equals(password);
    }

    private  boolean validLibraryNumber(String libraryNumber) {
        return libraryNumber.matches("\\d\\d\\d-\\d\\d\\d\\d");
    }

    protected void logUserIn() {
        clearLogin();
        String libraryNumber = program.getUserInput("Enter your library number");
        String password = program.getUserInput("Enter your Password: ");
        if (validLibraryNumber(libraryNumber) && validPassword(password)) {
            loggedIn = true;
            savedLibraryNumber = libraryNumber;
        }
    }
}