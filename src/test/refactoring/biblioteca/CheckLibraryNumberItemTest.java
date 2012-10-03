package refactoring.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static refactoring.biblioteca.StubbedInputStream.stubInputStream;

public class CheckLibraryNumberItemTest {
    private Program program;
    private OutputStream outputStream;
    private CurrentUser currentUser;

    @Before
    public void setUp() throws Exception {
        program = new Program();
        currentUser = new CurrentUser(program);
        outputStream = new ByteArrayOutputStream();
    }

    @Test
    public void shouldReturnTalkToLibrarianIfNoUserIsLoggedInAsByDefault() throws Exception {

        CheckLibraryNumberItem checkMyNumber = new CheckLibraryNumberItem(currentUser);
        assertEquals("Please talk to Librarian. Thank you.", checkMyNumber.execute());
    }

    @Test
    public void successfull_log_in() {
        System.setOut(new PrintStream(outputStream));
        System.setIn(stubInputStream().toReturn("111-1111").then("bhaisahab").atSomePoint());
        currentUser = new CurrentUser(new Program());
        currentUser.logUserIn();

        CheckLibraryNumberItem checkMyNumber = new CheckLibraryNumberItem(currentUser);
        assertEquals("Your library number is 111-1111", checkMyNumber.execute());
     }
}
