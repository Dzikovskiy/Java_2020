package by.training.task4.service;

import by.training.task4.entity.Array;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
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

    /**
     * Method for quicksort of the given Array
     *
     * @param array given Array
     */
    public void quickSort(Array array) {
        ArraySortService arraySortService = new ArraySortService();
        int[] arrayToSort = array.toArray();
        arraySortService.quickSort(arrayToSort, 0, arrayToSort.length - 1);
    }

    /**
     * Method for insertion sort of the given Array
     *
     * @param array given Array
     */
    public void insertionSort(Array array) {
        ArraySortService arraySortService = new ArraySortService();
        int[] arrayToSort = array.toArray();
        arraySortService.insertionSort(arrayToSort);
    }

    /**
     * Method for selection sort of the given Array
     *
     * @param array given Array
     */
    public void selectionSort(Array array) {
        ArraySortService arraySortService = new ArraySortService();
        int[] arrayToSort = array.toArray();
        arraySortService.selectionSort(arrayToSort);
    }

    /**
     * Method for binary searching of index of the given element
     *
     * @param sortedArray
     * @param key         element to search
     * @param low         could be first element
     * @param high        could be last element
     * @return element index if found or -1 if not
     */
    public int binarySearch(int[] sortedArray, int key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    /**
     * Helper for checkFib
     *
     * @param num
     * @return
     */
    private boolean isPerfectSquare(int num) {
        int n = (int) (Math.sqrt(num));
        return (n * n == num);
    }

    /**
     * Method to check if the number
     * is in Fibonacci or not
     *
     * @param array given array
     * @return result array of fib numbers
     */
    public Array checkFib(int array[]) {
        Array resultArray = new Array();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (isPerfectSquare(5 * array[i] * array[i] + 4) || isPerfectSquare(5 * array[i] * array[i] - 4)) {
                resultArray.add(array[i]);
            }
        }
        return resultArray;
    }

    /**
     * Method for getting array of three digit none duplicated numbers from the given array
     *
     * @param array given array
     * @return result Array
     */
    public Array getNoneDuplicatedThreeDigitNumbers(int[] array) {
        Array resultArray = new Array();
        Map<Integer, Integer> numToCountMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 99 || array[i] < -99 && array[i] < 1000) {
                Integer key = array[i];
                if (numToCountMap.containsKey(key)) {
                    numToCountMap.put(key, numToCountMap.get(key) + 1);
                } else {
                    numToCountMap.put(key, 1);
                }
            }

        }

        for (Map.Entry<Integer, Integer> entry : numToCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                resultArray.add(entry.getKey());
            }
        }

        return resultArray;
    }

    /**
     * Method for scaling an Array
     *
     * @param array given Array
     * @param scale to scale
     * @return scaled array
     */
    public Array scaleArray(Array array, int scale) {
        for (int i = 0; i < array.getLength(); i++) {
            array.set(i, array.get(i) * scale);
        }
        return array;
    }

    /**
     * Method for summing two arrays
     *
     * @param array1
     * @param array2
     * @return resulted array
     */
    public Array sumArrays(Array array1, Array array2) {//TODO exception of sizes
        Array result = new Array();
        for (int i = 0; i < array1.getLength(); i++) {
            result.add(array1.get(i) + array2.get(i));
        }
        return result;
    }

    /**
     * @param array1 Method for subtraction of two Arrays
     * @param array2
     * @return resulted Array
     */
    public Array subtractArrays(Array array1, Array array2) {//TODO exception of sizes
        Array result = new Array();
        for (int i = 0; i < array1.getLength(); i++) {
            result.add(array1.get(i) - array2.get(i));
        }
        return result;
    }

    /**
     * Method for getting sum of all Array elements
     *
     * @param array given Array
     * @return sum of the elements
     */
    public int getSumOfArray(Array array) {
        int sum = 0;
        for (int i = 0; i < array.getLength(); i++) {
            sum += array.get(i);
        }
        return sum;
    }

    /**
     * Method for getting max element of given Array
     *
     * @param array given Array
     * @return max element
     */
    public int getMaxElement(Array array) {
        int max = array.get(0);
        for (int i = 0; i < array.getLength(); i++) {
            if (max < array.get(i)) {
                max = array.get(i);
            }
        }
        return max;
    }

    /**
     * Method for getting min element of given Array
     *
     * @param array given Array
     * @return min element
     */
    public int getMinElement(Array array) {
        int min = array.get(0);

        for (int i = 0; i < array.getLength(); i++) {
            if (array.get(i) < min) {
                min = array.get(i);
            }
        }
        return min;
    }
}
