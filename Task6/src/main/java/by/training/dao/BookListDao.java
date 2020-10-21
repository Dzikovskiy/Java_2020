package by.training.dao;

import by.training.entity.Book;
import by.training.service.CSVReader;
import by.training.service.CSVWriter;
import by.training.specification.ISpecification;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookListDao {
    CSVWriter writer = new CSVWriter();
    private ArrayList<Book> books;

    public BookListDao() {
        this.books = new ArrayList<>();
        getAll();
    }

    public void saveAll(ArrayList<Book> books) {
        if (books != null) {
            CSVWriter writer = new CSVWriter();
            writer.writeBookListToFile(books);
        }
    }

    public ArrayList<Book> getAll() {
        CSVReader reader = new CSVReader();
        String csvFileName = "inputCSV.csv";

        try (InputStream input = BookListDao.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            //load a properties file from class path
            prop.load(input);
            csvFileName = prop.getProperty("csvFileName");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        books = reader.readBooksFormCSVFile(csvFileName);

        return books;
    }

    public void addBook(Book book) {
        if (books.contains(book)) {
            throw new IllegalArgumentException("That book is already in the storage");
        } else {
            books.add(book);
            writer.writeBookListToFile(books);
        }
    }

    public void removeBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
            writer.writeBookListToFile(books);
        } else {
            throw new NoSuchElementException("That book is not in the storage");
        }
    }

    public ArrayList<Book> getBySpecification(ISpecification<Book> specification) {
        Stream<Book> result = books.stream();

        if (specification.getFilter() != null) {
            result = books.stream().filter(specification.getFilter());
        }
        if (specification.getSorted() != null) {
            result = books.stream().sorted(specification.getSorted());
        }
        return (ArrayList<Book>) result.collect(Collectors.toList());
    }

}
