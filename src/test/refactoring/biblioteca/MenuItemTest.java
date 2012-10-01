package refactoring.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import static org.junit.Assert.assertEquals;

public class MenuItemTest {

    private OutputStream outputStream;

    @Before
    public void before() {
        outputStream = new ByteArrayOutputStream();
    }

    @Test
    public void testMenuItemCommandIsExecuted() throws Exception {

        MenuItem item = new MenuItem("string to print");

        assertEquals("string to print", item.execute());
    }
}
