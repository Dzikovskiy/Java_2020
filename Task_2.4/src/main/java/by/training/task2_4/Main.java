package by.training.task2_4;

import by.training.task2_4.service.XMLValidator;

public class Main {
    public static void main(String[] args) {
        System.out.println(XMLValidator.validateXMLSchema("src/main/resources/devices.xsd","src/main/resources/devices.xml"));

    }
}
