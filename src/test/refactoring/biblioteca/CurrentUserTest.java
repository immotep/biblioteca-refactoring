package refactoring.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static refactoring.biblioteca.StubbedInputStream.stubInputStream;

public class CurrentUserTest {


    @Test
    public void no_user_logged_in_by_default() throws Exception {

        CurrentUser currentUser = new CurrentUser(new Program());

        assertEquals(false, currentUser.loggedIn());
    }

    @Test
    public void if_user_logged_in() throws Exception {

        System.setIn(stubInputStream().toReturn("111-1111").then("bhaisahab").atSomePoint());
        CurrentUser currentUser = new CurrentUser(new Program());

        currentUser.logUserIn();

        assertEquals(true, currentUser.loggedIn());
    }


}
