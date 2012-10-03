package refactoring.biblioteca;

public class CheckLibraryNumberItem extends  MenuItem{


    private Program program;

    public CheckLibraryNumberItem(Program program) {
        super("Please talk to Librarian. Thank you.");
        this.program = program;
    }

    @Override
    public String execute() {
        if (program.loggedIn()) {
            return "Your library number is " + program.getSavedLibraryNumber();
        }

        return super.execute();
    }
}
