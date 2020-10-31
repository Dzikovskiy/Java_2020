package by.training.service;

import by.training.entity.Author;
import by.training.entity.Publication;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CSVWriter {
    String csvFileName = "output.csv";
    String csvSplitBy = ",";
    String authorSplitBy = "|";

    public void writePublicationListToFile(ArrayList<Publication> publications) {

        try (FileOutputStream outputStream = new FileOutputStream(csvFileName)) {
            StringBuilder builder = new StringBuilder();

            for (Publication publication : publications) {
                builder.append(publication.getType()).append(csvSplitBy).append(publication.getIsbnNumber()).append(csvSplitBy)
                        .append(publication.getTitle()).append(csvSplitBy)
                        .append(publication.getNumberOfPages()).append(csvSplitBy).append(publication.getPublishingHouse())
                        .append(csvSplitBy).append(publication.getYearOfPublishing()).append(csvSplitBy)
                        .append(publication.getAuthors().stream().map(Author::getName).collect(Collectors.joining(authorSplitBy)))
                        .append(",\n");

            }

            outputStream.write(builder.toString().getBytes());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
