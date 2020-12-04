package by.training.task2_4;

import by.training.task2_4.entity.Device;
import by.training.task2_4.entity.PeripheralType;
import by.training.task2_4.entity.Type;
import by.training.task2_4.service.DomParser;
import by.training.task2_4.service.XMLValidator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        System.out.println(XMLValidator.validateXMLSchema("src/main/resources/devices.xsd","src/main/resources/devices.xml"));


        ArrayList<Type> types = new ArrayList<>();
        Type per = PeripheralType.builder().isPeripheral(true).name("perphery").build();
        types.add(per);

        Device device = Device.builder().name("gtx570").price(100).types(types).build();
        System.out.println(device);

        DomParser parser = new DomParser();
       ArrayList<Device> devices = parser.parseDevices("src/main/resources/devices.xml");

        System.out.println(devices.size());
        devices.forEach(System.out::println);
    }
}
