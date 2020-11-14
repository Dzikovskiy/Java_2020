package by.training.entity;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MatrixMutexImplTest {

    @Test
    public void testInitializeMatrix() {
        MatrixMutexImpl matrix = MatrixMutexImpl.getInstance();
        final int size = 10;

        matrix.initializeMatrix(size);
        Assert.assertEquals(matrix.getMatrixSize(), size);

    }

    @Test
    public void testGetInstance() {
        MatrixMutexImpl matrix = MatrixMutexImpl.getInstance();
        MatrixMutexImpl matrix2 = MatrixMutexImpl.getInstance();

        Assert.assertNotNull(matrix);
        Assert.assertNotNull(matrix2);
        Assert.assertEquals(matrix, matrix2);
    }

    @Test
    public void testInsert() {
        MatrixMutexImpl matrixMutex = MatrixMutexImpl.getInstance();
        final int size = 10;
        matrixMutex.initializeMatrix(10);

        Assert.assertEquals(matrixMutex.toString(), "Matrix is not initialized or empty");

        for (int i = 0; i < 10; i++) {
            matrixMutex.insert(i);
        }
        Assert.assertEquals(matrixMutex.toString(), "Matrix filling in progress");

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
        matrixMutex.insert(10);
        Assert.assertEquals(matrixMutex.toString(), res);

    }

    @Test
    public void testGetMatrixSize() {
        MatrixMutexImpl matrixMutex = MatrixMutexImpl.getInstance();

        final int size = 10;
        matrixMutex.initializeMatrix(10);

        Assert.assertEquals(matrixMutex.getMatrixSize(), size);
    }
}