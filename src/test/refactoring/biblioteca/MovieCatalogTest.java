package refactoring.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieCatalogTest {

    @Test
    public void testMovieDetailsIsTheRightFormat() throws Exception {

        MovieCatalog movies = new MovieCatalog();

        String movieRanking = "some rating";
        String movieDirector = "some director";
        String movieTitle = "some title";
        String expected = movieTitle + " - Director: " + movieDirector + " Rating: " + movieRanking;

        assertEquals(expected, movies.createMovie(movieTitle, movieDirector, movieRanking));
    }

    @Test
    public void testListOfAllMoviesIsAppendedWithNewLineForEachMovie() throws Exception {
        MovieCatalog movies = new MovieCatalog();

        String expected = "Rocky - Director: John G. Avildsen Rating: 10" + "\n" +
        "Rocky II - Director: John G. Avildsen Rating: 9" + "\n" +
       "Rocky III - Director: John G. Avildsen Rating: 8" + "\n" +
        "Rocky IV - Director: John G. Avildsen Rating: 7"  + "\n" +
        "Rocky V - Director: John G. Avildsen Rating: 8"   + "\n" +
        "Drainage - Director: Francisco Trindade Rating: N/A"      + "\n" +
        "The Shawshank Redemption - Director: Frank Darabont Rating: 10"   + "\n" +
        "The Godfather - Director: Francis Ford Coppola Rating: 7"  + "\n" +
        "Inception - Director: Frank Darabont Rating: 10"  + "\n" +
        "Pulp Fiction - Director: Quentin Tarantino Rating: 6";

        assertEquals(expected, movies.listOfMovies().trim());
    }
}
