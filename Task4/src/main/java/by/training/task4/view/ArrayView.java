package by.training.task4.view;

import by.training.task4.entity.Array;
import by.training.task4.service.ArrayService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayView {
    private ArrayService arrayService;
    Scanner scanner = new Scanner(System.in);

    public ArrayView() {
        this.arrayService = new ArrayService();
    }

    public void printArray(Array array){
        System.out.print("[");
        for (int i=0;i<array.getLength();i++){
            System.out.print(array.get(i)+", ");
        }
        System.out.print("]");
    }

    /**
     * Method for printing array to the console
     *
     * @param array given array of numbers
     */
    public void printPrimeNumbers(Array array) {
        Array arrayPrime = arrayService.getArrayOfPrimeNumbers(array);
        for (int i = 0; i < arrayPrime.getLength(); i++) {
            System.out.println(arrayPrime.get(i) + " ");
        }
    }

    /**
     * Method for filling given array with numbers from console
     *
     * @param array given array to fill
     * @throws IOException
     */
    public void fillArrayFromConsole(Array array) throws IOException {
        System.out.println("Enter numbers separated with whitespaces:");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] toArray = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        for (int j : toArray) {
            array.add(j);
        }
    }

    /**
     * Method for printing index of the entered from console number in array
     *
     * @param array given array
     */
    public void printEnteredNumberFromArrayWithBinarySearch(Array array) {
        int index = -1;
        System.out.print("\nEnter number to search: ");
        if (scanner.hasNextInt()) {
            index = arrayService.binarySearch(array.toArray(), scanner.nextInt(), 0, array.getLength() - 1);
        }
        System.out.print("Its index is: " + index);
    }

    /**
     * Method for printing Array of fibonacci numbers from given Array
     *
     * @param array given Array
     */
    public void printFibFromArray(Array array) {
        Array result = arrayService.checkFib(array.toArray());
        System.out.println(result);
    }

    /**
     * Method for printing Array of three digit none duplicated numbers from the given Array
     *
     * @param array given Array
     */
    public void printNoneDuplicatedThreeDigitNumbersFromArray(Array array) {
        Array result = arrayService.getNoneDuplicatedThreeDigitNumbers(array.toArray());
        System.out.println(result);
    }
}
