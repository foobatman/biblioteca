package com.biblioteca.menu;

import com.biblioteca.io.Printer;
import com.biblioteca.book.BookIsNotAvailable;
import com.biblioteca.book.BookNotFoundException;
import com.biblioteca.library.Library;

import java.util.Scanner;

public class ReturnBook extends Menu{
    public ReturnBook() {
        super("Return a Book");
    }

    @Override
    public void perform(Library library, Printer printer, Scanner scanner) throws BookNotFoundException, BookIsNotAvailable {
        printer.println("Enter id of Book: ");
        String option = scanner.next();
        library.returnBook(option);
    }

    public boolean shouldContinueRunning() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }


}