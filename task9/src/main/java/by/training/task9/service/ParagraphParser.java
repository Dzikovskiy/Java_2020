package by.training.task9.service;

import by.training.task9.entity.CompoundCharacter;

import java.util.ArrayList;
import java.util.List;

public class ParagraphParser extends TextParser<String> {

    @Override
    public ArrayList<CompoundCharacter> parse(CompoundCharacter characters) {
        List<CompoundCharacter> paragraphList = new ArrayList<>();
        String[] paragraphs = characters.getCharacters().split("\\t| {4}");

        for (int i = 1; i < paragraphs.length; i++) {
            String paragraph = paragraphs[i];
            CompoundCharacter compoundCharacter = new CompoundCharacter();
            compoundCharacter.setCharacters(paragraph);
            paragraphList.add(compoundCharacter);
        }
        return (ArrayList<CompoundCharacter>) paragraphList;
    }
}
