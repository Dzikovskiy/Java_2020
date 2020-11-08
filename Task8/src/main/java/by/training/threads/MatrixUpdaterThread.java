package by.training.threads;

import by.training.entity.Matrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MatrixUpdaterThread implements Runnable {

    private final Integer element;
    private Matrix matrix;
    private CyclicBarrier cyclicBarrier;
    private Logger logger = LogManager.getLogger();

    public MatrixUpdaterThread(Matrix matrix, Integer element, CyclicBarrier cyclicBarrier) {
        this.matrix = matrix;
        this.element = element;
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {
        matrix.insert(element);
        try {
            logger.debug("Thread has tried to insert the value to matrix and now wait barrier");
            cyclicBarrier.await();
            logger.debug("Thread passed barrier");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
