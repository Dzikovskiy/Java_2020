package by.training.service;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MatrixConfigReaderImplTest {

    @Test
    public void testThreadValue() {
        MatrixConfigReaderImpl reader = new MatrixConfigReaderImpl();
        reader.setPATH_TO_FILE("src\\test\\resources\\threadConfig");

        reader.readValues();

        Assert.assertEquals(reader.threadValue(), 15);
    }

    @Test
    public void testMatrixSize() {
        MatrixConfigReaderImpl reader = new MatrixConfigReaderImpl();
        reader.setPATH_TO_FILE("src\\test\\resources\\threadConfig");

        reader.readValues();

        Assert.assertEquals(reader.matrixSize(), 10);
    }

    @Test
    public void testReadValues() {
        MatrixConfigReaderImpl reader = new MatrixConfigReaderImpl();
        reader.setPATH_TO_FILE("src\\test\\resources\\threadConfig");

        reader.readValues();

        Assert.assertEquals(reader.matrixSize(), 10);
        Assert.assertEquals(reader.threadValue(), 15);

    }
}