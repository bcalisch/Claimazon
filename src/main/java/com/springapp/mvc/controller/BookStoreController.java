package com.springapp.mvc.controller;

import com.springapp.mvc.model.Book;
import com.springapp.mvc.model.ServiceResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller

public class BookStoreController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        Book book = new Book();
        book.setTitle("Moby Dick");
        StringBuilder string = new StringBuilder();
        string.append(book.getTitle());
        model.addAttribute("message", string.toString());
        return "index";
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String printWelcome2(ModelMap model) {
        StringBuilder string = new StringBuilder();
        ArrayList<Book> books = fetchBooks("http://localhost:8080/bookstore/books/");
        for (Book book : books) {
            string.append(book.getTitle() + " " + book.getPrice() + " " + book.getPublisher() + "\n");
        }
        model.addAttribute("message", string.toString());
        return "book";
    }

    private ArrayList<Book> fetchBooks(String bookStoreApi) {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(messageConverters);
        ServiceResponse response = restTemplate.getForObject(bookStoreApi, ServiceResponse.class);
        ArrayList<Book> books = BookTransformer.generateBooks(response);
        return books;
    }
}