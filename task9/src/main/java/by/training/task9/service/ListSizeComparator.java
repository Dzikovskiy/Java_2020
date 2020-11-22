package by.training.task9.service;

import by.training.task9.entity.CompoundCharacter;

import java.util.Comparator;

public class ListSizeComparator implements Comparator<CompoundCharacter> {
    @Override
    public int compare(CompoundCharacter a, CompoundCharacter b) {
        return b.getCharacterList().size() - a.getCharacterList().size();
    }
}