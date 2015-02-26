import IO.Printer;
import library.Library;
import book.BookNotFoundException;
import menu.Menu;
import menu.MenuList;

import java.util.ResourceBundle;
import java.util.Scanner;

public class BibliotecaApp {

    private Printer printer;
    private Scanner scanner;
    private MenuList menuList;

    public BibliotecaApp(Printer printer, Scanner scanner, MenuList menuList) {

        this.printer = printer;
        this.scanner = scanner;
        this.menuList = menuList;
    }

    public void run(Library library) throws BookNotFoundException {
        bootStrapApp();
        Menu menu; String option;
        scanner.useDelimiter("\n");
        while(scanner.hasNext()) {
            option = scanner.next();
            menu = menuList.find(option);
            menu.perform(library, printer, scanner);
            if(!menu.shouldContinueRunning()) {
                break;
            }
        }
    }

    private void bootStrapApp() {
        printWelcomeMessage();
        printSeparatorLine();
        printMenuList();
        printPrompt();
    }

    private void printMenuList() {
        menuList.printAll(printer);
    }

    private void printPrompt() {
        printer.println("Select Option: ");
    }

    private void printSeparatorLine() {
        printer.println("-----------------------------------------------------------------------------");
    }

    private void printWelcomeMessage() {
        printer.println(ResourceBundle.getBundle("BibliotecaAppMessages").getString("WelcomeMessage"));
    }
}
