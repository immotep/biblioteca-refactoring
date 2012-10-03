package refactoring.biblioteca;

public class LoginItem extends MenuItem{

    private Program program;

    public LoginItem(Program program) {
        super("Wrong username or password.");
        this.program = program;
    }

    @Override
    public String execute() {
        program.logUserIn();

        if (program.loggedIn()){
            return "You are successfully logged in.";
        }
        return super.execute();
    }
}
