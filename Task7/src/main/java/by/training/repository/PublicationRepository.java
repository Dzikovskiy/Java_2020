package by.training.repository;

import by.training.dao.BookListDao;
import by.training.entity.Publication;
import by.training.specification.FindPublicationByISBN;
import by.training.specification.FindPublicationByTitle;
import by.training.specification.SortByTitle;
import by.training.specification.SortByTitleAndYear;

import java.util.ArrayList;

public class PublicationRepository implements IRepository<Publication> {

    BookListDao publicationListDao = new BookListDao();

    @Override
    public ArrayList<Publication> getAll() {
        return publicationListDao.getAll();
    }

    @Override
    public void save(Publication publication) {
        publicationListDao.addBook(publication);
    }

    @Override
    public void delete(Publication publication) {
        publicationListDao.removeBook(publication.getIsbnNumber());
    }

    public void saveAll(ArrayList<Publication> publications) {
        publicationListDao.saveAll(publications);
    }

    public ArrayList<Publication> findByTitle(String title) {
        return publicationListDao.getBySpecification(new FindPublicationByTitle(title));
    }

    public ArrayList<Publication> findByISBN(long ISBN) {
        return publicationListDao.getBySpecification(new FindPublicationByISBN(ISBN));
    }

    public ArrayList<Publication> getSortedByTitle() {
        return publicationListDao.getBySpecification(new SortByTitle());
    }


    public ArrayList<Publication> getSortedByTitleAndYear() {
        return publicationListDao.getBySpecification(new SortByTitleAndYear());
    }
}
