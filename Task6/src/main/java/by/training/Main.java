package by.training;

import by.training.entity.Book;
import by.training.service.CSVReader;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CSVReader reader = new CSVReader();
        ArrayList<Book> books = reader.readCSVFormFile("books.csv");

        books.forEach(System.out::println);

    }
}
