package by.training.task5.view;

import by.training.task5.service.CharacterAfterCharacterChangerWithStringOperation;
import by.training.task5.service.CharacterOnIndexChangerStringBuilderOperation;
import by.training.task5.service.CharacterOnIndexChangerStringOperation;

import java.util.Scanner;

public class MenuView {
    TextEditorView textEditorView = new TextEditorView();
    Scanner scanner = new Scanner(System.in);
    String string = "";

    public void menu() {
        while (true) {
            System.out.println("\n1. Create String from console");
            System.out.println("2. Replace character in each word with String methods");
            System.out.println("3. Replace character in each word with StringBuilder methods");
            System.out.println("4. Replace \"ра\" to \"ро\" in each word with String methods");
            System.out.println("5. Print String");
            System.out.println("6. exit");

            switch (scanner.nextInt()) {
                case 1:
                    string = textEditorView.createStringFormConsole();
                    break;
                case 2:
                    textEditorView.replaceCharacterInEachWordView(new CharacterOnIndexChangerStringOperation(), string);
                    break;
                case 3:
                    textEditorView.replaceCharacterInEachWordView(new CharacterOnIndexChangerStringBuilderOperation(), string);
                    break;
                case 4:
                    string = textEditorView
                            .replaceCharacterAfterCharacterView(new CharacterAfterCharacterChangerWithStringOperation(), string);
                    break;
                case 5:
                    System.out.println(string);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Wrong command !");
                    break;
            }
        }
    }
}
