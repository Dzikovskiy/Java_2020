package by.training.task3.service;

import by.training.task3.entity.Ball;
import by.training.task3.entity.Basket;

public class BasketService {

    /**
     * This method is used to sort balls inside of basket by price
     *
     * @param basket This is the basket
     */
    public void sortBallByPrice(Basket basket) {
        if (basket != null) {
            basket.getBalls().sort(Ball.priceComparator);
        }
    }

    /**
     * This method is used to sort balls inside of basket by weight
     *
     * @param basket This is the basket
     */
    public void sortBallByWeight(Basket basket) {
        if (basket != null) {
            basket.getBalls().sort(Ball.weightComparator);
        }
    }


}
