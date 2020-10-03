package by.training.task3.service;

import by.training.task3.entity.Ball;
import by.training.task3.entity.Basket;
import by.training.task3.entity.Color;

import java.util.ArrayList;
import java.util.Scanner;

public class BasketService {
    private Scanner scanner = new Scanner(System.in);

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

    //return basket by number from console from arraylist
    public Basket getBasketByNumberFormConsole(ArrayList<Basket> baskets) {
        int i = 0;
        if (baskets.size() < 1) {
            System.out.println("You have 0 baskets. Please create basket first.");
        }
        System.out.println("Enter number of basket from 1" + " to " + baskets.size());
        while (true) {
            i = scanner.nextInt();

            if (i <= baskets.size() && i > 0) {
                return baskets.get(i - 1);
            } else {
                System.out.println("Enter correct number of basket");
            }
        }
    }

    //creates basket and adding it to the arraylist
    public void createBasketAndAddToArray(ArrayList<Basket> baskets) {
        baskets.add(new Basket());
    }

    // method for input ball info and adding it to the basket from array by index
    public void addBallToTheBasket(ArrayList<Basket> baskets) {
        int i = 0;
        if (baskets.size() < 1) {
            System.out.println("You have 0 baskets. Please create basket first.");
        } else {
            System.out.println("Enter number of basket from 1" + " to " + baskets.size());
            while (true) {
                i = scanner.nextInt();

                if (i <= baskets.size() && i > 0) {

                    Ball ball = new Ball();

                    System.out.println("Enter price:");
                    ball.setPrice(scanner.nextInt());
                    System.out.println("Enter weight");
                    ball.setWeight(scanner.nextInt());
                    System.out.println("Enter color");
                    enterColorFromConsole(ball);
                    ArrayList<Ball> balls = baskets.get(i - 1).getBalls();
                    balls.add(ball);
                    baskets.get(i - 1).setBalls(balls);

                    System.out.println("Ball added");

                    return;
                } else {
                    System.out.println("Enter correct number of basket");
                }
            }
        }
    }

    //assign color from enum entered from console to the ball
    private void enterColorFromConsole(Ball ball) {
        while (!findColorInEnumAndAssignToBall(ball)) {
            System.out.println("Enter correct color");
        }

    }

    //checks if color from exists in Color enum
    private boolean findColorInEnumAndAssignToBall(Ball ball) {
        String colorInput;

        colorInput = scanner.next().toLowerCase();

        for (Color color : Color.values()) {
            if (color.getColor().equalsIgnoreCase(colorInput)) {
                ball.setColor(color);
                return true;
            }
        }
        return false;
    }

    public int getTotalBallsWeight(ArrayList<Basket> baskets) {
        int i = 0;
        if (baskets.size() < 1) {
            System.out.println("You have 0 baskets. Please create basket first.");
        }
        System.out.println("Enter number of basket from 1" + " to " + baskets.size());
        while (true) {
            i = scanner.nextInt();

            if (i <= baskets.size() && i > 0) {
                return baskets.get(i-1).getTotalBallsWeight();
            } else {
                System.out.println("Enter correct number of basket");
            }
        }
    }


}
