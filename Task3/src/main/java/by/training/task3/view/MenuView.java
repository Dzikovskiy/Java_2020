package by.training.task3.view;

import by.training.task3.entity.Basket;
import by.training.task3.service.BasketService;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuView {
    private ArrayList<Basket> baskets = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private BasketView basketView = new BasketView();
    private BasketService basketService = new BasketService();

    public void menu() {
        while (true) {
            System.out.println("\n1. Create basket");
            System.out.println("2. Add ball to the basket");
            System.out.println("3. Quantity of same balls in the basket");
            System.out.println("4. Weight of the balls in the basket");
            System.out.println("5. Show balls from basket ordered by price");
            System.out.println("6. Show number of same baskets");
            System.out.println("7. exit");

            switch (scanner.nextInt()) {
                case 1:
                    basketService.createBasketAndAddToArray(baskets);
                    System.out.println("Basket created");
                    break;
                case 2:
                    basketService.addBallToTheBasket(baskets);
                    break;
                case 3:
                    if (baskets.size() > 0) {
                        basketView.printDuplicatedBalls(basketService.getBasketByNumberFormConsole(baskets));
                    }
                    break;
                case 4:
                    if (baskets.size() > 0) {
                        basketView.printTotalBallsWeight(baskets);
                    }
                    break;
                case 5:
                    if (baskets.size() > 0) {
                        basketView.printBasketBallsOrderedByPrice(basketService.getBasketByNumberFormConsole(baskets));
                    }
                    break;
                case 6:
                    basketView.printDuplicatedBaskets(baskets);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Wrong command !");
                    break;
            }
        }
    }


}

