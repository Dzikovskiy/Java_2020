package by.training.task5.service;

public class CharacterAfterCharacterChangerWithStringOperation extends CharacterAfterCharacterChangerCommand {
    /**
     * Method for replacing all russian "ра" to "ро"
     *
     * @param string given string
     * @return resulted string
     */
    @Override
    public String replaceCharacterAfterCharacterInEachWord(String string) {
        return string.replaceAll("ра", "ро");
    }
}
