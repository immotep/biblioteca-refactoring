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
          allMenu.add(new RequestABookItem(program));
          allMenu.add(new CheckLibraryNumberItem(program));
          allMenu.add(new MenuItem(new MovieCatalog().listOfMovies()));
          allMenu.add(new LoginItem(program));
    }

    public String choose(int s) {
        try{
            return allMenu.get(s-1).execute();
        } catch (IndexOutOfBoundsException e){
           return "Select a valid integer!!";
        }
    }
}
