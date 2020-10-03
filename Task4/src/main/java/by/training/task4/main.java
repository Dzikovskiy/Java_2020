package by.training.task4;

public class main {
    public static void main(String[] args) {
        Array array = new Array(0);
        array.add(0, 5000);
        array.add(1, 6000);
        array.add(2, 7000);
        System.out.println(array);
        int[] arr = new int[5];
        arr[0] = 100;
        arr[1] = 200;
        arr[2] = 300;
        array = new Array(arr);
        System.out.println(array);
    }
}
