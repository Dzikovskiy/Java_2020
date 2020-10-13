package by.training.task5.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileService {
    public String readTextFromFile() {
        String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get("text.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void writeTextToFile(String text) {
        try {
            Files.write(Paths.get("output.txt"), text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
