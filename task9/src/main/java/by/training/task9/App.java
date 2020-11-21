package by.training.task9;

import by.training.task9.entity.CompoundCharacter;
import by.training.task9.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;

public class App {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger();
        logger.info("Program start");

        TextParser<String> parser = new ParagraphParser();
        TextParser<String> senParser = new SentenceParser();
        TextParser<String> lexParser = new LexemeParser();
        TextParser<String> charParser = new CharacterParser();
        parser.setNext(senParser);
        senParser.setNext(lexParser);
        lexParser.setNext(charParser);

        parser.setCompoundCharacterComparator(Comparator.comparing(CompoundCharacter::getCharacters).reversed());


        CompoundCharacter compoundCharacter = new CompoundCharacter();
        compoundCharacter.setCharacters("    It has survived not only five centuries, but also the leap into electronic\n" +
                "typesetting, remaining essentially unchanged? It was popularised in the with the\n" +
                "release of Letraset sheets containing Lorem Ipsum passages, and more recently with\n" +
                "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "\tIt is a established fact that a reader will be of a page when looking at its\n" +
                "layout.\n" +
                "\tBye.\n" +
                "    It is a long established fact that a reader will be distracted by the readable\n" +
                "content of a page when looking at its layout. The point of using Ipsum is that it has a\n" +
                "more-or-less normal distribution of letters, as opposed to using 'Content here, content\n" +
                "here', making it look like readable English.\n");
        ArrayList<CompoundCharacter> list = parser.parseManager(compoundCharacter);

        for (CompoundCharacter character : list) {
            System.out.print(character.getChildCharacters()
                    .replaceAll("[ ]{2,}", "^")
                    .replace(" ", "")
                    .replace("^", " "));
        }

    }
}
