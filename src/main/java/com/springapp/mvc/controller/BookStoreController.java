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
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String printBooksByCategory(@RequestParam("category") String category,
                                       @RequestParam("order") String order,
                                       ModelMap model) {
        RestTemplate restTemplate = new RestTemplate();
        ArrayList<Book> books;
        String urlBook;
        if (category.equals("Default")) {
            urlBook = "http://localhost:8443/bookstore/books";
        } else {
            urlBook = "http://localhost:8443/bookstore/books/category/" + category;
        }
        String urlCategory = "http://localhost:8443/bookstore/categories/";

        ArrayList<LinkedHashMap> booksHashmap = restTemplate.getForObject(urlBook, ArrayList.class);
        ArrayList<Category> categories = restTemplate.getForObject(urlCategory, ArrayList.class);
        books = makeBooks(booksHashmap);
        books = sortBooks(order, books);
        model.addAttribute("bookList", books);
        model.addAttribute("categoryCount", categories);
        model.addAttribute("category", category);
        return "books";
    }
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String printSingleBook(@RequestParam("id") String id, ModelMap model) {
        RestTemplate restTemplate = new RestTemplate();
        String urlBook = "http://localhost:8443/bookstore/books/id/"+id;;
        ArrayList<LinkedHashMap> books = restTemplate.getForObject(urlBook, ArrayList.class);
        model.addAttribute("bookList", books);

        return "book";
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
            if(map.get("imageName") != null){
                book.setImageName(map.get("imageName").toString());
            }


            books.add(book);
        }
        return books;
    }


    private ArrayList<Book> sortBooks(String order, ArrayList<Book> books) {
        /*title-asc">Title: A-Z</option>
            <option value="title-desc">Title: Z-A</option>
            <option value="price-asc">Price: Low to High</option>
            <option value="price-desc*/

        if (order.equals("title-asc")) {
                Collections.sort(books, new BookComparator.BookComparatorDescending());
            }else if (order.equals("title-desc")){
                Collections.sort(books, new BookComparator.BookComparatorAscending());
            }
        else if (order.equals("price-desc")){
            Collections.sort(books, new BookComparator.BookPriceComparatorDescending());
        }
        else if (order.equals("price-asc")){
            Collections.sort(books, new BookComparator.BookPriceComparatorAscending());
        }

        return books;
    }




}