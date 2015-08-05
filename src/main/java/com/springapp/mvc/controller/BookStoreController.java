package com.springapp.mvc.controller;

import com.springapp.mvc.model.Author;
import com.springapp.mvc.model.Book;
import com.springapp.mvc.model.BookComparator;
import com.springapp.mvc.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;


@Controller

public class BookStoreController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Click here to see all books");
        return "index";
    }
//
//    @RequestMapping(value = "/books", method = RequestMethod.GET)
//    public String printWelcome2(ModelMap model) {
//        RestTemplate restTemplate = new RestTemplate();
//        String urlBook = "http://localhost:8443/bookstore/books/";
//        String urlCategory = "http://localhost:8443/bookstore/categories/";
//
//        ArrayList<Book> books = restTemplate.getForObject(urlBook, ArrayList.class);
//        ArrayList<Category> categories = restTemplate.getForObject(urlCategory, ArrayList.class);
//        model.addAttribute("bookList", books);
//        model.addAttribute("categoryCount", categories);
//        return "books";
//    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String printBooksByCategory(@RequestParam("category") String category,
                                       @RequestParam("order") String order,
                                       @RequestParam("ascending") Boolean ascending,
                                       ModelMap model) {
        RestTemplate restTemplate = new RestTemplate();
        ArrayList<Book> books = new ArrayList<Book>();
        String urlBook;
        if (category.equals("Default")) {
            urlBook = "http://localhost:8443/bookstore/books";
        } else {
            urlBook = "http://localhost:8443/bookstore/books/category/" + category;
        }
        String urlCategory = "http://localhost:8443/bookstore/categories/";

        ArrayList<LinkedHashMap> booksJSON = restTemplate.getForObject(urlBook, ArrayList.class);
        ArrayList<Category> categories = restTemplate.getForObject(urlCategory, ArrayList.class);
        books = makeBooks(booksJSON);
        books = sortBooks(order, books, ascending);
        if(ascending){
            model.addAttribute("ascending", false);
        }
        else{
            model.addAttribute("ascending", true);
        }
        model.addAttribute("bookList", books);
        model.addAttribute("categoryCount", categories);
        model.addAttribute("category", category);
        return "books";
    }

    private ArrayList<Book> makeBooks(ArrayList<LinkedHashMap> booksJSON) {
        ArrayList<Book> books = new ArrayList<Book>();
        for (LinkedHashMap map : booksJSON) {
            Book book = new Book();
            book.setTitle(map.get("title").toString());
            book.setId(Integer.parseInt(map.get("id").toString()));
            book.setPrice(Double.parseDouble(map.get("price").toString()));
            book.setAuthors(((ArrayList<Author>) (map.get("authors"))));
            book.setCategories((ArrayList<Category>) (map.get("categories")));
            book.setPublisher(map.get("publisher").toString());
            book.setYearPublished((map.get("yearPublished").toString().substring(0, 4)));

            books.add(book);
        }
        return books;
    }


    private ArrayList<Book> sortBooks(String order, ArrayList<Book> books, boolean ascending) {
        if (order.equals("Title")) {
            if(ascending == true){
                Collections.sort(books, new BookComparator.BookComparatorAscending());
            }else{
                Collections.sort(books, new BookComparator.BookComparatorDescending());
            }

        }
        return books;
    }




}