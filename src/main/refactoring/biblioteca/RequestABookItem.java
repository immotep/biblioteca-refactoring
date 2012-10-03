package refactoring.biblioteca;

public class RequestABookItem extends MenuItem {

    private Program program;

    public RequestABookItem(Program program) {
        super(" Please enter the number of the book you wish to checkout: \n");
        this.program = program;
    }

    @Override
    public String execute() {
        return process(program.getUserInput(super.execute()));
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
