package by.training.specification;

import by.training.entity.Publication;

import java.util.Comparator;
import java.util.function.Predicate;

public class PublicationSpecification implements ISpecification<Publication> {

    Predicate<Publication> publicationPredicate;
    Comparator<Publication> publicationComparator;

    public PublicationSpecification(Predicate<Publication> publicationPredicate, Comparator<Publication> publicationComparator) {
        this.publicationPredicate = publicationPredicate;
        this.publicationComparator = publicationComparator;
    }

    @Override
    public Predicate<Publication> getFilter() {
        return publicationPredicate;
    }

    @Override
    public Comparator<Publication> getSorted() {
        return publicationComparator;
    }


}
