package refactoring.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private Program program;

    public Menu(Program program) {
        this.program = program;
        createMenu();
    }

    private List<MenuItem> allMenu = new ArrayList<MenuItem>();

    private void createMenu(){
          allMenu.add(new MenuItem(new Library().listOfBooks()));
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
