package by.training.task4.view;

import by.training.task4.entity.Array;
import by.training.task4.entity.JaggedArray;
import by.training.task4.service.ArrayService;
import by.training.task4.service.JaggedArrayService;

import java.io.IOException;
import java.util.Scanner;

public class MenuView {
    JaggedArrayView jaggedArrayView = new JaggedArrayView();
    private Scanner scanner = new Scanner(System.in);
    Array array = new Array();
    ArrayView arrayView = new ArrayView();
    ArrayService arrayService = new ArrayService();
    JaggedArrayService jaggedArrayService = new JaggedArrayService();
    JaggedArray jaggedArray1 = new JaggedArray();
    JaggedArray jaggedArray2 = new JaggedArray();
    ;

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
            System.out.println("11. Binary search in Array");
            System.out.println("12. Print prime numbers in Array");
            System.out.println("13. Print fib numbers in Array");
            System.out.println("14. Print three digit numbers in Array");
            System.out.println("15. Add row to the JaggedArray 1");
            System.out.println("16. Add row to the JaggedArray 2");
            System.out.println("17. Print JaggedArray 1");
            System.out.println("18. Print JaggedArray 2");
            System.out.println("19. Compare jagged arrays size");
            System.out.println("20. Is jagArr 1 square matrix ?");
            System.out.println("21. Is jagArr 1 square matrix ?");
            System.out.println("22. Print subtraction of jagged arrays");
            System.out.println("23. Print sum of jagged arrays");
            System.out.println("24. Scale jagged array 1");
            System.out.println("25. Transpose jagged array 1");
            System.out.println("26. Sort lines by max element in jagged array 1");
            System.out.println("27. Sort lines by sum in jagged array 1");
            System.out.println("28. Sort lines by min element in jagged array 1");
            System.out.println("29. exit");

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
                case 11:
                    arrayView.printEnteredNumberFromArrayWithBinarySearch(array);
                    break;
                case 12:
                    arrayView.printPrimeNumbers(array);
                    break;
                case 13:
                    arrayView.printFibFromArray(array);
                    break;
                case 14:
                    arrayView.printNoneDuplicatedThreeDigitNumbersFromArray(array);
                    break;
                case 15:
                    jaggedArrayView.addElementFromConsole(jaggedArray1);
                    break;
                case 16:
                    jaggedArrayView.addElementFromConsole(jaggedArray2);
                    break;
                case 17:
                    jaggedArrayView.printJaggedArray(jaggedArray1);
                    break;
                case 18:
                    jaggedArrayView.printJaggedArray(jaggedArray2);
                    break;
                case 19:
                    jaggedArrayView.compareSize(jaggedArray1, jaggedArray2);
                    break;
                case 20:
                    jaggedArrayView.printIsSquareMatrix(jaggedArray1);
                    break;
                case 21:
                    jaggedArrayView.printIsSquareMatrix(jaggedArray2);
                    break;
                case 22:
                    jaggedArrayView.printSubtractionOfArrays(jaggedArray1, jaggedArray2);
                    break;
                case 23:
                    jaggedArrayView.printSumOfArrays(jaggedArray1, jaggedArray2);
                    break;
                case 24:
                    jaggedArrayView.scaleMatrix(jaggedArray1);
                    break;
                case 25:
                    jaggedArrayService.transposeMatrix(jaggedArray1);
                    break;
                case 26:
                    jaggedArrayService.sortArrayLinesByMaxElementAsc(jaggedArray1);
                    break;
                case 27:
                    jaggedArrayService.sortArrayLinesBySumAsc(jaggedArray1);
                    break;
                case 28:
                    jaggedArrayService.sortArrayLinesByMinElementAsc(jaggedArray1);
                    break;
                case 29:
                    return;
                default:
                    System.out.println("Wrong command !");
                    break;
            }
        }
    }
}
