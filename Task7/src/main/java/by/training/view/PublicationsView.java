package by.training.view;

import by.training.entity.Author;
import by.training.entity.Publication;

import java.util.ArrayList;
import java.util.Scanner;

public class PublicationsView {
    Scanner scanner = new Scanner(System.in);

    public void printBooks(ArrayList<Publication> publications) {
        if (publications != null) {
            publications.forEach(System.out::println);
        }
    }

    public Publication addBook() {
        Publication publication = new Publication();
        Author author;

        System.out.print("\nEnter isbn: ");
        publication.setIsbnNumber(Long.parseLong(scanner.nextLine()));
        System.out.println("Enter title: ");
        publication.setTitle(scanner.nextLine());
        System.out.println("Enter number of pages");
        publication.setNumberOfPages(scanner.nextInt());
        scanner.nextLine();// next line after int
        System.out.println("Enter publisher:");
        publication.setPublishingHouse(scanner.nextLine());
        System.out.println("Enter year: ");
        publication.setYearOfPublishing(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter authors divided by ,");
        String[] authors = scanner.nextLine().split(",");
        for (String s : authors) {
            author = new Author();

            author.setName(s);
            publication.addAuthor(author);
        }

        return publication;
    }
}
