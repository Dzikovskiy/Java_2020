package by.training;

import by.training.entity.Author;
import by.training.entity.Book;
import by.training.repository.BookRepository;
import by.training.view.MenuView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MenuView view = new MenuView();
        view.menu();
    }
}
