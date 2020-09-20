package by.training.task001oop.service;

public class MathHelper {
    /**
     * This method is used to check if the number is perfect.
     *
     * @param n This is the given number
     * @return boolean This returns is the number perfect.
     */
    public static boolean isNumberPerfect(int n) {
        if (n == 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }
}

