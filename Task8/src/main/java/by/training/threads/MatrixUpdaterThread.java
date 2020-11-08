package by.training.threads;

import by.training.entity.Matrix;
import by.training.entity.MatrixImpl;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MatrixUpdaterThread implements Runnable {

    private final Integer element;
    Matrix matrix;
    CyclicBarrier cyclicBarrier;

    public MatrixUpdaterThread(Integer element, CyclicBarrier cyclicBarrier) {
        this.element = element;
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {
        matrix = MatrixImpl.getInstance();
        matrix.insert(element);
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
