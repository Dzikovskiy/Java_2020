package by.training.service;

import by.training.entity.Author;
import by.training.entity.Publication;
import by.training.entity.PublicationType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    String line = "";
    String csvSplitBy = ",";
    String authorSplitBy = "\\|";
    private BookFactory bookFactory = BookFactory.getInstance();
    private MagazineFactory magazineFactory = MagazineFactory.getInstance();
    private NewspaperFactory newspaperFactory = NewspaperFactory.getInstance();
    Logger logger = LogManager.getLogger();

    /**
     * Method for parsing csv file into ArrayList<Publication>
     *
     * @param csvFileName given csv file name
     * @return ArrayList of Books
     */
    public ArrayList<Publication> readBooksFormCSVFile(String csvFileName) {
        CSVReader app = new CSVReader();
        InputStream is = app.getFileFromResourceAsStream(csvFileName);
        List<Publication> publicationsList = new ArrayList<>();
        Publication publication;
        Author author;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                logger.debug("Line from file: " + line);

                // use comma as separator
                String[] booksStringFromFile = line.split(csvSplitBy);
                String[] authorsString = booksStringFromFile[6].split(authorSplitBy);
                try {
                    PublicationType.valueOf(booksStringFromFile[0]);//if type not found it won't create publication bellow

                    publication = new Publication(PublicationType.BOOK);//default type

                    if (booksStringFromFile[0].equals("BOOK")) {
                        publication = bookFactory.createPublication();
                    } else if (booksStringFromFile[0].equals("MAGAZINE")) {
                        publication = magazineFactory.createPublication();
                    } else if (booksStringFromFile[0].equals("NEWSPAPER")) {
                        publication = newspaperFactory.createPublication();
                    }

                    publication.setIsbnNumber(Long.parseLong(booksStringFromFile[1]));
                    publication.setTitle(booksStringFromFile[2]);
                    publication.setNumberOfPages(Integer.parseInt(booksStringFromFile[3]));
                    publication.setPublishingHouse(booksStringFromFile[4]);
                    publication.setYearOfPublishing(Integer.parseInt(booksStringFromFile[5]));

                    for (int i = 0; i < authorsString.length; i++) {
                        author = new Author();

                        author.setName(authorsString[i]);
                        publication.addAuthor(author);
                    }

                    publicationsList.add(publication);

                    logger.debug("Publication added to list: " + publication.toString());
                } catch (IllegalArgumentException ex) {
                    //nope
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (ArrayList<Publication>) publicationsList;
    }

    /**
     * Method for getting a file from the resources folder
     *
     * @param fileName given file name
     * @return InputStream of file
     */
    private InputStream getFileFromResourceAsStream(String fileName) {
        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // The stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }
}
