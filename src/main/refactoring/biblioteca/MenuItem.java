package refactoring.biblioteca;

public class MenuItem {
    private String message;

    public MenuItem(String message) {

        this.message = message;
    }

    public String execute() {
       return message;
    }
}
