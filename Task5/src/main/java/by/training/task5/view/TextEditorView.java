package by.training.task5.view;

import by.training.task5.service.CharacterService;

import java.util.Scanner;

public class TextEditorView {
    CharacterService characterService = new CharacterService();
    Scanner scanner = new Scanner(System.in);

    public void replaceCharacterInEachWordView(String string) {
        int index;
        char symbol;
        System.out.println("Enter index of character to change: ");
        index = scanner.nextInt();
        System.out.println("Enter character: ");
        symbol = scanner.next().charAt(0);
        System.out.println(characterService.replaceCharacterInEachWord(string, symbol, index));
    }

    public String createStringFormConsole() {
        System.out.println("Enter string of words: ");
        return scanner.nextLine();
    }
}
