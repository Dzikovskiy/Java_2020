package by.training.task3.view;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    public void menu(){
        while (true){
            System.out.println("1. Create basket");
            System.out.println("2. Add ball to the basket");
            System.out.println("3. Quantity of same balls in the baskets");
            System.out.println("4. Show balls from basket ordered by price");
            System.out.println("5. Show number of same baskets");
            System.out.println("6. exit");

            switch (scanner.nextInt()){
                case 1:
                    System.out.println("create");
                    break;

                 // TODO cases
                default:
                    System.out.println("default");
                    break;
            }
        }
    }
}
