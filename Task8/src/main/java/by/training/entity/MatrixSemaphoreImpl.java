package by.training.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.concurrent.Semaphore;

public class MatrixSemaphoreImpl implements Matrix {
    private static MatrixSemaphoreImpl instance;
    private int[][] matrix;
    private int counter = 0;
    private final static Semaphore semaphore1 = new Semaphore(1);
    private final Semaphore semaphore2 = new Semaphore(1);
    private static MatrixState state;
    private Logger logger = LogManager.getLogger();

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
                state = new MatrixEmptyState();
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
                state = new MatrixInProgressState();
                logger.debug("Thread inserted value: " + value);
            } else {
                state = new MatrixFilledState(matrix);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        semaphore2.release();
    }

    public int getMatrixSize() {
        return this.matrix != null ? this.matrix.length : null;
    }


    @Override
    public String toString() {
        return state.matrixToString();
    }
}
