package by.training.repository;

import by.training.dao.BookListDao;
import by.training.entity.Book;
import by.training.specification.FindBookByISBN;
import by.training.specification.FindBookByTitle;
import by.training.specification.SortByTitle;

import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IRepository<Book> {

    BookListDao bookListDao = new BookListDao();

    @Override
    public ArrayList<Book> getAll() {
        return bookListDao.getAll();
    }

    @Override
    public void save(Book book) {
        bookListDao.addBook(book);
    }

    @Override
    public void delete(Book book) {
        bookListDao.removeBook(book);
    }

    public ArrayList<Book> findByTitle(String title) {
        return bookListDao.getBySpecification(new FindBookByTitle(title));
    }

    public ArrayList<Book> findByISBN(long ISBN) {
        return bookListDao.getBySpecification(new FindBookByISBN(ISBN));
    }

    public ArrayList<Book> getSortedByTitle() {
        return bookListDao.getBySpecification(new SortByTitle());
    }


}
