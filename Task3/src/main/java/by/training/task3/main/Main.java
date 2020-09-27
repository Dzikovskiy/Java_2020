package by.training.task3.main;

import by.training.task3.entity.Ball;
import by.training.task3.entity.Basket;
import by.training.task3.entity.Color;
import by.training.task3.view.BasketView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball();
        ball.setColor(Color.BLACK);
        ball.setPrice(10);
        ball.setWeight(100);

        Ball ball2 = new Ball();
        ball2.setWeight(100);
        ball2.setPrice(11);
        ball2.setColor(Color.BLACK);

        Ball ball3 = new Ball();
        ball3.setWeight(100);
        ball3.setPrice(11);
        ball3.setColor(Color.BLACK);

        Ball ball4 = new Ball();
        ball4.setWeight(100);
        ball4.setPrice(11);
        ball4.setColor(Color.RED);

        Ball ball5 = new Ball();
        ball5.setWeight(100);
        ball5.setPrice(11);
        ball5.setColor(Color.RED);

        Basket basket = new Basket();
        ArrayList<Ball> list = new ArrayList<>();
        list.add(ball);
        list.add(ball2);
        list.add(ball3);
        list.add(ball4);
        list.add(ball5);

        basket.setBalls(list);

        BasketView basketView = new BasketView();
        basketView.printDuplicatedBalls(basket);
    }
}
