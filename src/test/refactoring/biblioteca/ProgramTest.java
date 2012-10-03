package refactoring.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;
import static refactoring.biblioteca.StubbedInputStream.stubInputStream;

//import static test.StubbedInputStream.stubInputStream;

public class ProgramTest {
    private PrintStream console;
    private ByteArrayOutputStream outputStream;
    private Program program;
    protected static final String EXIT_CODE = "9";
    protected static final String TALK_TO_LIBRARIAN = "3";
    protected static final String CHECK_OUT_BOOK = "2";
    protected static final String LOGIN = "5";

    @Before
    public void before() {
        console = System.out;
        outputStream = new ByteArrayOutputStream();
        program = new Program();
    }

    @Test
    public void show_the_name_of_the_library() throws IOException {
        System.setOut(new PrintStream(outputStream));
        System.setIn(stubInputStream().toReturn(EXIT_CODE).atSomePoint());

        launchApp();

        assertThat(outputStream.toString(), containsString("Welcome to The Bangalore Public Library System"));
    }


    @Test
    public void testUserTypedIntegerIsCorrectlyRead() throws Exception {
        String expectedTypedInteger = "123";
        System.setIn(stubInputStream().toReturn(expectedTypedInteger).atSomePoint());
        program = new Program();

        String input = program.getUserInput("Your Selection: ");

        assertEquals(expectedTypedInteger, input);
    }

    private void launchApp() {
        Program.main(new String[]{});
    }


    @After
    public void after() {
        System.setOut(console);
    }


}
