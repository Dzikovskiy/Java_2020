package by.training.task9.service;

import by.training.task9.entity.CompoundCharacter;

import java.util.ArrayList;
import java.util.List;

public class CharacterParser extends TextParser<String> {
    private final String regex = "(?!^)";

    @Override
    public ArrayList<CompoundCharacter> parse(CompoundCharacter characters) {
        List<CompoundCharacter> paragraphList = new ArrayList<>();
        String[] chars = characters.getCharacters().split(regex);

        for (String paragraph : chars) {
            CompoundCharacter compoundCharacter = new CompoundCharacter();
            compoundCharacter.setCharacters(paragraph);
            paragraphList.add(compoundCharacter);
        }
        return (ArrayList<CompoundCharacter>) paragraphList;
    }
}
