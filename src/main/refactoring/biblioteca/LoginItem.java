package refactoring.biblioteca;

public class LoginItem extends MenuItem{

    private CurrentUser currentUser;

    public LoginItem(CurrentUser currentUser) {
        super("Wrong username or password.");
        this.currentUser = currentUser;
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
