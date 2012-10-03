package refactoring.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class MovieCatalog {
    
    private List<String> allMovies = new ArrayList<String>();

    public MovieCatalog() {
        createAllMovies();
    }

    private void createAllMovies(){
        allMovies.add(createMovie("Rocky", "John G. Avildsen", "10"));
        allMovies.add(createMovie("Rocky II", "John G. Avildsen", "9"));
        allMovies.add(createMovie("Rocky III", "John G. Avildsen", "8"));
        allMovies.add(createMovie("Rocky IV", "John G. Avildsen", "7"));
        allMovies.add(createMovie("Rocky V", "John G. Avildsen", "8"));
        allMovies.add(createMovie("Drainage", "Francisco Trindade", "N/A"));
        allMovies.add(createMovie("The Shawshank Redemption", "Frank Darabont", "10"));
        allMovies.add(createMovie("The Godfather", "Francis Ford Coppola", "7"));
        allMovies.add(createMovie("Inception", "Frank Darabont", "10"));
        allMovies.add(createMovie("Pulp Fiction", "Quentin Tarantino", "6"));
        
    }
    
    protected  String createMovie(String movieTitle, String movieDirector, String movieRanking) {
        return movieTitle + " - Director: " + movieDirector + " Rating: " + movieRanking;
    }

    protected String listOfMovies(){
        StringBuilder list = new StringBuilder();
        for (String s : allMovies){
            list.append(s).append("\n");
        }

        return list.toString().trim();
    }

}
