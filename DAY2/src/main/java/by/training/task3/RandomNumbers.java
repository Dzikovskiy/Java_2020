package by.training.task3;

import java.util.Random;

public class RandomNumbers {
    //takes arg[0] as amount of numbers and arg[1] as type of output print numbers to the console
    public static void main(String[] args) {
        if (args.length > 1) {
            Random random = new Random();
            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                if (args[1].equals("print")) {
                    System.out.print(random.nextInt()+" ");
                } else if (args[1].equals("println")) {
                    System.out.println(random.nextInt()+" ");
                }
            }
        }
    }
}
