package refactoring.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<String> allBooks = new ArrayList<String>();
    private int numberOfBooks;

    public Library() {
        createAllBooks();
    }

    private void createAllBooks(){
        allBooks.add(" Sweet Valley High vol. 4 by John Travolta ");
        allBooks.add(" eXtreme Programming Explained by Kent Beck " );
        allBooks.add(" How to Win Friends and Influence People by Dale Carnagie ");
        allBooks.add(" How to Cheat at TWU Assignements by Anonymous ");

        numberOfBooks = allBooks.size();
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    protected  String createBook(String details) {
        return details;
    }

    protected String listOfBooks(){
        StringBuilder list = new StringBuilder();
        for (String s : allBooks){
            list.append(String.valueOf(allBooks.indexOf(s)+1)).append(".").append(s).append("\n");
        }

        return list.toString().trim();
    }

}
