package by.training.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatrixConfigReaderImpl implements MatrixConfigReader {
    private static final List<Integer> list = new ArrayList<>();
    private String PATH_TO_FILE = "src/main/resources/threadConfig";
    private Logger logger = LogManager.getLogger();

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
     * method that reads matrix size and quantity of threads separated by ","
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
            logger.debug("Values red form file: " + list.get(0) + " " + list.get(1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPATH_TO_FILE() {
        return PATH_TO_FILE;
    }

    public void setPATH_TO_FILE(String PATH_TO_FILE) {
        this.PATH_TO_FILE = PATH_TO_FILE;
    }
}
