package by.training.entity;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MatrixLockImplTest {

    @Test
    public void testInitializeMatrix() {
        MatrixLockImpl matrix = MatrixLockImpl.getInstance();
        final int size = 10;

        matrix.initializeMatrix(size);
        Assert.assertEquals(matrix.getMatrixSize(), size);

    }

    @Test
    public void testGetInstance() {
        MatrixLockImpl matrix = MatrixLockImpl.getInstance();
        MatrixLockImpl matrix2 = MatrixLockImpl.getInstance();

        Assert.assertNotNull(matrix);
        Assert.assertNotNull(matrix2);
        Assert.assertEquals(matrix, matrix2);
    }

    @Test
    public void testInsert() {
        MatrixLockImpl matrixLock = MatrixLockImpl.getInstance();
        final int size = 10;
        matrixLock.initializeMatrix(10);

        Assert.assertEquals(matrixLock.toString(), "Matrix is not initialized or empty");

        for (int i = 0; i < 10; i++) {
            matrixLock.insert(i);
        }
        Assert.assertEquals(matrixLock.toString(), "Matrix filling in progress");

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
        matrixLock.insert(10);
        Assert.assertEquals(matrixLock.toString(), res);

    }

    @Test
    public void testGetMatrixSize() {
        MatrixLockImpl matrixLock = MatrixLockImpl.getInstance();

        final int size = 10;
        matrixLock.initializeMatrix(10);

        Assert.assertEquals(matrixLock.getMatrixSize(), size);
    }
}