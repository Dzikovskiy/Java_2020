package by.training.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.awt.Mutex;

public class MatrixMutexImpl implements Matrix {
    private static MatrixMutexImpl instance;
    private final static Mutex mutex1 = new Mutex();
    private final static Mutex mutex2 = new Mutex();

    private int[][] matrix;
    private int counter = 0;
    private static MatrixState state;
    private Logger logger = LogManager.getLogger();

    private MatrixMutexImpl() {
    }

    public void initializeMatrix(int size) {
        matrix = new int[size][size];
    }

    public static MatrixMutexImpl getInstance() {
        mutex1.lock();
        if (instance == null) {
            instance = new MatrixMutexImpl();
            state = new MatrixEmptyState();
        }
        mutex1.unlock();
        return instance;
    }

    @Override
    public void insert(int value) {
        mutex2.lock();
        if (counter < matrix.length) {
            matrix[counter][counter] = value;
            counter++;
            state = new MatrixInProgressState();
            logger.debug("Thread inserted value: " + value);
        } else {
            state = new MatrixFilledState(matrix);
        }
        mutex2.unlock();
    }

    @Override
    public String toString() {
        return state.matrixToString();
    }
}
