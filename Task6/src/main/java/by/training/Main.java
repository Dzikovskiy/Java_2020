package by.training;

import by.training.entity.Author;
import by.training.entity.Book;
import by.training.repository.BookRepository;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();

        ArrayList<Book> books = bookRepository.getAll();

        Book book = new Book();
        book.setIsbnNumber(123123123123L);
        book.setTitle("AHobbit");
        book.setNumberOfPages(1263);
        book.setPublishingHouse("Popury");
        book.setYearOfPublishing(1976);
        Author a1= new Author();
        Author a2 = new Author();
        a1.setName("Tolkin");
        a2.setName("jr Tolkin");
        book.addAuthor(a1);
        book.addAuthor(a2);

        bookRepository.delete(book);
        books.forEach(System.out::println);

    }
}
