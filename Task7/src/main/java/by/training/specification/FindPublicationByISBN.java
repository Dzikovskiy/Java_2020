package by.training.specification;

public class FindPublicationByISBN extends PublicationSpecification {
    public FindPublicationByISBN(long ISBN) {
        super(x -> x.getIsbnNumber() == ISBN, null);
    }
}
