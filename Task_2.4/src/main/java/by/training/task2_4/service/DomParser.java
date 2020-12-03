package by.training.task2_4.service;

import by.training.task2_4.entity.Device;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DomParser {
    public ArrayList<Device> parseDevices(String xmlPath) throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Device> devices = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File("src/main/resources/devices.xml"));

        



        return devices;
    }
}
