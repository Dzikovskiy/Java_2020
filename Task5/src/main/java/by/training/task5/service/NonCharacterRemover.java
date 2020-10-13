package by.training.task5.service;

public class NonCharacterRemover {

    public String removeNonCharacters(String string){
        return string.replaceAll("[^\\pL ]"," ").replaceAll("\\s{2,}"," ");
    }
}
