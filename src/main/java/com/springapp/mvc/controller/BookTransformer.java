package com.springapp.mvc.controller;

import com.springapp.mvc.model.Book;
import com.springapp.mvc.model.BookResponse;

import java.util.ArrayList;

/**
 * Created by benjamin on 8/3/15.
 */
public class BookTransformer {
    public static ArrayList<Book> generateBooks(BookResponse response) {
        ArrayList<Book> books = new ArrayList<Book>();

        for (Book bookResponse : response.getBooks()) {
            Book book = new Book();
            book.setTitle(bookResponse.getTitle());
//            article.setTitle(doc.getHeadline().getMain());
//            article.setSnippet(doc.getSnippet());
//            article.setUrl(doc.getWeb_url());
//            articles.add(article);
            books.add(book);
        }

        return books;
    }
}