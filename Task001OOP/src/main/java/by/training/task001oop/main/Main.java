package by.training.task001oop.main;

import by.training.task001oop.service.MathHelper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter number: ");
            if (MathHelper.isNumberPerfect(scanner.nextInt())) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
