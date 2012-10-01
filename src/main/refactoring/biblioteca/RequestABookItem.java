package refactoring.biblioteca;

public class RequestABookItem extends MenuItem {

    public RequestABookItem() {
        super(" Please enter the number of the book you wish to checkout: \n");
    }

    @Override
    public void execute() {
        super.execute();    //To change body of overridden methods use File | Settings | File Templates.

    }

    public String process(String book) {

        switch (Integer.parseInt(book)) {
            case 1:
            case 2:
            case 3:
            case 4:
                return " Thank You! Enjoy the book.";
            default:
                return "Sorry we don't have that book yet.";
        }
    }
}
