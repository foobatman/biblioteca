package com.biblioteca.menu.options;

import com.biblioteca.inputValidator.InputValidationException;
import com.biblioteca.io.Printer;
import com.biblioteca.item.ItemCanNotBeReturned;
import com.biblioteca.item.ItemIsNotAvailableForCheckOut;
import com.biblioteca.item.InvalidItemException;
import com.biblioteca.library.Library;
import com.biblioteca.session.UserSession;

import java.util.Scanner;

public class ListAllMovies extends MenuOption {

    public ListAllMovies() {
        super("List Movies");
    }

    @Override
    public void perform(UserSession userSession, Library library, Printer printer, Scanner scanner) throws InvalidItemException, ItemIsNotAvailableForCheckOut, ItemCanNotBeReturned, InputValidationException {
        library.printAllMovies();
    }

    @Override
    public boolean shouldContinueRunning() {
        return true;
    }

    @Override
    public boolean isSecureLoginRequired() {
        return false;
    }

}