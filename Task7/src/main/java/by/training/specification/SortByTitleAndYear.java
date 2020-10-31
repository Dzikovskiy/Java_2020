package by.training.specification;

import by.training.entity.Publication;

import java.util.Comparator;

public class SortByTitleAndYear extends PublicationSpecification {
    public SortByTitleAndYear() {
        super(null, Comparator.comparing(Publication::getTitle).thenComparingInt(Publication::getYearOfPublishing));
    }
}
