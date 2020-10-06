package by.training.task4.view;

import by.training.task4.entity.Array;
import by.training.task4.entity.JaggedArray;

public class JaggedArrayView {

    public void printJaggedArray(JaggedArray jaggedArray) {
        ArrayView arrayView = new ArrayView();
        for (int i = 0; i < jaggedArray.getLength(); i++) {
            arrayView.printArray(jaggedArray.get(i));
            System.out.print("\n");
        }
    }
}
