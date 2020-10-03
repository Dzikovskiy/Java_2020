package by.training.task4;

import java.util.Arrays;

public class Array {

    private int[] data;
    private int size;

    /**
     * constructor with default capacity = 0
     */
    public Array() {
        this.data = new int[0];
    }

    /**
     * constructor with received initial capacity
     *
     * @param initialCapacity received capacity
     */
    public Array(int initialCapacity) {
        if (initialCapacity >= 0) {
            this.data = new int[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    /**
     * constructor with initial given array
     *
     * @param srcArray initial array
     */
    public Array(int[] srcArray) {
        this.data = srcArray;
    }

    /**
     * Method for adding int to the array
     *
     * @param elementToAdd element to add to the end of array
     */
    public void add(int elementToAdd) {
        int[] destArray = Arrays.copyOf(this.data, this.data.length + 1);
        this.data = destArray;
        this.data[this.data.length - 1] = elementToAdd;
    }

    /**
     * Method for adding an int at a given index
     *
     * @param index        index to insert an element
     * @param elementToAdd new element
     */
    public void add(int index, int elementToAdd) {
        int[] destArray = new int[this.data.length + 1];

        for (int j = 0, i = 0; i < destArray.length; i++) {
            if (i == index) {
                destArray[i] = elementToAdd;
            } else {
                destArray[i] = this.data[j];
                j++;
            }
        }
        this.data = destArray;
    }

    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
