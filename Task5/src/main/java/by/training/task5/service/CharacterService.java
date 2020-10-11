package by.training.task5.service;

public class CharacterService {
    /**
     * Method for replacing character on some index with given char in every word
     *
     * @param string given string of words
     * @param c      char to set
     * @param index  of element to change
     * @return String with changed characters
     */
    public String replaceCharacterInEachWord(String string, char c, int index) {
        return string.replaceAll(String.format("(\\b\\p{L}{%d})\\p{L}", index - 1), "$1" + c);
    }
}
