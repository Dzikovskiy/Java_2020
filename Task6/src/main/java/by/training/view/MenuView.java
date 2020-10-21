package by.training.view;

import by.training.entity.Book;
import by.training.repository.BookRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuView {
    Scanner scanner = new Scanner(System.in);
    BooksView booksView = new BooksView();
    BookRepository repository = new BookRepository();
    ArrayList<Book> books;

    public void menu() {
        while (true) {
            System.out.println("1. Get all books from file to array");
            System.out.println("2. Print books");
            System.out.println("7. Exit");

            switch (scanner.nextInt()) {
                case 1:
                    books = repository.getAll();
                    break;
                case 2:
                    booksView.printBooks(books);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Wrong command");
                    break;
            }
        }
    }
}
