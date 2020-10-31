package by.training.specification;

import by.training.entity.Book;

import java.util.Comparator;

public class SortByTitleAndYear extends BookSpecification {
    public SortByTitleAndYear() {
        super(null, Comparator.comparing(Book::getTitle).thenComparing(Book::getYearOfPublishing));
    }
}
