package by.training.view;

import by.training.entity.Publication;
import by.training.entity.PublicationType;
import by.training.repository.PublicationRepository;
import by.training.service.PublicationsListener;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuView {
    Scanner scanner = new Scanner(System.in);
    PublicationsView publicationsView = new PublicationsView();
    PublicationRepository repository = new PublicationRepository();
    ArrayList<Publication> publications;
    Publication publication;
    PublicationType type;
    int year;

    public void menu() {
        while (true) {
            System.out.println("1. Get all publications from file to array");
            System.out.println("2. Print publications");
            System.out.println("3. Add publication to output file");
            System.out.println("4. Remove publication from output file");
            System.out.println("5. Find publication by title");
            System.out.println("6. Find publication by ISBN");
            System.out.println("7. Sort publications by title");
            System.out.println("8. Sort publications by title and year");
            System.out.println("9. Add observer");
            System.out.println("10. Exit");

            switch (scanner.nextInt()) {
                case 1:
                    publications = repository.getAll();
                    break;
                case 2:
                    publicationsView.printBooks(publications);
                    break;
                case 3:
                    publication = publicationsView.addBook();
                    repository.save(publication);
                    break;
                case 4:
                    System.out.print("\nEnter isbn: ");
                    long isbn = scanner.nextLong();
                    System.out.println("Type: ");
                    scanner.nextLine();
                    type = PublicationType.valueOf(scanner.nextLine());
                    System.out.println("Year: ");
                    year = scanner.nextInt();
                    publication = new Publication(type);
                    publication.setIsbnNumber(isbn);
                    publication.setYearOfPublishing(year);
                    repository.delete(publication);
                    break;
                case 5:
                    System.out.print("\nEnter title: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    publications = repository.findByTitle(title);
                    repository.saveAll(publications);
                    break;
                case 6:
                    System.out.print("\nEnter ISBN: ");
                    publications = repository.findByISBN(scanner.nextLong());
                    repository.saveAll(publications);
                    break;
                case 7:
                    publications = repository.getSortedByTitle();
                    repository.saveAll(publications);
                    break;

                case 8:
                    publications = repository.getSortedByTitleAndYear();
                    repository.saveAll(publications);
                    break;
                case 9:
                    scanner.nextLine();
                    System.out.print("\nEnter type:");
                    type = PublicationType.valueOf(scanner.nextLine());
                    System.out.print("\nEnter year: ");
                    year = scanner.nextInt();
                    PublicationsListener listener = new PublicationsListener(year, type);
                    repository.addListener(listener);
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Wrong command");
                    break;
            }
        }
    }
}
