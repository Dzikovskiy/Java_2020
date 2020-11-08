package by.training.threads;

import by.training.entity.Matrix;

public class CyclicBarrierMatrixPrintService implements Runnable {
    Matrix matrix;

    public CyclicBarrierMatrixPrintService(Matrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public void run() {
        System.out.println(matrix);
    }

}
