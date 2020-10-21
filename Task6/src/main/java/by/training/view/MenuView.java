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
    Book book;

    public void menu() {
        while (true) {
            System.out.println("1. Get all books from file to array");
            System.out.println("2. Print books");
            System.out.println("3. Add book to output file");
            System.out.println("4. Remove book from output file");
            System.out.println("5. Find book by title");
            System.out.println("6. Find book by ISBN");
            System.out.println("7. Sort books by title");
            System.out.println("8. Exit");

            switch (scanner.nextInt()) {
                case 1:
                    books = repository.getAll();
                    break;
                case 2:
                    booksView.printBooks(books);
                    break;
                case 3:
                    book = booksView.addBook();
                    repository.save(book);
                    break;
                case 4:
                    book = booksView.addBook();
                    repository.delete(book);
                case 5:
                    System.out.print("\nEnter title: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    books = repository.findByTitle(title);
                    repository.saveAll(books);
                    break;
                case 6:
                    System.out.print("\nEnter ISBN: ");
                    books = repository.findByISBN(scanner.nextLong());
                    repository.saveAll(books);
                    break;
                case 7:
                    books = repository.getSortedByTitle();
                    repository.saveAll(books);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Wrong command");
                    break;
            }
        }
    }
}
