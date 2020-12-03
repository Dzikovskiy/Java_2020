package by.training.task2_4;

import by.training.task2_4.entity.Device;
import by.training.task2_4.entity.PeripheralType;
import by.training.task2_4.entity.Type;
import by.training.task2_4.service.XMLValidator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(XMLValidator.validateXMLSchema("src/main/resources/devices.xsd","src/main/resources/devices.xml"));


        ArrayList<Type> types = new ArrayList<>();
        Type per = PeripheralType.builder().isPeripheral(true).name("perphery").build();
        types.add(per);

        Device device = Device.builder().name("gtx570").price(100).types(types).build();
        System.out.println(device);

    }
}
