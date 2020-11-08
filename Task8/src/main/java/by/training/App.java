package by.training;

import by.training.entity.MatrixImpl;
import by.training.service.MatrixConfigReaderImpl;
import by.training.threads.CyclicBarrierMatrixPrintService;
import by.training.threads.MatrixUpdaterThread;

import java.util.concurrent.CyclicBarrier;

public class App {
    public static void main(String[] args) throws InterruptedException {
        MatrixConfigReaderImpl reader = new MatrixConfigReaderImpl();

        //matrix initialization
        MatrixImpl matrix = MatrixImpl.getInstance();
        matrix.initializeMatrix(reader.matrixSize());

        //will wait all by.training.threads to print matrix after their execution
        CyclicBarrier cyclicBarrier = new CyclicBarrier(reader.threadValue(), new CyclicBarrierMatrixPrintService(matrix));

        for (int i = 0; i < reader.threadValue(); i++) {
            MatrixUpdaterThread matrixUpdaterThread = new MatrixUpdaterThread(i, cyclicBarrier);
            Thread thread = new Thread(matrixUpdaterThread);
            thread.start();
        }
    }
}
