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
}
