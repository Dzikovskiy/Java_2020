package by.training.task5.service;

public class SubstringByLengthChanger {
    public String changeSubstringByLength(String stringToChange, String substring, int length) {
        return stringToChange.replaceAll("\\b[a-zA-Z]{" + length + "}\\b", substring);
    }
}
