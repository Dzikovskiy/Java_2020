package by.training.task3.main;

import by.training.task3.entity.Ball;
import by.training.task3.entity.Basket;
import by.training.task3.entity.Color;

public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball();
        ball.setColor(Color.BLACK);
        ball.setPrice(10);
        ball.setWeight(100);

        Ball ball2 = new Ball();
        ball2.setWeight(100);
        ball2.setPrice(10);
        ball2.setColor(Color.RED);

        Basket basket = new Basket();
    }
}
