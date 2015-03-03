package com.biblioteca.user;

import com.biblioteca.item.Item;

import java.util.ArrayList;

public class User {
    private final String libraryNumber;
    private final String name;
    private final String email;
    private final String phoneNumber;
    private ArrayList<Item> borrowedItems;

    public User(String libraryNumber, String name, String email, String phoneNumber) {

        this.libraryNumber = libraryNumber;
        this.name = name;
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

    public ArrayList<Item> getBorrowedItems() {
        return borrowedItems;
    }
}