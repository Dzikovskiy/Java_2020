package by.training;

import by.training.entity.Matrix;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
//        Matrix matrix = Matrix.getInstance();
//
//        matrix.initializeMatrix(10);
//        matrix.setElement(0,0,10);
//        System.out.println(matrix);


        int min = 1;
        int max =10;
        Random random = new Random();
        System.out.println(ThreadLocalRandom.current().nextInt(min, max + 1));
    }
}
