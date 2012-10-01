package refactoring.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class MenuItemTest {

    private OutputStream outputStream;

    @Before
    public void before() {
        outputStream = new ByteArrayOutputStream();
    }

    @Test
    public void testMenuItemCommandIsExecuted() throws Exception {

        System.setOut(new PrintStream(outputStream));
        MenuItem item = new MenuItem("string to print");

        item.execute();

        assertThat(outputStream.toString(), containsString("string to print"));
    }
}
