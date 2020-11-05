package by.training;

import by.training.entity.Matrix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = Matrix.getInstance();

        matrix.initializeMatrix(10);
        matrix.setElement(0,0,10);
        System.out.println(matrix);
    }
}
