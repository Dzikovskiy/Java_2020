package by.training.task5.service;

public class CharacterService {
    public String replaceCharacterInEachWord(String string, char c, int index) {
       return string.replaceAll(String.format("(\\b\\p{L}{%d})\\p{L}", index - 1), "$1" + c);
    }
}
