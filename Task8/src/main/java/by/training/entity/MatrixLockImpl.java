package by.training.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixLockImpl implements Matrix {
    private static MatrixLockImpl instance;
    private final static Lock lock1 = new ReentrantLock();
    private final static Lock lock2 = new ReentrantLock();
    private int[][] matrix;
    private int counter = 0;
    private static MatrixState state;
    private final Logger logger = LogManager.getLogger();

    private MatrixLockImpl() {
    }

    public void initializeMatrix(int size) {
        matrix = new int[size][size];
    }

    public static MatrixLockImpl getInstance() {
        lock1.lock();
        if (instance == null) {
            instance = new MatrixLockImpl();
            state = new MatrixEmptyState();
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
            state = new MatrixInProgressState();
            logger.debug("Thread inserted value: " + value);
        } else {
            state = new MatrixFilledState(matrix);
        }
        lock2.unlock();
    }

    public int getMatrixSize(){
        return this.matrix.length;
    }

    @Override
    public String toString() {
        return state.matrixToString();
    }
}
