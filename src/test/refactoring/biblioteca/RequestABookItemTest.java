package refactoring.biblioteca;

import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

public class RequestABookItemTest {
    @Test
    public void reserveABookShouldReturnThankYouWhenBookIsAvailable() throws Exception {

        RequestABookItem request = new RequestABookItem();
        String book = "1";

        assertEquals(" Thank You! Enjoy the book.", request.process(book));
    }
}
