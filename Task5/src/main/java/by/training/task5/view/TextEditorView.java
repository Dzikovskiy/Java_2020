package by.training.task5.view;

import by.training.task5.service.CharacterAfterCharacterChangerCommand;
import by.training.task5.service.CharacterOnIndexChangerCommand;
import by.training.task5.service.SubstringByLengthChanger;

import java.util.Scanner;

public class TextEditorView {

    Scanner scanner = new Scanner(System.in);

    /**
     * Method for printing and changing for replacing character on the entered index with
     * the entered from console given char in every word
     *
     * @param string to change
     */
    public void replaceCharacterInEachWordView(CharacterOnIndexChangerCommand command, String string) {
        int index;
        char symbol;
        System.out.println("Enter index of character to change: ");
        index = scanner.nextInt();
        System.out.println("Enter character: ");
        symbol = scanner.next().charAt(0);
        System.out.println(command.replaceCharacterInEachWord(string, symbol, index));
    }

    /**
     * Method for reading string from console
     *
     * @return string from console
     */
    public String createStringFormConsole() {
        System.out.println("Enter string of words: ");
        return scanner.nextLine();
    }

    /**
     * Method for printing replacing character after character
     *
     * @param command given command
     * @param string  given string
     * @return result string
     */
    public String replaceCharacterAfterCharacterView(CharacterAfterCharacterChangerCommand command, String string) {
        String result = command.replaceCharacterAfterCharacterInEachWord(string);
        System.out.println(result);
        return result;
    }

    /**
     * Method for printing string with replaced words with given length
     *
     * @param string given string
     */
    public void replaceWordsByLengthWithSubstring(String string) {
        SubstringByLengthChanger substringByLengthChanger = new SubstringByLengthChanger();
        int length;
        String substring;

        System.out.println("Enter length of words to replace: ");
        length = scanner.nextInt();
        scanner.nextLine();// takes \n
        System.out.println("Enter substring: ");
        substring = scanner.nextLine();

        System.out.println(substringByLengthChanger.changeSubstringByLength(string, substring, length));

    }
}
