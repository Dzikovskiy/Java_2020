package by.training.task5;

public class ArgsAdditioner {
    public static void main(String[] args) {
        if (args.length > 1) {
            System.out.println("Sum is: " + (Integer.parseInt(args[0]) + Integer.parseInt(args[1])));
        }
    }
}
