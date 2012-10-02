package refactoring.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static refactoring.biblioteca.StubbedInputStream.stubInputStream;

public class CheckLibraryNumberItemTest {
    Program program;

    @Before
    public void setUp() throws Exception {
        program = new Program();
    }

    @Test
    public void shouldReturnTalkToLibrarianIfNoUserIsLoggedInAsByDefault() throws Exception {

        CheckLibraryNumberItem checkMyNumber = new CheckLibraryNumberItem(program);
        assertEquals("Please talk to Librarian. Thank you.", checkMyNumber.execute());
    }

    @Test
    public void successfull_log_in() {
        System.setIn(stubInputStream().toReturn("111-1111").then("bhaisahab").atSomePoint());
        program = new Program();
        program.logUserIn(program.reader);

        CheckLibraryNumberItem checkMyNumber = new CheckLibraryNumberItem(program);
        assertEquals("Your library number is 111-1111", checkMyNumber.execute());
     }
}
