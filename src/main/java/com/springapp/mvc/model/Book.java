package com.springapp.mvc.model;


import java.text.NumberFormat;
import java.util.ArrayList;

public class Book {
    private static final NumberFormat currencyFormat = NumberFormat.getInstance();
    private Integer id;
    private String title;
    private double price;
    private String description;
    private String publisher;
    private String yearPublished;
    private ArrayList<Author> authors= new ArrayList<Author>();
    private ArrayList<Category> categories = new ArrayList<Category>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {

    StringBuilder bookString = new StringBuilder();
        bookString.append("ID: "+this.title+ " -");
        bookString.append("Title: "+this.title+ " -");
        bookString.append("Price: "+currencyFormat.format(this.price)+ " -");
        bookString.append("Description: "+this.title+ " -");
        bookString.append("Publisher: "+this.publisher+ " -");
        bookString.append("Year Published: "+this.yearPublished.substring(0,4)+ " -");
        return bookString.toString();
    }

}