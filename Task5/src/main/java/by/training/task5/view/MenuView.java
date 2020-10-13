package by.training.task5.view;

import by.training.task5.service.CharacterAfterCharacterChangerWithStringOperation;
import by.training.task5.service.CharacterOnIndexChangerStringBuilderOperation;
import by.training.task5.service.CharacterOnIndexChangerStringOperation;
import by.training.task5.service.FileService;

import java.util.Scanner;

public class MenuView {
    TextEditorView textEditorView = new TextEditorView();
    Scanner scanner = new Scanner(System.in);
    String string = "";
    FileService fileService = new FileService();


    public void menu() {
        while (true) {
            System.out.println("\n1. Create String from console");
            System.out.println("2. Replace character in each word with String methods");
            System.out.println("3. Replace character in each word with StringBuilder methods");
            System.out.println("4. Replace \"ра\" to \"ро\" in each word with String methods and save");
            System.out.println("5. Replace words by length with substring");
            System.out.println("6. Remove all non characters and double whitespaces");
            System.out.println("7. Remove words by length that start with consonant");
            System.out.println("8. Print String");
            System.out.println("9. Create String from file");
            System.out.println("10. exit");

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
                    fileService.writeTextToFile(string);
                    break;
                case 5:
                    textEditorView.replaceWordsByLengthWithSubstring(string);
                    break;
                case 6:
                    textEditorView.replaceNonCharacters(string);
                    break;
                case 7:
                    textEditorView.removeWordsByLength(string);
                    break;
                case 8:
                    System.out.println(string);
                    break;
                case 9:
                    string = textEditorView.createStringFromFile();
                    System.out.println(string);
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Wrong command !");
                    break;
            }
        }
    }
}
