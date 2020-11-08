package by.training.threads;

import by.training.entity.Matrix;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MatrixUpdaterThread implements Runnable {

    private final Integer element;
    Matrix matrix;
    CyclicBarrier cyclicBarrier;

    public MatrixUpdaterThread(Matrix matrix, Integer element, CyclicBarrier cyclicBarrier) {
        this.matrix = matrix;
        this.element = element;
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {
        matrix.insert(element);
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
