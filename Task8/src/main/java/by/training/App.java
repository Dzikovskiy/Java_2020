package by.training;

import by.training.entity.MatrixLockImpl;
import by.training.entity.MatrixSemaphoreImpl;
import by.training.service.MatrixConfigReaderImpl;
import by.training.threads.CyclicBarrierMatrixPrintService;
import by.training.threads.MatrixUpdaterThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CyclicBarrier;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = LogManager.getLogger();
        logger.info("Program start");

        MatrixConfigReaderImpl reader = new MatrixConfigReaderImpl();

        //matrix initialization
        MatrixLockImpl matrix = MatrixLockImpl.getInstance();
        matrix.initializeMatrix(reader.matrixSize());

        //will wait all by.training.threads to print matrix after their execution
        CyclicBarrier cyclicBarrier = new CyclicBarrier(reader.threadValue(),
                new CyclicBarrierMatrixPrintService(matrix));

        for (int i = 0; i < reader.threadValue(); i++) {
            MatrixUpdaterThread matrixUpdaterThread = new MatrixUpdaterThread(MatrixLockImpl.getInstance(), i, cyclicBarrier);
            Thread thread = new Thread(matrixUpdaterThread);
            thread.start();
        }

        //second solution
        MatrixSemaphoreImpl matrixSemaphore = MatrixSemaphoreImpl.getInstance();
        matrixSemaphore.initializeMatrix(reader.matrixSize());

        cyclicBarrier = new CyclicBarrier(reader.threadValue(),
                new CyclicBarrierMatrixPrintService(matrixSemaphore));

        for (int i = 0; i < reader.threadValue(); i++) {
            MatrixUpdaterThread matrixUpdaterThread = new MatrixUpdaterThread(MatrixSemaphoreImpl.getInstance(), i, cyclicBarrier);
            Thread thread = new Thread(matrixUpdaterThread);
            thread.start();
        }

    }
}
