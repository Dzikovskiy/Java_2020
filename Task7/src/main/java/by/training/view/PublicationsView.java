package by.training.view;

import by.training.entity.Author;
import by.training.entity.Publication;
import by.training.entity.PublicationType;
import by.training.service.BookFactory;
import by.training.service.MagazineFactory;
import by.training.service.NewspaperFactory;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class PublicationsView {
    Scanner scanner = new Scanner(System.in);
    private BookFactory bookFactory = BookFactory.getInstance();
    private MagazineFactory magazineFactory = MagazineFactory.getInstance();
    private NewspaperFactory newspaperFactory = NewspaperFactory.getInstance();


    public void printBooks(ArrayList<Publication> publications) {
        if (publications != null) {
            publications.forEach(System.out::println);
        }
    }

    public Publication addBook() {
        Author author;
        Optional<Publication> publication = Optional.empty();

        System.out.println("\nEnter type");
        PublicationType type = PublicationType.valueOf(scanner.nextLine());
        if (type == PublicationType.BOOK) {
           publication = publication.of(bookFactory.createPublication());
        } else if (type == PublicationType.MAGAZINE) {
            publication = publication.of(magazineFactory.createPublication());
        } else if (type == PublicationType.NEWSPAPER) {
            publication = publication.of(newspaperFactory.createPublication());
        }

        if (publication.isPresent()) {
            System.out.println("Enter title: ");
            publication.get().setTitle(scanner.nextLine());
            System.out.println("Enter number of pages");
            publication.get().setNumberOfPages(scanner.nextInt());
            scanner.nextLine();// next line after int
            System.out.println("Enter publisher:");
            publication.get().setPublishingHouse(scanner.nextLine());
            System.out.println("Enter year: ");
            publication.get().setYearOfPublishing(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Enter authors divided by ,");
            String[] authors = scanner.nextLine().split(",");
            for (String s : authors) {
                author = new Author();

                author.setName(s);
                publication.get().addAuthor(author);
            }
        } else {
            throw new IllegalArgumentException("Wrong input");
        }

        return publication.get();
    }
}
