package by.training.specification;

public class FindBookByISBN extends BookSpecification {
    public FindBookByISBN(long ISBN) {
        super(x -> x.getIsbnNumber() == ISBN, null);
    }
}
