package by.training.task9;

import by.training.task9.entity.CompoundCharacter;
import by.training.task9.service.ParagraphParser;
import by.training.task9.service.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger();
        logger.info("Program start");

        TextParser<String> parser = new ParagraphParser();


        CompoundCharacter compoundCharacter = new CompoundCharacter();
        compoundCharacter.setCharacters("\tIt has survived not only five centuries, but also the leap into electronic\n" +
                "typesetting, remaining essentially unchanged. It was popularised in the with the\n" +
                "release of Letraset sheets containing Lorem Ipsum passages, and more recently with\n" +
                "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "\tIt is a long established fact that a reader will be distracted by the readable\n" +
                "content of a page when looking at its layout. The point of using Ipsum is that it has a\n" +
                "more-or-less normal distribution of letters, as opposed to using 'Content here, content\n" +
                "here', making it look like readable English.\n" +
                "\tIt is a established fact that a reader will be of a page when looking at its\n" +
                "layout.\n");
        ArrayList<CompoundCharacter> list = parser.parseManager(compoundCharacter);

        System.out.println(list);




    }
}
