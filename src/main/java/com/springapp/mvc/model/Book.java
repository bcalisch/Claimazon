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
    private String imageName;
    private ArrayList<Author> authors= new ArrayList<Author>();
    private ArrayList<Category> categories = new ArrayList<Category>();

    public Book(){
        if(authors.size()==0) {
            authors.add(new Author());
        }
        if(categories.size()==0){
            categories.add(new Category());

        }
    }
    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

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
        bookString.append("ID: "+this.id+ " -");
        bookString.append("Title: "+this.title+ " -");
        bookString.append("Price: "+currencyFormat.format(this.price)+ " -");
        bookString.append("Description: "+this.description+ " -");
        bookString.append("Publisher: "+this.publisher+ " -");
        bookString.append("Year Published: "+this.yearPublished.substring(0,4)+ " -");
        bookString.append("Image Name: "+this.imageName+ " -");
        bookString.append("Authors: ");
        for(Author author: this.authors){
            bookString.append(author.getFirstName()+ " " + author.getLastName()+", ");
        }
        bookString.append("Categories: ");
        for(Category category: this.categories){
            bookString.append(category.getName()+ ", ");
        }
        return bookString.toString();
    }




}