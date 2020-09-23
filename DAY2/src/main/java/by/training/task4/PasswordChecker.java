package by.training.task4;

public class PasswordChecker {
    public static void main(String[] args) {
        final String passwordSample = "password";

        if (args.length > 0) {
            if (args[0].equals(passwordSample)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
