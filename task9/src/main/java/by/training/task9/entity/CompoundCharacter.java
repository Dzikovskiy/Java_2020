package by.training.task9.entity;

import java.util.ArrayList;
import java.util.List;

public class CompoundCharacter extends BaseCharacter {
    private List<CompoundCharacter> characterList = new ArrayList<>();

    public List<CompoundCharacter> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<CompoundCharacter> characterList) {
        this.characterList = characterList;
    }

    @Override
    public String toString() {
        return characterList.size() > 0 ? getChildCharacters() : getCharacters();

    }

    public String getChildCharacters() {
        StringBuilder builder = new StringBuilder();
        if (characterList.size() > 0) {
            for (CompoundCharacter compoundCharacter : characterList) {
                builder.append(compoundCharacter.getChildCharacters()).append(" ");
            }

            return builder.toString();
        } else {
            return getCharacters();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompoundCharacter)) return false;

        CompoundCharacter that = (CompoundCharacter) o;

        return characterList.equals(that.characterList);
    }

    @Override
    public int hashCode() {
        return characterList.hashCode();
    }
}
