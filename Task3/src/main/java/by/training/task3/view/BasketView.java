package by.training.task3.view;

import by.training.task3.entity.Ball;
import by.training.task3.entity.Basket;
import by.training.task3.service.BasketService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BasketView {

    /**
     * This method is used to sort balls by price and print them
     *
     * @param basket This is the basket
     *               Prints balls info from basket ordered by price
     */
    public void printBasketBallsOrderedByPrice(Basket basket) {
        //sort balls by price
        BasketService basketService = new BasketService();
        basketService.sortBallByPrice(basket);

        //print balls info to the console
        System.out.println(basket.toString());
    }

    /**
     * This method is used to find number of duplicated balls from basket and print them
     *
     * @param basket This is the basket
     *               Prints number same balls and its info
     */
    public void printDuplicatedBalls(Basket basket) {

        Map<Ball, Integer> map = new HashMap<>();

        //creates map of duplicated balls and its quantity
        for (Ball ball : basket.getBalls()) {
            if (map.containsKey(ball)) {
                int value = map.get(ball);
                value++;
                map.put(ball, value);

            } else {
                map.put(ball, 1);
            }
        }

        //prints ball color and its quantity to the console
        map.forEach((key, value) -> {
            if (value > 1) {
                System.out.println(key.getColor() + " ball: " + value);
            }
        });
    }

    /**
     * This method is used to find number of baskets with the same balls number and composition
     *
     * @param baskets This is the array of baskets
     *                Prints number of duplicates
     */
    public void printDuplicatedBaskets(ArrayList<Basket> baskets) {
        Map<Basket, Integer> map = new HashMap<>();

        //creates map of the same baskets and save number of them
        for (Basket basket : baskets) {
            if (map.containsKey(basket)) {
                int value = map.get(basket);
                value++;
                map.put(basket, value);
            } else {
                map.put(basket, 1);
            }

        }

        //prints number of duplicated baskets
        map.forEach((key, value) -> {
            if (value > 1) {
                System.out.println("duplicated baskets: " + value);
            }
        });

    }

    public void printTotalBallsWeight(ArrayList<Basket> baskets) {
        BasketService basketService = new BasketService();
        System.out.println("Total weight: " + basketService.getTotalBallsWeight(baskets));
    }
}
