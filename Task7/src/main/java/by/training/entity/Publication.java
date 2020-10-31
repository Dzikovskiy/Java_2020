package by.training.entity;

import java.util.ArrayList;
import java.util.List;

public class Publication {
    private long isbnNumber;// like id for every book
    private String title;
    private int numberOfPages;
    private String publishingHouse;
    private int yearOfPublishing;
    private List<Author> authors;
    private PublicationType type;

    public Publication(PublicationType type) {
        this.authors = new ArrayList<>();
        this.type = type;
    }

    public void addAuthor(Author author) {
        if (author != null) {
            this.authors.add(author);
        }
    }

    public long getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(long isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publication publication = (Publication) o;

        if (isbnNumber != publication.isbnNumber) return false;
        if (numberOfPages != publication.numberOfPages) return false;
        if (yearOfPublishing != publication.yearOfPublishing) return false;
        if (!title.equals(publication.title)) return false;
        if (!authors.equals(publication.authors)) return false;
        return publishingHouse.equals(publication.publishingHouse);
    }

    @Override
    public int hashCode() {
        int result = (int) (isbnNumber ^ (isbnNumber >>> 32));
        result = 31 * result + title.hashCode();
        result = 31 * result + authors.hashCode();
        result = 31 * result + numberOfPages;
        result = 31 * result + publishingHouse.hashCode();
        result = 31 * result + yearOfPublishing;
        return result;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "isbnNumber=" + isbnNumber +
                ", title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                ", authors=" + authors +
                '}';
    }
}
