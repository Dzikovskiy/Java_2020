package by.training.specification;

import java.util.Comparator;
import java.util.function.Predicate;

public interface ISpecification<T> {
    Predicate<T> getFilter();

    Comparator<T> getSorted();
}
