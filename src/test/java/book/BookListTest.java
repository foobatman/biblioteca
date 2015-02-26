package book;

import org.junit.Before;
import org.junit.Test;

import java.util.ResourceBundle;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BookListTest {
    public final String HARRY_POTTER_AND_THE_PHILOSOPHERS_STONE
            = ResourceBundle.getBundle("bookList").getString("HarryPotterAndThePhilosophersStone");
    public final String HARRY_POTTER_AND_THE_CHAMBER_OF_SECRETS
            = ResourceBundle.getBundle("bookList").getString("HarryPotterAndTheChambersOfSecrets");
    BookList bookList;
    private final String JKRowling
            = ResourceBundle.getBundle("bookList").getString("JKRowling");
    private Book harryPotterAndThePhilosophersStone;
    private Book harryPotterAndTheChambersOfSecrets;

    @Before
    public void setUp() throws Exception {
        bookList = new BookList();
        harryPotterAndThePhilosophersStone = new Book(HARRY_POTTER_AND_THE_PHILOSOPHERS_STONE, JKRowling, 1987);
        bookList.add(harryPotterAndThePhilosophersStone);
        harryPotterAndTheChambersOfSecrets = new Book(HARRY_POTTER_AND_THE_CHAMBER_OF_SECRETS, JKRowling, 1987);
        bookList.add(harryPotterAndTheChambersOfSecrets);
    }

    @Test
    public void testListOfBooks() throws Exception {
        assertThat(bookList.count(), is(2));
    }

    @Test
    public void testPrintListOfBooks() throws Exception {
        String expectedBookListOutput = new String();
        expectedBookListOutput += "|Harry Potter and the Philosopher's Stone                        |J K Rowling                     |1987\n";
        expectedBookListOutput += "|Harry Potter and the Chamber of Secrets                         |J K Rowling                     |1987\n";

        assertThat(bookList.toString(),is(expectedBookListOutput));
    }

    @Test
    public void testPrintListOfUncheckedOutBook() throws Exception {
        String expectedBookListOutput = new String();
        expectedBookListOutput += "|Harry Potter and the Philosopher's Stone                        |J K Rowling                     |1987\n";

        harryPotterAndTheChambersOfSecrets.checkOut();

        assertThat(bookList.toString(),is(expectedBookListOutput));
    }
}