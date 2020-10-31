package by.training.specification;

public class FindBookByTitle extends BookSpecification {
    public FindBookByTitle(String title) {
        super(x -> x.getTitle().equals(title), null);
    }
}
