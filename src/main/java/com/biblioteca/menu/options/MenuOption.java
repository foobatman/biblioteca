package com.biblioteca.menu.options;

import com.biblioteca.rental.ItemCanNotBeReturned;
import com.biblioteca.inputValidator.InputValidationException;
import com.biblioteca.io.Printer;
import com.biblioteca.rental.ItemIsNotAvailableForCheckOut;
import com.biblioteca.library.Library;
import com.biblioteca.rental.InvalidItemException;
import com.biblioteca.session.UserSession;
import com.biblioteca.user.InvalidLibraryAndPasswordCombination;

import java.util.Scanner;

public abstract class MenuOption {

    private final String description;

    MenuOption(String description) {
        this.description = description;
    }

    public abstract void perform(UserSession userSession, Library library, Printer printer, Scanner scanner) throws InvalidItemException, ItemIsNotAvailableForCheckOut, ItemCanNotBeReturned, InputValidationException, InvalidLibraryAndPasswordCombination;

    public abstract boolean shouldContinueRunning();

    @Override
    public String toString() {
        return description;
    }

    public abstract boolean isSecureLoginRequired();
}
