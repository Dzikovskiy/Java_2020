package by.training.task4;

import by.training.task4.entity.Array;
import by.training.task4.entity.JaggedArray;
import by.training.task4.view.JaggedArrayView;

public class main {
    public static void main(String[] args) {
        JaggedArray jaggedArray = new JaggedArray();

        Array array = new Array();
        array.add(100);
        array.add(100);
        array.add(150);
        array.add(-160);
        array.add(173);
        array.add(0);

        jaggedArray.add(array);
        System.out.println(jaggedArray);

        Array array2 = new Array();
        array2.add(2);
        array2.add(3);
        array2.add(4);
        jaggedArray.add(array2);
        System.out.println(jaggedArray);

        JaggedArrayView jaggedArrayView= new JaggedArrayView();
        jaggedArray.set(3,array);
        jaggedArrayView.printJaggedArray(jaggedArray);

    }
}
