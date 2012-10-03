package refactoring.biblioteca;

public class CheckLibraryNumberItem extends  MenuItem{


    private CurrentUser currentUser;

    public CheckLibraryNumberItem(CurrentUser currentUser) {
        super("Please talk to Librarian. Thank you.");
        this.currentUser = currentUser;
    }

    @Override
    public String execute() {

        if (currentUser.loggedIn()) {
            return "Your library number is " + currentUser.getSavedLibraryNumber();
        }

        return super.execute();
    }
}
