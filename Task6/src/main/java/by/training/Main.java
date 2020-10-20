package by.training;

import by.training.entity.Book;
import by.training.repository.BookRepository;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();

        ArrayList<Book> books = bookRepository.getSortedByTitle();
        books.forEach(System.out::println);

    }
}
