package by.training.task4.entity;

import java.util.Arrays;

public class JaggedArray {
    private Array[] jaggedArray;

    public JaggedArray() {
        this.jaggedArray = new Array[0];
    }

    public JaggedArray(int initialCapacity) {
        this.jaggedArray = new Array[initialCapacity];
    }

    public JaggedArray(Array[] jaggedArray) {
        this.jaggedArray = jaggedArray;
    }

    public void add(Array array) {
        this.jaggedArray = Arrays.copyOf(this.jaggedArray, this.jaggedArray.length + 1);
        this.jaggedArray[this.jaggedArray.length - 1] = array;
    }

    public Array get(int index) {
        if (index >= 0 && index < this.jaggedArray.length) {
            return this.jaggedArray[index];
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }

    public void set(int index, Array element) {
        if (index >= 0 && index < this.jaggedArray.length) {
            this.jaggedArray[index] = element;
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }

    public int getLength() {
        return this.jaggedArray.length;
    }

    @Override
    public String toString() {
        return "JaggedArray{" +
                "jaggedArray=" + Arrays.toString(jaggedArray) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JaggedArray that = (JaggedArray) o;

        if (jaggedArray.length!=that.getLength()){
            return false;
        }

        for (int i = 0; i < jaggedArray.length; i++) {
            if (!jaggedArray[i].equals(that.jaggedArray[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(jaggedArray);
    }
}
