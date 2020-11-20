package by.training.task9.entity;

import java.util.ArrayList;
import java.util.List;

public class CompoundCharacter extends BaseCharacter{
    private List<CompoundCharacter> characterList = new ArrayList<>();

    public List<CompoundCharacter> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<CompoundCharacter> characterList) {
        this.characterList = characterList;
    }

    @Override
    public String toString() {
        return "CompoundCharacter{" +
                "characterList=" + characterList +
                '}';
    }
}
