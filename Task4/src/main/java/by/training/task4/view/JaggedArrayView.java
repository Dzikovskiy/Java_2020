package by.training.task4.view;

import by.training.task4.entity.Array;
import by.training.task4.entity.JaggedArray;
import by.training.task4.service.JaggedArrayService;

import java.io.IOException;
import java.util.Scanner;

public class JaggedArrayView {
    private JaggedArrayService jaggedArrayService;
    private Scanner scanner = new Scanner(System.in);

    public JaggedArrayView() {
        this.jaggedArrayService = new JaggedArrayService();
    }

    /**
     * Method for printing the given JaggedArray
     *
     * @param jaggedArray given JaggedArray
     */
    public void printJaggedArray(JaggedArray jaggedArray) {
        ArrayView arrayView = new ArrayView();
        for (int i = 0; i < jaggedArray.getLength(); i++) {
            arrayView.printArray(jaggedArray.get(i));
            System.out.print("\n");
        }
    }

    /**
     * Method for comparing JaggedArrays and printing if they have same size
     *
     * @param array1
     * @param array2
     */
    public void compareSize(JaggedArray array1, JaggedArray array2) {
        if (jaggedArrayService.compareSize(array1, array2)) {
            System.out.println("Same size");
        } else {
            System.out.println("Not the same size");
        }
    }

    /**
     * Method for printing if Matrix is square
     *
     * @param jaggedArray
     */
    public void printIsSquareMatrix(JaggedArray jaggedArray) {
        if (jaggedArrayService.isSquareMatrix(jaggedArray)) {
            System.out.println("Its square matrix");
        } else {
            System.out.println("Its not square matrix");
        }
    }

    /**
     * Method for printing sum of two JaggedArrays
     *
     * @param jaggedArray1
     * @param jaggedArray2
     */
    public void printSumOfArrays(JaggedArray jaggedArray1, JaggedArray jaggedArray2) {
        JaggedArray result = jaggedArrayService.sumArrays(jaggedArray1, jaggedArray2);
        printJaggedArray(result);
    }

    /**
     * Method for printing subtraction of two JaggedArrays
     *
     * @param jaggedArray1
     * @param jaggedArray2
     */
    public void printSubtractionOfArrays(JaggedArray jaggedArray1, JaggedArray jaggedArray2) {
        JaggedArray result = jaggedArrayService.subtractArrays(jaggedArray1, jaggedArray2);
        printJaggedArray(result);
    }

    /**
     * Method for adding new line to given JaggedArray
     *
     * @param jaggedArray
     */
    public void addElementFromConsole(JaggedArray jaggedArray) {
        Array array = new Array();
        ArrayView arrayView = new ArrayView();
        try {
            arrayView.fillArrayFromConsole(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
        jaggedArray.add(array);
    }

    /**
     * Method for scaling given JaggedArray
     *
     * @param jaggedArray
     */
    public void scaleMatrix(JaggedArray jaggedArray) {
        System.out.println("Enter scale:");
        if (scanner.hasNextInt()) {
            jaggedArrayService.scaleMatrix(jaggedArray, scanner.nextInt());
        }
    }

}
