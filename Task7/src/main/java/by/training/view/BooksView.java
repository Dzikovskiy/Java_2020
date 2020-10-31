package by.training.view;

import by.training.entity.Author;
import by.training.entity.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class BooksView {
    Scanner scanner = new Scanner(System.in);

    public void printBooks(ArrayList<Book> books) {
        if (books != null) {
            books.forEach(System.out::println);
        }
    }

    public Book addBook() {
        Book book = new Book();
        Author author;

        System.out.print("\nEnter isbn: ");
        book.setIsbnNumber(Long.parseLong(scanner.nextLine()));
        System.out.println("Enter title: ");
        book.setTitle(scanner.nextLine());
        System.out.println("Enter number of pages");
        book.setNumberOfPages(scanner.nextInt());
        scanner.nextLine();// next line after int
        System.out.println("Enter publisher:");
        book.setPublishingHouse(scanner.nextLine());
        System.out.println("Enter year: ");
        book.setYearOfPublishing(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter authors divided by ,");
        String[] authors = scanner.nextLine().split(",");
        for (String s : authors) {
            author = new Author();

            author.setName(s);
            book.addAuthor(author);
        }

        return book;
    }
}
