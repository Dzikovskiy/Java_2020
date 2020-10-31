package by.training.service;

import by.training.entity.Author;
import by.training.entity.Book;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CSVWriter {
    String csvFileName = "output.csv";
    String csvSplitBy = ",";
    String authorSplitBy = "|";

    public void writeBookListToFile(ArrayList<Book> books) {

        try (FileOutputStream outputStream = new FileOutputStream(csvFileName)) {
            StringBuilder builder = new StringBuilder();

            for (Book book : books) {
                builder.append(book.getIsbnNumber()).append(csvSplitBy).append(book.getTitle()).append(csvSplitBy)
                        .append(book.getNumberOfPages()).append(csvSplitBy).append(book.getPublishingHouse())
                        .append(csvSplitBy).append(book.getYearOfPublishing()).append(csvSplitBy)
                        .append(book.getAuthors().stream().map(Author::getName).collect(Collectors.joining(authorSplitBy)))
                        .append(",\n");

            }

            outputStream.write(builder.toString().getBytes());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
