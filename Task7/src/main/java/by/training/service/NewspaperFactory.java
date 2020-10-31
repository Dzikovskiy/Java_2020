package by.training.service;

import by.training.entity.Publication;
import by.training.entity.PublicationType;

public class NewspaperFactory extends PublicationFactory {

    private static NewspaperFactory newspaperFactory;

    private NewspaperFactory() {
    }

    public static NewspaperFactory getInstance() {
        if (newspaperFactory == null) {
            newspaperFactory = new NewspaperFactory();
        }
        return newspaperFactory;
    }

    @Override
    public Publication createPublication() {
        return new Publication(PublicationType.NEWSPAPER);
    }

}