package refactoring.biblioteca;

public class Menu {

    private Program program;
    private String listOfBooks =   " 1. Sweet Valley High vol. 4 by John Travolta " + "\n" +
    " 2. eXtreme Programming Explained by Kent Beck " + "\n" +
    " 3. How to Win Friends and Influence People by Dale Carnagie " + "\n" +
    " 4. How to Cheat at TWU Assignements by Anonymous ";

    public Menu(Program program) {
        this.program = program;
    }

    public void choose(int s) {
        if (s == 1) {
            new MenuItem(listOfBooks).execute();
        }else if (s == 2) {
            program.checkOutBook(program.reader);
        } else if (s == 4) {
            program.printMovieCatalog();
        }
    }
}
