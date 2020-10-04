package by.training.task4.service;

import by.training.task4.entity.Array;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class ArrayService {
    final String fileName = "data.txt";

    /**
     * Method for getting Array of prime numbers from given Array
     *
     * @param array given array of numbers
     * @return Array of prime numbers
     */
    public Array getArrayOfPrimeNumbers(Array array) {
        BigInteger bigInteger;
        Array resultArray = new Array();
        for (int i = 0; i < array.getLength(); i++) {
            bigInteger = BigInteger.valueOf(array.get(i));
            if (bigInteger.isProbablePrime((int) Math.log(array.get(i))) && array.get(i) > 1) {
                resultArray.add(array.get(i));
            }
        }
        return resultArray;
    }

    /**
     * Method for filling array with random numbers s
     *
     * @param array  to fill
     * @param amount of generated numbers
     */
    public void fillArrayWithRandomNumbers(Array array, int amount) {
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            array.add(random.nextInt());
        }
    }
    
    /**
     * Method for filling array from file with numbers separated with whitespaces
     *
     * @param array to fill from file
     */
    public void fillArrayFromFile(Array array) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(fileName));

            while (scanner.hasNextInt()) {
                array.add(scanner.nextInt());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
