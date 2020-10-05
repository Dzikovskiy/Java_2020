package by.training.task4;

import by.training.task4.entity.Array;
import by.training.task4.service.ArrayService;
import by.training.task4.view.ArrayView;

public class main {
    public static void main(String[] args) {
        Array[] arrays = new Array[3];
        Array array = new Array();
        array.add(100);
        array.add(100);
        array.add(150);
        array.add(-160);
        array.add(173);
        array.add(0);

        arrays[0]= array;

        ArrayService arrayService = new ArrayService();
       ArrayView arrayView = new ArrayView();
       arrayView.printNoneDuplicatedThreeDigitNumbersFromArray(array);


    }
}
