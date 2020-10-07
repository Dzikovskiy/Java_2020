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

    public void sortArrayLinesBySum(JaggedArray jaggedArray) {
        for (int i = jaggedArray.getLength() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayService.getSumOfArray(jaggedArray.get(j)) > arrayService.getSumOfArray(jaggedArray.get(j + 1))) {
                    Array tmp = jaggedArray.get(j);
                    jaggedArray.set(j, jaggedArray.get(j + 1));
                    jaggedArray.set(j + 1, tmp);
                }
            }
        }
    }

    public void sortArrayLinesByMaxElement(JaggedArray jaggedArray) {
        for (int i = jaggedArray.getLength() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayService.getMaxElement(jaggedArray.get(j)) > arrayService.getMaxElement(jaggedArray.get(j + 1))) {
                    Array tmp = jaggedArray.get(j);
                    jaggedArray.set(j, jaggedArray.get(j + 1));
                    jaggedArray.set(j + 1, tmp);
                }
            }
        }
    }

    public void sortArrayLinesByMinElement(JaggedArray jaggedArray) {
        for (int i = jaggedArray.getLength() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayService.getMinElement(jaggedArray.get(j)) > arrayService.getMinElement(jaggedArray.get(j + 1))) {
                    Array tmp = jaggedArray.get(j);
                    jaggedArray.set(j, jaggedArray.get(j + 1));
                    jaggedArray.set(j + 1, tmp);
                }
            }
        }
    }

    public int getMaxLinesLength(JaggedArray jaggedArray) {
        int max = 0;
        for (int i = 0; i < jaggedArray.getLength(); i++) {
            if (max < jaggedArray.get(i).getLength()) {
                max = jaggedArray.get(i).getLength();
            }
        }
        return max;
    }

    public void transposeMatrix(JaggedArray jaggedArray) {
        if (isSquareMatrix(jaggedArray)) {
            for (int i = 0; i < jaggedArray.getLength(); i++) {
                for (int j = i + 1; j < jaggedArray.getLength(); j++) {
                    int temp = jaggedArray.get(i).get(j);

                    //  int temp = a[i][j];

                    Array a = jaggedArray.get(i);
                    a.set(j, jaggedArray.get(j).get(i));

                    jaggedArray.set(i, a);

                    // a[i][j] = a[j][i];

                    a = jaggedArray.get(j);
                    a.set(i, temp);

                    jaggedArray.set(j, a);

                    //a[j][i] = temp;
                }
            }
        } else {

            // 4 3 ok - 3 4
            // 3 4  - 4 3
//            int size = getMaxLinesLength(jaggedArray);
//            if (size< jaggedArray.getLength()){
//                size= jaggedArray.getLength();
//            }else {
//
//            }

        }
    }

}
