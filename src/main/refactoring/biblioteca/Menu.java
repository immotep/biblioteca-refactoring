package refactoring.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private Program program;
    private String listOfBooks =   " 1. Sweet Valley High vol. 4 by John Travolta " + "\n" +
    " 2. eXtreme Programming Explained by Kent Beck " + "\n" +
    " 3. How to Win Friends and Influence People by Dale Carnagie " + "\n" +
    " 4. How to Cheat at TWU Assignements by Anonymous ";

    public Menu(Program program) {
        this.program = program;
        createMenu();
    }

    private List<MenuItem> allMenu = new ArrayList<MenuItem>();

    private void createMenu(){
          allMenu.add(new MenuItem(listOfBooks));
          allMenu.add(new MenuItem("bogus"));
          allMenu.add(new MenuItem("bogus"));
          allMenu.add(new MenuItem(new MovieCatalog().listOfMovies()));

    }

    public void choose(int s) {
        if (s == 2) {
            program.checkOutBook(program.reader);
            return;
        }
        try{
            allMenu.get(s-1).execute();
        } catch (IndexOutOfBoundsException e){

        }
    }
}
