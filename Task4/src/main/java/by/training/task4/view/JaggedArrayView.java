package by.training.task4.view;

import by.training.task4.entity.JaggedArray;
import by.training.task4.service.JaggedArrayService;

public class JaggedArrayView {
    JaggedArrayService jaggedArrayService;

    public JaggedArrayView() {
        this.jaggedArrayService = new JaggedArrayService();
    }

    public void printJaggedArray(JaggedArray jaggedArray) {
        ArrayView arrayView = new ArrayView();
        for (int i = 0; i < jaggedArray.getLength(); i++) {
            arrayView.printArray(jaggedArray.get(i));
            System.out.print("\n");
        }
    }

    public void compareSize(JaggedArray array1, JaggedArray array2) {
        if (jaggedArrayService.compareSize(array1, array2)) {
            System.out.println("Same size");
        } else {
            System.out.println("Not the same size");
        }
    }

    public void printIsSquareMatrix(JaggedArray jaggedArray) {
        if (jaggedArrayService.isSquareMatrix(jaggedArray)) {
            System.out.println("Its square matrix");
        } else {
            System.out.println("Its not square matrix");
        }
    }

    public void printSumOfArrays(JaggedArray jaggedArray1, JaggedArray jaggedArray2) {
        JaggedArray result = jaggedArrayService.sumArrays(jaggedArray1, jaggedArray2);
        printJaggedArray(result);
    }
}
