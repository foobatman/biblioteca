package com.biblioteca.menu;

import com.biblioteca.inputValidator.InputValidationException;
import com.biblioteca.inputValidator.Validator;
import com.biblioteca.io.Printer;
import com.biblioteca.item.InvalidItemException;
import com.biblioteca.item.ItemCanNotBeReturned;
import com.biblioteca.item.ItemIsNotAvailableForCheckOut;
import com.biblioteca.library.Library;
import com.biblioteca.session.UserSession;

import java.util.Scanner;

public class CheckOutMovie extends Menu{

    public CheckOutMovie() { super("Checkout a Movie"); }

    @Override
    public void perform(Library library, Printer printer, Scanner scanner) throws InvalidItemException, ItemIsNotAvailableForCheckOut, ItemCanNotBeReturned, InputValidationException {
        String option;
        library.printAllMovies();
        printer.println("Enter id of Movie: ");
        option = scanner.next();
        Validator.validate(option);
        library.checkOutMovie(option);
    }

    public void perform(UserSession userSession, Library library, Printer printer, Scanner scanner) throws InvalidItemException, ItemIsNotAvailableForCheckOut, ItemCanNotBeReturned, InputValidationException {
        String option;
        library.printAllMovies();
        printer.println("Enter id of Movie: ");
        option = scanner.next();
        Validator.validate(option);
        library.checkOutMovie(option, userSession);
    }

    @Override
    public boolean shouldContinueRunning() { return true; }

}
