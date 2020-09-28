package by.training.task3.entity;

import by.training.task3.service.BasketService;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Ball> balls;

    public Basket() {
        this.balls = new ArrayList<>();
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }

    public void setBalls(ArrayList<Ball> balls) {
        this.balls = balls;
    }

    public int getTotalBallsWeight() {
        int weight = 0;
        for (Ball ball : balls) {
            weight += ball.getWeight();
        }
        return weight;
    }

    public int getTotalNumberOfBallsOfColor(Color color) {
        int total = 0;
        for (Ball ball : balls) {
            if (ball.getColor().equals(color)) {
                total++;
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "balls=" + balls +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;

        if (basket.getBalls().size() != balls.size()) {
            return false;
        }

        BasketService basketService = new BasketService();
        basketService.sortByBallPrice(basket);
        basketService.sortByBallWeight(basket);

        this.balls.sort(Ball.priceComparator);
        this.balls.sort(Ball.weightComparator);

        return basket.getBalls().containsAll(balls)&& balls.containsAll(basket.getBalls());
    }

    @Override
    public int hashCode() {
        int hash = 1;

        for (Ball ball : balls) {
            hash = hash + ball.hashCode();
        }
        return hash;
    }
}
