package com.springapp.mvc.model;

import java.util.ArrayList;

/**
 * Created by benjamin on 8/3/15.
 */
public class BookResponse {

        ArrayList<Book> books;

        public  ArrayList<Book> getBooks() {
            return books;
        }

        public void setDocs( ArrayList<Book> books) {
            this.books = books;
        }


}
