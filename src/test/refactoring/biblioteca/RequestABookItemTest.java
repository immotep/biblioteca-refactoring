package refactoring.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RequestABookItemTest {

    RequestABookItem request;

    @Before
    public void setUp() throws Exception {
        request = new RequestABookItem();
    }

    @Test
    public void reserveABookShouldReturnThankYouWhenBookIsAvailable() throws Exception {
        String bookNumber = "1";

        assertEquals(" Thank You! Enjoy the book.", request.process(bookNumber));
    }

    @Test
    public void reserveABookShouldReturnSorryIfBookNumberOutOfBound() throws Exception {
        String bookNumber = "6";

        assertEquals("Sorry we don't have that book yet.", request.process(bookNumber));
    }

    @Test
    public void reserveABookShouldReturnSorryIfBookNumberIsNonSense() throws Exception {
        String bookNumber = "non-sense";

        assertEquals("Sorry we don't have that book yet.", request.process(bookNumber));
    }

}
