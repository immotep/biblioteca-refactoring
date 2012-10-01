package refactoring.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    @Test
    public void testlistOfAllBooks() throws Exception {
        Library library = new Library();

        String expected = "1. Sweet Valley High vol. 4 by John Travolta \n" +
                "2. eXtreme Programming Explained by Kent Beck \n" +
                "3. How to Win Friends and Influence People by Dale Carnagie \n" +
                "4. How to Cheat at TWU Assignements by Anonymous";

        assertEquals(expected, library.listOfBooks().trim());
    }
}
