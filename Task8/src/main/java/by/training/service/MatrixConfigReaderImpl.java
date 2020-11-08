package by.training.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatrixConfigReaderImpl implements MatrixConfigReader {
    private static final List<Integer> list = new ArrayList<>();
    String PATH_TO_FILE = "src/main/resources/threadConfig";

    public MatrixConfigReaderImpl() {
        readValues();
    }

    @Override
    public int threadValue() {
        return list.get(1);
    }

    @Override
    public int matrixSize() {
        return list.get(0);
    }

    /**
     * method that reads matrix size and quantity of by.training.threads separated by ","
     */
    @Override
    public void readValues() {
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(PATH_TO_FILE)));
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                for (String s : split) {
                    list.add(Integer.parseInt(s));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
