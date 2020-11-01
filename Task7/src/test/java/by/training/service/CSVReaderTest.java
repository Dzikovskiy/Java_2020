package by.training.service;

import by.training.dao.BookListDao;
import by.training.entity.Author;
import by.training.entity.Publication;
import by.training.entity.PublicationType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class CSVReaderTest {
    CSVReader reader = new CSVReader();
    ArrayList<Publication> publications;

    @Test
    public void testReadBooksFormCSVFile() {
        String csvFileName = "publicationsTest.csv";

        try (InputStream input = BookListDao.class.getClassLoader().getResourceAsStream("configTest.properties")) {
            Properties prop = new Properties();
            //load a properties file from class path
            prop.load(input);
            csvFileName = prop.getProperty("csvFileName");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Publication publication = new Publication(PublicationType.BOOK);
        publication.setIsbnNumber(123123123123L);
        publication.setTitle("AHobbit");
        publication.setNumberOfPages(1263);
        publication.setPublishingHouse("Popury");
        publication.setYearOfPublishing(1976);
        Author author = new Author();
        author.setName("Tolkin");
        publication.addAuthor(author);
        author = new Author();
        author.setName("jr Tolkin");
        publication.addAuthor(author);
        
        publications = reader.readBooksFormCSVFile(csvFileName);

        Assert.assertEquals(publication, publications.get(0));
        Assert.assertEquals(3, publications.size());

    }
}