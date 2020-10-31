package by.training.service;

import by.training.entity.Publication;
import by.training.entity.PublicationType;

public class MagazineFactory extends PublicationFactory {

    private static MagazineFactory magazineFactory;

    private MagazineFactory() {
    }

    public static MagazineFactory getInstance() {
        if (magazineFactory == null) {
            magazineFactory = new MagazineFactory();
        }
        return magazineFactory;
    }

    @Override
    public Publication createPublication() {
        return new Publication(PublicationType.MAGAZINE);
    }

}