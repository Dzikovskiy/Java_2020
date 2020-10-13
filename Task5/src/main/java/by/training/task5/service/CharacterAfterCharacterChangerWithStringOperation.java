package by.training.task5.service;

public class CharacterAfterCharacterChangerWithStringOperation extends Command {
    String text;

    public CharacterAfterCharacterChangerWithStringOperation(String text) {
        this.text = text;
    }

    /**
     * Method for replacing all russian "ра" to "ро"
     *
     * @return resulted string
     */
    @Override
    public String execute() {
        return text.replaceAll("ра", "ро");
    }

}
