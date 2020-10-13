package by.training.task5.service;

public class WordsStartedWithConsonantRemoverByLength {

    public String removeWords(String string,int length){
        return string.replaceAll("(?i)\\b[^aeiou][^\\s]{" + length + "}(?=(\\s|$))", "\b");
    }
}
