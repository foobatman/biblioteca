package menu;

import IO.Printer;
import book.BookList;

public enum Menu {

    ListAllBook("1", "List Books") {
        @Override
        public void perform(BookList bookList, Printer printer) {
            printer.print(bookList.toString());
        }

        @Override
        public boolean shouldContinueRunning() {
            return true;
        }
    },
    InvalidOption("0","Invalid option") {
        @Override
        public String toString() {
            return "";
        }

        @Override
        public boolean shouldContinueRunning() {
            return true;
        }

        @Override
        public void perform(BookList bookList, Printer printer) {
            printer.print("Invalid option!");
        }
    },
    Quit("2","Quit") {
        @Override
        public void perform(BookList bookList, Printer printer) {
            printer.print("Book a week, keeps teacher away!");
        }

        @Override
        public boolean shouldContinueRunning() {
            return false;
        }
    };

    private final String id;

    private final String description;

    Menu(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public abstract void perform(BookList bookList, Printer printer);

    public static void printAll(Printer printer){
        for(Menu menu : Menu.values()) {
            printer.print(menu.toString());
        }
    }

    public static Menu forOption(String option) {
        for(Menu menu : Menu.values()) {
            if(menu.matches(option)) {
                return menu;
            }
        }
        return InvalidOption;
    }

    private boolean matches(String id) {
        return this.id.equals(id);
    }

    @Override
    public String toString() {
        return id + ". " + description;
    }

    public abstract boolean shouldContinueRunning();
}