package by.training.task9.service;

import by.training.task9.entity.CompoundCharacter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public abstract class TextParser<T> {
    private Comparator<CompoundCharacter> compoundCharacterComparator;
    private TextParser<T> nextTextParser;

    public void setNext(TextParser<T> parser) {
        this.nextTextParser = parser;
    }

    public ArrayList<CompoundCharacter> parseManager(CompoundCharacter compoundCharacter) {
        ArrayList<CompoundCharacter> list = parse(compoundCharacter);

        if (nextTextParser != null) {
            for (CompoundCharacter character : list) {
                character.setCharacterList(nextTextParser.parseManager(character));
            }
            if (this.compoundCharacterComparator != null) {
                list = sortBySpecification(list);
            }
        }
        return list;
    }

    public abstract ArrayList<CompoundCharacter> parse(CompoundCharacter compoundCharacter);

    private ArrayList<CompoundCharacter> sortBySpecification(ArrayList<CompoundCharacter> list) {
        Stream<CompoundCharacter> result;

        result = list.stream().sorted(this.compoundCharacterComparator);

        return (ArrayList<CompoundCharacter>) result.collect(Collectors.toList());
    }

    public Comparator<CompoundCharacter> getCompoundCharacterComparator() {
        return compoundCharacterComparator;
    }

    public void setCompoundCharacterComparator(Comparator<CompoundCharacter> compoundCharacterComparator) {
        this.compoundCharacterComparator = compoundCharacterComparator;
    }


}
