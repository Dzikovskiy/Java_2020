package by.training.task4.service;

import by.training.task4.entity.Array;
import by.training.task4.entity.JaggedArray;

public class JaggedArrayService {
    private ArrayService arrayService;

    public JaggedArrayService() {
        this.arrayService = new ArrayService();
    }

    public boolean compareSize(JaggedArray array1, JaggedArray array2) {

        //compare number of lines for both arrays
        if (array1.getLength() != array2.getLength()) {
            return false;
        }

        //compare the lines lengths of both arrays
        for (int i = 0; i < array1.getLength(); i++) {
            if (array1.get(i).getLength() != array2.get(i).getLength()) {
                return false;
            }
        }
        return true;
    }

    public boolean isSquareMatrix(JaggedArray jaggedArray) {
        int size = jaggedArray.getLength();
        if (size == 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (size != jaggedArray.get(i).getLength()) {
                return false;
            }
        }
        return true;
    }

    public void scaleMatrix(JaggedArray jaggedArray, int scale) {
        for (int i = 0; i < jaggedArray.getLength(); i++) {
            jaggedArray.set(i, arrayService.scaleArray(jaggedArray.get(i), scale));
        }
    }

    public JaggedArray sumArrays(JaggedArray jaggedArray1, JaggedArray jaggedArray2) {
        JaggedArray result = new JaggedArray();

        if (!compareSize(jaggedArray1, jaggedArray2)) {
            return result;
        }
        for (int i = 0; i < jaggedArray1.getLength(); i++) {
            result.add(arrayService.sumArrays(jaggedArray1.get(i), jaggedArray2.get(i)));
        }
        return result;
    }

    public JaggedArray subtractArrays(JaggedArray jaggedArray1, JaggedArray jaggedArray2) {
        JaggedArray result = new JaggedArray();

        if (!compareSize(jaggedArray1, jaggedArray2)) {
            return result;
        }
        for (int i = 0; i < jaggedArray1.getLength(); i++) {
            result.add(arrayService.subtractArrays(jaggedArray1.get(i), jaggedArray2.get(i)));
        }
        return result;
    }
}
