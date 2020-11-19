package by.training.task9;

import by.training.task9.service.ParagraphParser;
import by.training.task9.service.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger();
        logger.info("Program start");

        TextParser<String> parser = new ParagraphParser();
        TextParser<String> parser2 = new ParagraphParser();
        TextParser<String> parser3 = new ParagraphParser();



        parser.writeManager("Hello");
    }
}
