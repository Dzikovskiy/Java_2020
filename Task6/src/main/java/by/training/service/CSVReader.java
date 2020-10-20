package by.training.service;

import by.training.entity.Author;
import by.training.entity.Book;

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

    /**
     * Method for parsing csv file into ArrayList<Book>
     *
     * @param csvFileName given csv file name
     * @return ArrayList of Books
     */
    public ArrayList<Book> readCSVFormFile(String csvFileName) {
        CSVReader app = new CSVReader();
        InputStream is = app.getFileFromResourceAsStream(csvFileName);
        List<Book> booksList = new ArrayList<>();
        Book book;
        Author author;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                book = new Book();

                // use comma as separator
                String[] booksStringFromFile = line.split(csvSplitBy);
                String[] authorsString = booksStringFromFile[5].split(authorSplitBy);

                book.setIsbnNumber(Long.parseLong(booksStringFromFile[0]));
                book.setTitle(booksStringFromFile[1]);
                book.setNumberOfPages(Integer.parseInt(booksStringFromFile[2]));
                book.setPublishingHouse(booksStringFromFile[3]);
                book.setYearOfPublishing(Integer.parseInt(booksStringFromFile[4]));

                for (int i = 0; i < authorsString.length; i++) {
                    author = new Author();

                    author.setName(authorsString[i]);
                    book.addAuthor(author);
                }

                booksList.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (ArrayList<Book>) booksList;
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
