package by.training.dao;

import by.training.entity.Publication;
import by.training.service.CSVReader;
import by.training.service.CSVWriter;
import by.training.specification.ISpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookListDao {
    CSVWriter writer = new CSVWriter();
    private ArrayList<Publication> publications;
    Logger logger = LogManager.getLogger();

    public BookListDao() {
        this.publications = new ArrayList<>();
        getAll();
    }

    public void saveAll(ArrayList<Publication> publications) {
        if (publications != null) {
            CSVWriter writer = new CSVWriter();
            writer.writePublicationListToFile(publications);
        }
    }

    public ArrayList<Publication> getAll() {
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

        publications = reader.readBooksFormCSVFile(csvFileName);

        return publications;
    }

    public void addBook(Publication publication) {
        if (publications.contains(publication)) {
            throw new IllegalArgumentException("That publication is already in the storage");
        } else {
            publications.add(publication);
            writer.writePublicationListToFile(publications);

            logger.debug("Publication wrote to file: " + publication);
        }
    }

    public void removeBook(long IsbnNumber) {
        if (publications.removeIf(p-> (p.getIsbnNumber()==IsbnNumber))) {
            writer.writePublicationListToFile(publications);

            logger.debug("Publication removed by isbn: " + IsbnNumber);
        } else {
            throw new NoSuchElementException("That publication is not in the storage");
        }
    }

    public ArrayList<Publication> getBySpecification(ISpecification<Publication> specification) {
        Stream<Publication> result = publications.stream();
        logger.debug("Specification called: " + specification.getClass());

        if (specification.getFilter() != null) {
            result = publications.stream().filter(specification.getFilter());
        }
        if (specification.getSorted() != null) {
            result = publications.stream().sorted(specification.getSorted());
        }
        return (ArrayList<Publication>) result.collect(Collectors.toList());
    }

}
