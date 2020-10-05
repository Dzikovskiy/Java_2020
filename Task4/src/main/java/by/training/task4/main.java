package by.training.task4;

import by.training.task4.entity.Array;
import by.training.task4.service.ArrayService;
import by.training.task4.view.ArrayView;

public class main {
    public static void main(String[] args) {
        Array array = new Array();
        array.add(5);
        array.add(10);
        array.add(20);
        array.add(2);
        array.add(7);
        ArrayService arrayService = new ArrayService();
        arrayService.selectionSort(array);
        System.out.println(array);
        ArrayView arrayView = new ArrayView();
        arrayView.printEnteredNumberFromArrayWithBinarySearch(array);

    }
}
