package refactoring.biblioteca;

public class LoginItem extends MenuItem{

    private Program program;
    private CurrentUser currentUser;

    public LoginItem(Program program) {
        super("Wrong username or password.");
        this.program = program;
        currentUser = new CurrentUser(program);
    }

    @Override
    public String execute() {

        currentUser.logUserIn();

        if (currentUser.loggedIn()){
            return "You are successfully logged in.";
        }
        return super.execute();
    }
}
