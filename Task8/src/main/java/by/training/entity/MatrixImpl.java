package by.training.entity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixImpl implements Matrix {
    private static MatrixImpl instance;
    private final static Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();
    private int[][] matrix;
    private int counter = 0;

    private MatrixImpl() {
    }

    public void initializeMatrix(int size) {
        matrix = new int[size][size];
    }

    public static MatrixImpl getInstance() {
        lock1.lock();
        if (instance == null) {
            instance = new MatrixImpl();
        }
        lock1.unlock();
        return instance;
    }

    @Override
    public void insert(int value) {
        lock2.lock();
        if (counter < matrix.length) {
            matrix[counter][counter] = value;
            counter++;
            System.out.println("thread: " + value);
        }
        lock2.unlock();
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                result.append("[").append(anInt).append("]");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
