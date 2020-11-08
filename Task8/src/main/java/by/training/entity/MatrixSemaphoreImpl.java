package by.training.entity;

import java.util.concurrent.Semaphore;

public class MatrixSemaphoreImpl implements Matrix {
    private static MatrixSemaphoreImpl instance;
    private int[][] matrix;
    private int counter = 0;
    private final static Semaphore semaphore1 = new Semaphore(1);
    private final Semaphore semaphore2 = new Semaphore(1);

    private MatrixSemaphoreImpl() {
    }

    public void initializeMatrix(int size) {
        matrix = new int[size][size];
    }

    public static MatrixSemaphoreImpl getInstance() {
        try {
            semaphore1.acquire();
            if (instance == null) {
                instance = new MatrixSemaphoreImpl();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore1.release();
        }
        return instance;
    }

    @Override
    public void insert(int value) {
        try {
            semaphore2.acquire();
            if (counter < matrix.length) {
                matrix[counter][counter] = value;
                counter++;
                System.out.println("thread: " + value);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        semaphore2.release();
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
