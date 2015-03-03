package com.biblioteca.user;

import com.biblioteca.item.book.Book;
import com.biblioteca.item.movie.Movie;
import com.biblioteca.item.movie.Rating;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserTest {
    private User user;
    private Book book;
    private Movie movie;

    @Before
    public void setUp() throws Exception {
        user = new User("777-4445", "Dhanesh", "davcdhanesh1@gmail.com", "9096904102");
        book = new Book(1, "A pedagogy of opression", "Paulo Freire", 1987);
        movie = new Movie(1, "Whiplash", "Damien Chazelle", 2014, Rating.TEN);
    }

    @Test
    public void shouldReturnTrueIfUserMatches() throws Exception {
        String expectedUserString = "|777-4445|Dhanesh                         |davcdhanesh1@gmail.com          |9096904102";
        assertThat(user.toString(),is(expectedUserString));
    }

    @Test
    public void testAddItem() throws Exception {
        user.addItem(book);
        user.addItem(movie);

        assertThat(user.borrowedItems(),hasItem(book));
        assertThat(user.borrowedItems(),hasItem(movie));
    }


}