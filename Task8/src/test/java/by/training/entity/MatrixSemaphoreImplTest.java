package by.training.entity;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MatrixSemaphoreImplTest {

    @Test
    public void testInitializeMatrix() {
        MatrixSemaphoreImpl matrixSemaphore = MatrixSemaphoreImpl.getInstance();
        final int size = 10;

        matrixSemaphore.initializeMatrix(size);
        Assert.assertEquals(matrixSemaphore.getMatrixSize(), size);

    }

    @Test
    public void testGetInstance() {
        MatrixSemaphoreImpl matrixSemaphore = MatrixSemaphoreImpl.getInstance();
        MatrixSemaphoreImpl matrixSemaphore2 = MatrixSemaphoreImpl.getInstance();

        Assert.assertNotNull(matrixSemaphore);
        Assert.assertNotNull(matrixSemaphore2);
        Assert.assertEquals(matrixSemaphore, matrixSemaphore2);
    }

    @Test
    public void testInsert() {
        MatrixSemaphoreImpl matrixSemaphore = MatrixSemaphoreImpl.getInstance();
        final int size = 10;
        matrixSemaphore.initializeMatrix(10);

        Assert.assertEquals(matrixSemaphore.toString(), "Matrix is not initialized or empty");

        for (int i = 0; i < 10; i++) {
            matrixSemaphore.insert(i);
        }
        Assert.assertEquals(matrixSemaphore.toString(), "Matrix filling in progress");

        StringBuilder result = new StringBuilder();
        int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 4, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 5, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 6, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 8, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 9}};

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                result.append("[").append(anInt).append("]");
            }
            result.append("\n");
        }

        String res = result.toString();
        matrixSemaphore.insert(10);
        Assert.assertEquals(matrixSemaphore.toString(), res);

    }

    @Test
    public void testGetMatrixSize() {
        MatrixSemaphoreImpl matrixSemaphore = MatrixSemaphoreImpl.getInstance();

        final int size = 10;
        matrixSemaphore.initializeMatrix(10);

        Assert.assertEquals(matrixSemaphore.getMatrixSize(), size);
    }
}