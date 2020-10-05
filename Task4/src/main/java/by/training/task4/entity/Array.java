package by.training.task4.entity;

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
        this.data = Arrays.copyOf(this.data, this.data.length + 1);
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

    /**
     * Method for getting element by index
     *
     * @param index of element
     * @return element by index
     */
    public int get(int index) {
        if (index >= 0 && index < this.data.length) {
            return this.data[index];
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }

    /**
     * Method for setting element by index
     *
     * @param index   of element
     * @param element to set
     */
    public void set(int index, int element) {
        if (index >= 0 && index < this.data.length) {
            this.data[index] = element;
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }

    /**
     * Method for getting index of element in array
     *
     * @param element to find
     * @return index of first found element or -1 if not found
     */
    public int getElementIndex(int element) {
        for (int i = 0; i < this.data.length; i++) {
            if (data[i] == element) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Find maximum value in array using loop
     *
     * @return maximum value
     */
    public int getMaxValue() {
        int maxValue = this.data[0];
        for (int i = 1; i < this.data.length; i++) {
            if (this.data[i] > maxValue) {
                maxValue = this.data[i];
            }
        }
        return maxValue;
    }

    /**
     * Find minimum value in array using loop
     *
     * @return minimum value
     */
    public int getMinValue() {
        int minValue = this.data[0];
        for (int i = 1; i < this.data.length; i++) {
            if (this.data[i] < minValue) {
                minValue = this.data[i];
            }
        }
        return minValue;
    }

    /**
     * Method for getting size of the array
     *
     * @return size of the array
     */
    public int getLength() {
        return this.data.length;
    }

    public int[] toArray(){
        return this.data;
    }

    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Array array = (Array) o;

        return Arrays.equals(data, array.data);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }
}
