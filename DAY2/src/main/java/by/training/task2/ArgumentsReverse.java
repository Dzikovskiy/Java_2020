package by.training.task2;

public class ArgumentsReverse {
    //reverse command line arguments and print them to the console
    public static void main(String[] args) {
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.print(" "+args[i]+" ");
        }
    }
}
