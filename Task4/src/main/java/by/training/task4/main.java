package by.training.task4;

import by.training.task4.entity.Array;
import by.training.task4.entity.JaggedArray;
import by.training.task4.service.JaggedArrayService;
import by.training.task4.view.JaggedArrayView;

public class main {
    public static void main(String[] args) {
        JaggedArrayView jaggedArrayView = new JaggedArrayView();
        JaggedArray jaggedArray = new JaggedArray();

        Array array = new Array();
        array.add(100);
        array.add(100);
        array.add(150);

        Array array2 = new Array();
        array2.add(2);
        array2.add(3);
        array2.add(4);

        Array array3 = new Array();
        array3.add(2);
        array3.add(3);
        array3.add(4);

        jaggedArray.add(array);
        jaggedArray.add(array2);
        jaggedArray.add(array3);

        JaggedArray jaggedArray2 = new JaggedArray();
        jaggedArray2.add(array);
        jaggedArray2.add(array2);
        jaggedArray2.add(array);

        jaggedArrayView.printSumOfArrays(jaggedArray, jaggedArray2);

    }
}
