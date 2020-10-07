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
            System.out.println("5. Find number index in Array");
            System.out.println("6. Find min number in Array");
            System.out.println("7. Find max number in Array");
            System.out.println("8. Quick sort Array");
            System.out.println("9. Selection sort Array");
            System.out.println("10. Insert sort Array");
            System.out.println("20. exit");

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
                case 5:
                    System.out.println("Enter number:");
                    System.out.println("Index is:" + array.getElementIndex(scanner.nextInt()));
                    break;
                case 6:
                    System.out.println("Min element: " + array.getMinValue());
                    break;
                case 7:
                    System.out.println("Max element:" + array.getMaxValue());
                    break;
                case 8:
                    arrayService.quickSort(array);
                    arrayView.printArray(array);
                    break;
                case 9:
                    arrayService.selectionSort(array);
                    arrayView.printArray(array);
                    break;
                case 10:
                    arrayService.insertionSort(array);
                    arrayView.printArray(array);
                    break;
                case 20:
                    return;
                default:
                    System.out.println("Wrong command !");
                    break;
            }
        }
    }
}
