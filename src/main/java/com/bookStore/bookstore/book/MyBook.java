package com.bookStore.bookstore.book;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "My_Books")
public class MyBook {
    @Id
    private int Id;
    private String title;
    private String author;
    private double price;
    public MyBook() {
    }
    public MyBook(int id, String title, String author, double price) {
        this.Id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public MyBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
