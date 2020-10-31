package by.training.specification;

import by.training.entity.Publication;

import java.util.Comparator;

public class SortByTitle extends PublicationSpecification {
    public SortByTitle() {
        super(null, Comparator.comparing(Publication::getTitle));
    }
}
