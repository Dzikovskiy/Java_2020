package by.training.specification;

import by.training.entity.Book;

import java.util.Comparator;

public class SortByTitle extends BookSpecification {
    public SortByTitle() {
        super(null, Comparator.comparing(Book::getTitle));
    }
}
