package by.training.task2_4.runner;

import by.training.task2_4.view.MenuView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger();
        logger.info("Program start");
        MenuView menuView = new MenuView();
        menuView.menu();
    }
}
