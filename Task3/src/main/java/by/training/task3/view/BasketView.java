package by.training.task3.view;

import by.training.task3.entity.Basket;
import by.training.task3.service.BasketService;

public class BasketView {
    public void printBasketBallsOrderedByPrice(Basket basket) {
        //sort balls by price
        BasketService basketService = new BasketService();
        basketService.sortByPrice(basket);

        //print balls info to the console
        System.out.println(basket.toString());
    }
}
