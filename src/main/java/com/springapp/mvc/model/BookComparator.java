package com.springapp.mvc.model;

import java.util.Comparator;

/**
 * Created by benjamin on 8/5/15.
 */

    public class BookComparator {
       public static class BookComparatorDescending implements Comparator<Book> {
           @Override
           public int compare(Book book1, Book book2) {
               return (book1.getTitle().compareToIgnoreCase(book2.getTitle()));
           }
       }
    public static class BookComparatorAscending implements Comparator<Book> {
        @Override
        public int compare(Book book1, Book book2) {
            return(book2.getTitle().compareToIgnoreCase(book1.getTitle()));
        }
    }
    public static class BookPriceComparatorAscending implements Comparator<Book> {
        @Override
        public int compare(Book book1, Book book2) {
            if(book1.getPrice()>book2.getPrice()) {
                return 1;
            }else return -1;

        }
    }
    public static class BookPriceComparatorDescending implements Comparator<Book> {
        @Override
        public int compare(Book book1, Book book2) {
            if(book1.getPrice()<book2.getPrice()) {
                return 1;
            }else return -1;

        }
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

