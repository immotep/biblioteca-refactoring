package refactoring.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static refactoring.biblioteca.StubbedInputStream.stubInputStream;

public class LoginItemTest {

    private OutputStream outputStream;
    private  LoginItem loginItem;
    private Program program;

    @Before
    public void setUp() throws Exception {
       outputStream = new ByteArrayOutputStream();
       program = new Program();
       loginItem = new LoginItem(program);
    }

    @Test
    public void should_not_be_loggedIn_If_wrong_username_supplied() throws Exception {

        System.setOut(new PrintStream(outputStream));
        System.setIn(stubInputStream().toReturn("wrong_username").then("bhaisahab").atSomePoint());
        loginItem = new LoginItem(new Program());

        assertEquals("Wrong username or password.", loginItem.execute());
     }

    @Test
    public void should_not_be_loggedIn_If_wrong_password_supplied() throws Exception {

        System.setOut(new PrintStream(outputStream));
        System.setIn(stubInputStream().toReturn("111-1111").then("wrong password").atSomePoint());
        loginItem = new LoginItem(new Program());

        assertEquals("Wrong username or password.", loginItem.execute());
     }

    @Test
    public void should_logUserIn_If_correct_username_and_password() throws Exception {

        System.setOut(new PrintStream(outputStream));
        System.setIn(stubInputStream().toReturn("111-1111").then("bhaisahab").atSomePoint());
        loginItem = new LoginItem(new Program());

        assertEquals("You are successfully logged in.", loginItem.execute());
     }
}
