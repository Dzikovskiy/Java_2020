package by.training.threads;

import by.training.entity.Matrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CyclicBarrierMatrixPrintService implements Runnable {
    private Matrix matrix;
    private Logger logger = LogManager.getLogger();

    public CyclicBarrierMatrixPrintService(Matrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public void run() {
        System.out.println(matrix);
    }

}
