package by.training.task3.service;

import by.training.task3.entity.Ball;
import by.training.task3.entity.Basket;

public class BasketService {
    public void sortByPrice(Basket basket) {
        if (basket != null) {
            basket.getBalls().sort(Ball.priceComparator);
        }
    }
}
