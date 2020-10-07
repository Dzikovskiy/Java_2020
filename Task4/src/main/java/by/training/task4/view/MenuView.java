package by.training.task4.view;

import by.training.task4.entity.Array;
import by.training.task4.service.ArrayService;

import java.io.IOException;
import java.util.Scanner;

public class MenuView {
    JaggedArrayView jaggedArrayView = new JaggedArrayView();
    private Scanner scanner = new Scanner(System.in);
    Array array = new Array();
    ArrayView arrayView = new ArrayView();
    ArrayService arrayService = new ArrayService();

    public void menu() throws IOException {
        while (true) {
            System.out.println("\n1. Create Array from console");
            System.out.println("2. Create Array from file");
            System.out.println("3. Create Array from random numbers");
            System.out.println("4. Print Array");
            System.out.println("8. exit");

            switch (scanner.nextInt()) {
                case 1:
                    arrayView.fillArrayFromConsole(array);
                    System.out.println("Array created");
                    break;
                case 2:
                    arrayService.fillArrayFromFile(array);
                    break;
                case 3:
                    System.out.println("Enter number of digits:");
                    arrayService.fillArrayWithRandomNumbers(array, scanner.nextInt());
                    break;
                case 4:
                    arrayView.printArray(array);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Wrong command !");
                    break;
            }
        }
    }
}
