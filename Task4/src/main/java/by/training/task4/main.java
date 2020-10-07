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
        array.add(100);
        array.add(7);
        array.add(7050);

        Array array2 = new Array();
        array2.add(400);
        array2.add(5);
        array2.add(2000);

        Array array3 = new Array();
        array3.add(200);
        array3.add(3);
        array3.add(4000);

        jaggedArray.add(array);
        jaggedArray.add(array2);
        jaggedArray.add(array3);

        jaggedArrayService.sortArrayLinesByMinElement(jaggedArray);
        jaggedArrayView.printJaggedArray(jaggedArray);

        JaggedArray jaggedArray2 = new JaggedArray();
        jaggedArray2.add(array);
        jaggedArray2.add(array2);
        jaggedArray2.add(array3);

        jaggedArrayService.transposeMatrix(jaggedArray);

        jaggedArrayView.printJaggedArray(jaggedArray);



    }
}
