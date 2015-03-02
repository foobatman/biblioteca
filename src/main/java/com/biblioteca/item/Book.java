package com.biblioteca.item;

public class Book extends Item{
    private final String name;
    private final String author;
    private final int publicationYear;

    public Book(int id, String name, String author, int publicationYear) {
        super(id);
        this.name = name;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return String.format("|%-8d|%-64s|%-32s|%d", id, name, author, publicationYear);
    }

}
