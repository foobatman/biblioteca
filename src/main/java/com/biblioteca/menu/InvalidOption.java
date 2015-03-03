package com.biblioteca.menu;

import com.biblioteca.io.Printer;
import com.biblioteca.library.Library;
import com.biblioteca.session.UserSession;

import java.util.Scanner;

public class InvalidOption extends Menu {

    public InvalidOption() {
        super("Invalid Option!");
    }

    @Override
    public void perform(UserSession userSession, Library library, Printer printer, Scanner scanner) {
        printer.println("Invalid option!");
    }

    @Override
    public boolean shouldContinueRunning() {
        return true;
    }

}
