package by.training.task4;

import by.training.task4.entity.Array;
import by.training.task4.service.ArrayService;
import by.training.task4.view.ArrayView;

import java.io.File;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        ArrayService arrayService = new ArrayService();
        Array a = new Array();
        arrayService.fillArrayFromFile(a);
        System.out.println(a);
    }
}
