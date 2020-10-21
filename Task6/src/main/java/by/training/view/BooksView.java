package by.training.view;

import by.training.entity.Book;

import java.util.ArrayList;

public class BooksView {

    public void printBooks(ArrayList<Book> books){
        books.forEach(System.out::println);
    }
}
