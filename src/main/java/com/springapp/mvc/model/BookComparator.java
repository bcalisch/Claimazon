package com.springapp.mvc.model;

import java.util.Comparator;

/**
 * Created by benjamin on 8/5/15.
 */

    public class BookComparator implements Comparator<Book> {
        @Override
        public int compare(Book book1, Book book2) {
            return(book1.getTitle().compareToIgnoreCase(book2.getTitle()));
        }

    }

//    public class bookPriceComparatorAscending implements Comparator<Book> {
//        @Override
//        public int compare(Book book1, Book book2) {
//            if(book1.getPrice()<book2.getPrice() ){
//                return-1;
//            }
//            return 1;
//        }
//    }
//    public class bookPriceComparatorDescending implements Comparator<Book> {
//        @Override
//        public int compare(Book book1, Book book2) {
//            if(book1.getPrice()>book2.getPrice()){
//                return-1;
//            }
//            return 1;
//        }
//    }

