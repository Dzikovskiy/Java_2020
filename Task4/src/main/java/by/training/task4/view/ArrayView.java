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

        for (int i = 0; i < toArray.length; i++) {
            array.add(toArray[i]);
        }
    }
}
