package com.bookStore.bookstore.book;

import jakarta.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
            name="book_sequence",
            sequenceName = "book_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private int Id;
    private String title;
    private String author;
    private double price;
    public Book() {
    }

    public Book(int id, String title, String author, double price) {
        this.Id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + Id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Book)){
            return false;
        }
        Book other = (Book) obj;
        return (this.getId() == other.getId()) || (this.getTitle().equals(other.getTitle()) && this.getAuthor().equals(other.getAuthor()));
    }
}
