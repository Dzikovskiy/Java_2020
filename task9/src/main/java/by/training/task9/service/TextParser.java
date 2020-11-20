package by.training.task9.service;

import by.training.task9.entity.CompoundCharacter;

import java.util.ArrayList;
import java.util.List;

public abstract class TextParser<T> {
    private TextParser<T> nextTextParser;

    public void setNext(TextParser<T> parser) {
        this.nextTextParser = parser;
    }

    public ArrayList<CompoundCharacter> parseManager(CompoundCharacter compoundCharacter) {
        ArrayList<CompoundCharacter> list = parse(compoundCharacter);
        if (nextTextParser != null) {
            for(CompoundCharacter character: list){
                nextTextParser.parseManager(character);
            }
        }
        return list;

    }

    public abstract ArrayList<CompoundCharacter> parse(CompoundCharacter compoundCharacter);

}
