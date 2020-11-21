package by.training.task9.entity;

public class BaseCharacter {
    private String characters;

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "BaseCharacter{" +
                "characters='" + characters + '\'' +
                '}';
    }
}
