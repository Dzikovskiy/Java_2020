package by.training.task4.controller;

import by.training.task4.view.MenuView;

import java.io.IOException;

public class MainController {
    public static void main(String[] args) throws IOException {

        MenuView menuView = new MenuView();
        menuView.menu();
    }
}
