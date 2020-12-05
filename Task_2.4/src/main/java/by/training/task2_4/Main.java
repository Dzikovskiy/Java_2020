package by.training.task2_4;

import by.training.task2_4.view.MenuView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger logger = LogManager.getLogger();
        logger.info("Program start");
        MenuView menuView = new MenuView();
        menuView.menu();
    }
}
