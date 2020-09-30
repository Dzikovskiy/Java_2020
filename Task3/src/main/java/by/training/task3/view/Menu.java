package by.training.task3.view;

import by.training.task3.entity.Ball;
import by.training.task3.entity.Basket;
import by.training.task3.entity.Color;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    ArrayList<Basket> baskets = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    BasketView basketView = new BasketView();

    public void menu() {
        while (true) {
            System.out.println("1. Create basket");
            System.out.println("2. Add ball to the basket");
            System.out.println("3. Quantity of same balls in the basket");
            System.out.println("4. Show balls from basket ordered by price");
            System.out.println("5. Show number of same baskets");
            System.out.println("6. exit");

            switch (scanner.nextInt()) {
                case 1:
                    createBasketAndAddToArray(baskets);
                    System.out.println("Basket created");
                    break;
                case 2:
                    addBallToTheBasket(baskets);
                    break;
                case 3:
                    if (baskets.size() > 0) {
                        basketView.printDuplicatedBalls(getBasketByNumberFormConsole(baskets));
                    }
                    break;
                case 4:
                    if (baskets.size() > 0) {
                        basketView.printBasketBallsOrderedByPrice(getBasketByNumberFormConsole(baskets));
                    }
                    break;
                case 5:
                    basketView.printDuplicatedBaskets(baskets);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Wrong command !");
                    break;
            }
        }
    }

    //return basket by number from console from arraylist
    private Basket getBasketByNumberFormConsole(ArrayList<Basket> baskets) {
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

    // method for input ball info and adding it to the basket from array by index
    private void addBallToTheBasket(ArrayList<Basket> baskets) {
        int i = 0;
        if (baskets.size() < 1) {
            System.out.println("You have 0 baskets. Please create basket first.");
        }
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

    //creates basket and adding it to the arraylist
    public void createBasketAndAddToArray(ArrayList<Basket> baskets) {
        baskets.add(new Basket());
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
}

