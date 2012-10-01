package refactoring.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;
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

        System.setOut(new PrintStream(outputStream));

        menu.choose(1);

        assertThat(outputStream.toString(), containsString("1. Sweet Valley High vol. 4 by John Travolta "));
        assertThat(outputStream.toString(), containsString("2. eXtreme Programming Explained by Kent Beck "));
        assertThat(outputStream.toString(), containsString("3. How to Win Friends and Influence People by Dale Carnagie "));
        assertThat(outputStream.toString(), containsString("4. How to Cheat at TWU Assignements by Anonymous "));
    }

    @Test
    public void testWhen_4_IsSelectedViewAllMoviesMenuOptionIsChosen() throws Exception {

        System.setOut(new PrintStream(outputStream));

        menu.choose(4);

        assertThat(outputStream.toString(), containsString("The Shawshank Redemption - Director: Frank Darabont Rating: 10"));
        assertThat(outputStream.toString(), containsString("Drainage - Director: Francisco Trindade Rating: N/A"));
        assertThat(outputStream.toString(), containsString("Pulp Fiction - Director: Quentin Tarantino Rating: 6"));
    }

    @Test
    public void testWhen_2_IsSelectedReserveABookMenuOptionIsChosen() throws Exception {

        System.setOut(new PrintStream(outputStream));
        System.setIn(stubInputStream().toReturn(ProgramTest.CHECK_OUT_BOOK).then("1").then(ProgramTest.EXIT_CODE).atSomePoint());
        menu = new Menu(new Program());

        menu.choose(2);

        assertThat(outputStream.toString(), containsString(" Please enter the number of the book you wish to checkout: "));
    }
}
