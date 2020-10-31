package by.training.service;

import by.training.entity.Publication;
import by.training.entity.PublicationType;

public class BookFactory extends PublicationFactory {

    private static BookFactory bookFactory;

    private BookFactory() {
    }

    public static BookFactory getInstance() {
        if (bookFactory == null) {
            bookFactory = new BookFactory();
        }
        return bookFactory;
    }

    @Override
    public Publication createPublication() {
        return new Publication(PublicationType.BOOK);
    }



}
