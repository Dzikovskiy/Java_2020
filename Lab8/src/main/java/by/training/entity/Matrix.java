package by.training.entity;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class Matrix {
    private static final Matrix instance = new Matrix();
    private int[][] matrix;

    ReentrantLock locker = new ReentrantLock();

    private Matrix() {
    }

    public static Matrix getInstance() {
        return instance;
    }

    public void initializeMatrix(int size) {
        matrix = new int[size][size];
    }

    public void setElement(int line, int column, int element) {
        locker.lock();
        if (matrix != null) {
            matrix[line][column] = element;
        } else {
            throw new NullPointerException();
        }
        locker.unlock();
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "matrix=" + Arrays.deepToString(matrix) +
                '}';
    }
}
