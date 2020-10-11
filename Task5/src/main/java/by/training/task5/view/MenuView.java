package by.training.task5.view;

import by.training.task5.service.CharacterStringBuilderOperation;
import by.training.task5.service.CharacterStringOperation;

import java.util.Scanner;

public class MenuView {
    TextEditorView textEditorView = new TextEditorView();
    Scanner scanner = new Scanner(System.in);
    String string = new String("");

    public void menu() {
        while (true) {
            System.out.println("\n1. Create String from console");
            System.out.println("2. Replace character in each word with String methods");
            System.out.println("3. Replace character in each word with StringBuilder methods");
            System.out.println("4. Print String");
            System.out.println("5. Find number index in Array");
            System.out.println("6. exit");

            switch (scanner.nextInt()) {
                case 1:
                    string = textEditorView.createStringFormConsole();
                    break;
                case 2:
                    textEditorView.replaceCharacterInEachWordView(new CharacterStringOperation(), string);
                    break;
                case 3:
                    textEditorView.replaceCharacterInEachWordView(new CharacterStringBuilderOperation(), string);
                    break;
                case 4:
                    System.out.println(string);
                    break;
                case 5:

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
