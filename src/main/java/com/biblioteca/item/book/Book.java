package com.biblioteca.item.book;

import com.biblioteca.item.Item;

public class Book extends Item {
    private final String author;
    private final int publicationYear;

    public Book(int id, String name, String author, int publicationYear) {
        super(id, name);
        this.author = author;
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return String.format("|%-8d|%-64s|%-32s|%d", id, name, author, publicationYear);
    }

}