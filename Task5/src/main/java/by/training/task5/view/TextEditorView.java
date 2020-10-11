package by.training.task5.view;

import by.training.task5.service.CharacterAfterCharacterChangerCommand;
import by.training.task5.service.CharacterOnIndexChangerCommand;

import java.util.Scanner;

public class TextEditorView {

    Scanner scanner = new Scanner(System.in);

    /**
     * Method for changing for replacing character on the entered index with
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

    public String replaceCharacterAfterCharacterView(CharacterAfterCharacterChangerCommand command, String string) {
        String result = command.replaceCharacterAfterCharacterInEachWord(string);
        System.out.println(result);
        return result;
    }
}
