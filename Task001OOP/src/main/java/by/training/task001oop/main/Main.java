package by.training.task001oop.main;

import by.training.task001oop.service.MathHelper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter number: ");
            System.out.println((MathHelper.isNumberPerfect(scanner.nextInt())));
        }
    }
}
