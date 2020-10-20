package by.training.specification;

import by.training.entity.Book;

import java.util.Comparator;
import java.util.function.Predicate;

public class BookSpecification implements ISpecification<Book> {

    Predicate<Book> bookPredicate;
    Comparator<Book> bookComparator;

    public BookSpecification(Predicate<Book> bookPredicate, Comparator<Book> bookComparator) {
        this.bookPredicate = bookPredicate;
        this.bookComparator = bookComparator;
    }

    @Override
    public Predicate<Book> getFilter() {
        return bookPredicate;
    }

    @Override
    public Comparator<Book> getSorted() {
        return bookComparator;
    }


}
