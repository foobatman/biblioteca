package com.biblioteca.user;

import com.biblioteca.item.Item;

import java.util.ArrayList;

public class User {
    private final String libraryNumber;
    private final String name;
    private String passWord;
    private final String email;
    private final String phoneNumber;
    private ArrayList<Item> borrowedItems;

    public User(String libraryNumber, String name, String passWord, String email, String phoneNumber) {

        this.libraryNumber = libraryNumber;
        this.name = name;
        this.passWord = passWord;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.borrowedItems = new ArrayList<Item>();
    }

    @Override
    public String toString() {
        return String.format("|%-8s|%-32s|%-32s|%-10s", libraryNumber, name, email, phoneNumber);
    }

    public void addItem(Item item) {
        borrowedItems.add(item);
    }

    public String getBorrowedItems() {
        String result = new String();
        for(Item item : borrowedItems) {
            result = String.format("|%-12s|%-16s", libraryNumber, item.description());
        }
        return result;
    }

    public boolean matches(String libraryNumber, String passWord) {
        return this.libraryNumber.equals(libraryNumber) && this.passWord.equals(passWord);
    }
}
