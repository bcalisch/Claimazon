package com.springapp.mvc.controller;

import com.springapp.mvc.model.Author;
import com.springapp.mvc.model.Book;
import com.springapp.mvc.model.BookComparator;
import com.springapp.mvc.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;


@Controller
public class BookStoreController {
    private String bookStoreServiceURI = ResourceBundle.getBundle("app").getString("bookstoreServiceURI");

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
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
            urlBook = bookStoreServiceURI+"books";
        } else {
            urlBook = bookStoreServiceURI+"books/category/" + category;
        }
        String urlCategory = bookStoreServiceURI+"categories/";

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
        String urlBook = bookStoreServiceURI+"books/id/"+id;;
        ArrayList<LinkedHashMap> books = restTemplate.getForObject(urlBook, ArrayList.class);
        model.addAttribute("bookList", books);

        return "book";
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.GET)
    public String addBookForm( ModelMap model) {
        Book bookForm = new Book();
        model.put("bookForm", bookForm);
        model.addAttribute("bookList", "Test");
        return "newBook";
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.POST)
    public String processAddForm( @ModelAttribute(value="bookForm") Book book,
                                  ModelMap model) {

        String urlBook = bookStoreServiceURI+"book";
        RestTemplate restTemplate = new RestTemplate();
        Book result = restTemplate.postForObject( urlBook, book, Book.class);
        model.addAttribute("result", result);
        return "newBookSuccess";
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

//        switch(order){
//            case("title-asc"):{
//        }
        if (order.equals("title-asc")) {
                Collections.sort(books, new BookComparator.BookComparatorDescending());
            }
        else if (order.equals("title-desc")){
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

    @RequestMapping(value = "/book/delete", method = RequestMethod.GET)
    public String deleteBookForm(@RequestParam ("id")String id, ModelMap model) {
        String urlBook = bookStoreServiceURI+"books/"+id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(urlBook);
        String bookID = "<h3>Book with ID "+id+ "has been deleted<h3>";
        model.addAttribute("DeleteMessage", bookID);
        return "redirect:" + "/";

    }




}