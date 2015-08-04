package com.springapp.mvc.controller;

import com.springapp.mvc.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;


@Controller

public class BookStoreController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Click here to see all books");
        return "index";
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String printWelcome2(ModelMap model, String id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8443/bookstore/books/";
        ArrayList<Book> books = restTemplate.getForObject(url, ArrayList.class);
        model.addAttribute("bookList", books);
        return "books";
    }


}