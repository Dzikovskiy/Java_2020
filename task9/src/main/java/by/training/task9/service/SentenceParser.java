package by.training.task9.service;

import by.training.task9.entity.CompoundCharacter;

import java.util.ArrayList;
import java.util.List;

public class SentenceParser extends TextParser<String> {
    private final String regex = "(?<!\\w\\.\\w.)(?<![A-Z][a-z]\\.)(?<=\\.|\\?|\\!)\\s";

    @Override
    public ArrayList<CompoundCharacter> parse(CompoundCharacter characters) {
        List<CompoundCharacter> paragraphList = new ArrayList<>();
        String[] sentences = characters.getCharacters().split(regex);

        for (String paragraph : sentences) {
            CompoundCharacter compoundCharacter = new CompoundCharacter();
            compoundCharacter.setCharacters(paragraph);
            paragraphList.add(compoundCharacter);
        }
        return (ArrayList<CompoundCharacter>) paragraphList;
    }
}
