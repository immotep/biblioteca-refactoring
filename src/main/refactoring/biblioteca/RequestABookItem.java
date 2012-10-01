package refactoring.biblioteca;

public class RequestABookItem extends MenuItem {

    public RequestABookItem() {
        super(" Please enter the number of the book you wish to checkout: \n");
    }

    @Override
    public String execute() {
        super.execute();
        return process(new Program().getUserInput());
    }

    public String process(String book) {

        try{
            int bookNumber = Integer.parseInt(book);
            if (feasible(bookNumber)){
                return " Thank You! Enjoy the book.";
            }
        } catch (NumberFormatException e){}

        return "Sorry we don't have that book yet.";
    }

    private boolean feasible(int bookNumber) {
        return bookNumber <= new Library().getNumberOfBooks() && bookNumber >=0;
    }
}
