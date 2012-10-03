package refactoring.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static refactoring.biblioteca.StubbedInputStream.stubInputStream;

public class LoginItemTest {


    private  LoginItem loginItem;
    private CurrentUser currentUser;

    @Test
    public void should_not_be_loggedIn_If_wrong_username_supplied() throws Exception {
        System.setIn(stubInputStream().toReturn("wrong_username").then("bhaisahab").atSomePoint());
        currentUser = new CurrentUser(new Program());
        loginItem = new LoginItem(currentUser);

        assertEquals("Wrong username or password.", loginItem.execute());
     }

    @Test
    public void should_not_be_loggedIn_If_wrong_password_supplied() throws Exception {
        System.setIn(stubInputStream().toReturn("111-1111").then("wrong password").atSomePoint());
        currentUser = new CurrentUser(new Program());
        loginItem = new LoginItem(currentUser);

        assertEquals("Wrong username or password.", loginItem.execute());
     }

    @Test
    public void should_logUserIn_If_correct_username_and_password() throws Exception {
        System.setIn(stubInputStream().toReturn("111-1111").then("bhaisahab").atSomePoint());
        currentUser = new CurrentUser(new Program());
        loginItem = new LoginItem(currentUser);

        assertEquals("You are successfully logged in.", loginItem.execute());
     }
}
