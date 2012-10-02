package refactoring.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static refactoring.biblioteca.StubbedInputStream.stubInputStream;

public class MenuTest {

    private OutputStream outputStream;
    private Menu menu;

    @Before
    public void before() {
        outputStream = new ByteArrayOutputStream();
        menu = new Menu(new Program());
     }

    @Test
    public void testWhen_1_IsSelectedPrintAllBookMenuOptionIsChosen() throws Exception {

        String listOfBooks = "1. Sweet Valley High vol. 4 by John Travolta " + "\n" +
                "2. eXtreme Programming Explained by Kent Beck " + "\n" +
                "3. How to Win Friends and Influence People by Dale Carnagie " + "\n" +
                "4. How to Cheat at TWU Assignements by Anonymous";

        assertEquals(listOfBooks, menu.choose(1).trim());
 }

    @Test
    public void testWhen_4_IsSelectedViewAllMoviesMenuOptionIsChosen() throws Exception {

        String listOfMovies = "Rocky - Director: John G. Avildsen Rating: 10\n" +
                "Rocky II - Director: John G. Avildsen Rating: 9\n" +
                "Rocky III - Director: John G. Avildsen Rating: 8\n" +
                "Rocky IV - Director: John G. Avildsen Rating: 7\n" +
                "Rocky V - Director: John G. Avildsen Rating: 8\n" +
                "Drainage - Director: Francisco Trindade Rating: N/A\n" +
                "The Shawshank Redemption - Director: Frank Darabont Rating: 10\n" +
                "The Godfather - Director: Francis Ford Coppola Rating: 7\n" +
                "Inception - Director: Frank Darabont Rating: 10\n" +
                "Pulp Fiction - Director: Quentin Tarantino Rating: 6";

        assertEquals(listOfMovies, menu.choose(4).trim());
    }

    @Test
    public void testWhen_2_IsSelectedReserveABookMenuOptionIsChosen() throws Exception {

        System.setOut(new PrintStream(outputStream));
        System.setIn(stubInputStream().toReturn(ProgramTest.CHECK_OUT_BOOK).then("1").then(ProgramTest.EXIT_CODE).atSomePoint());
        menu = new Menu(new Program());

        assertEquals(" Thank You! Enjoy the book.", menu.choose(2));
    }

    @Test
    public void testWhen_3_IsSelectedCheckMyLibraryNumberMenuOptionIsChosen() throws Exception {

        System.setOut(new PrintStream(outputStream));
        System.setIn(stubInputStream().toReturn(ProgramTest.TALK_TO_LIBRARIAN).atSomePoint());
        menu = new Menu(new Program());

        assertEquals("Please talk to Librarian. Thank you.", menu.choose(3));
    }
}
