package by.training.specification;

public class FindPublicationByTitle extends PublicationSpecification {
    public FindPublicationByTitle(String title) {
        super(x -> x.getTitle().equals(title), null);
    }
}
