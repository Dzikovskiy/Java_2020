package by.training.task9.service;

import by.training.task9.entity.CompoundCharacter;

import java.util.ArrayList;
import java.util.List;

public class ParagraphParser extends TextParser<String> {
    private final String regex = "\\t| {4}";
    

    @Override
    public ArrayList<CompoundCharacter> parse(CompoundCharacter characters) {
        List<CompoundCharacter> paragraphList = new ArrayList<>();
        String[] paragraphs = characters.getCharacters().split(regex);

        for (int i = 1; i < paragraphs.length; i++) {//index from 1 because first paragraph before first tab is empty
            String paragraph = paragraphs[i];
            CompoundCharacter compoundCharacter = new CompoundCharacter();
            compoundCharacter.setCharacters(paragraph);
            paragraphList.add(compoundCharacter);
        }
        return (ArrayList<CompoundCharacter>) paragraphList;
    }
}
