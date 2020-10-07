package by.training.task4;

import by.training.task4.entity.Array;
import by.training.task4.entity.JaggedArray;
import by.training.task4.service.ArrayService;
import by.training.task4.service.JaggedArrayService;
import by.training.task4.view.JaggedArrayView;

public class main {
    public static void main(String[] args) {
        JaggedArrayView jaggedArrayView = new JaggedArrayView();
        JaggedArray jaggedArray = new JaggedArray();
        ArrayService arrayService = new ArrayService();
        JaggedArrayService jaggedArrayService = new JaggedArrayService();

        Array array = new Array();
        array.add(1);
        array.add(2);
        array.add(3);


        Array array2 = new Array();
        array2.add(100);
        array2.add(500);
        array2.add(200);
        array2.add(400);

        Array array3 = new Array();
        array3.add(1000);
        array3.add(3000);
        array3.add(4000);
        array3.add(5000);

        jaggedArray.add(array);
        jaggedArray.add(array2);
        jaggedArray.add(array3);


        System.out.println("");

        JaggedArray jaggedArray2 = new JaggedArray();
        jaggedArray2.add(array);
        jaggedArray2.add(array2);
        jaggedArray2.add(array3);

        jaggedArrayService.sortArrayLinesByMinElementDesc(jaggedArray);
        System.out.println();
        jaggedArrayService.sortArrayLinesByMaxElementAsc(jaggedArray2);

        jaggedArrayView.printJaggedArray(jaggedArray);

        jaggedArrayView.printJaggedArray(jaggedArray2);
    }
}
