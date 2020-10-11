package by.training.task5.service;

public class CharacterOnIndexChangerStringBuilderOperation extends CharacterOnIndexChangerCommand {
    /**
     * Method for replacing character on some index with given char in every word
     *
     * @param string given string of words
     * @param c      char to set
     * @param index  of element to change
     * @return String with changed characters
     */
    @Override
    public String replaceCharacterInEachWord(String string, char c, int index) {
        StringBuilder sb = new StringBuilder();
        if (string != null && string.length() > 0 && index > 0) {
            for (String word : string.split("[\\s\\.\\!\\,]")) {
                if (word.length() >= index) {
                    sb.append(word, 0, index - 1).append(c).append(word.substring(index));
                } else {
                    sb.append(word);
                }
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}
