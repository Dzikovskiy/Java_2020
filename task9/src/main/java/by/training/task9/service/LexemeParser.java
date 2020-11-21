package by.training.task9.service;

import by.training.task9.entity.CompoundCharacter;

import java.util.ArrayList;
import java.util.List;

public class LexemeParser extends TextParser<String>{
    private final String regex = "\\s";

    @Override
    public ArrayList<CompoundCharacter> parse(CompoundCharacter characters) {
        List<CompoundCharacter> paragraphList = new ArrayList<>();
        String[] words = characters.getCharacters().split(regex);

        for (String paragraph : words) {
            CompoundCharacter compoundCharacter = new CompoundCharacter();
            compoundCharacter.setCharacters(paragraph);
            paragraphList.add(compoundCharacter);
        }
        return (ArrayList<CompoundCharacter>) paragraphList;
    }
}
