package by.training.dao;

import by.training.entity.Book;
import by.training.service.CSVReader;
import by.training.specification.ISpecification;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookListDao {
    private ArrayList<Book> books;

    public BookListDao() {
        this.books = new ArrayList<>();
        getAll();
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

        books = reader.readCSVFormFile(csvFileName);

        return books;
    }

    public void addBook(Book book) {

    }

    public void removeBook(Book book) {

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
