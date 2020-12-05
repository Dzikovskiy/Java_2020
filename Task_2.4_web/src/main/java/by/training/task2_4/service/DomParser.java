package by.training.task2_4.service;

import by.training.task2_4.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser {
    private static Logger logger = LogManager.getLogger();

    public List<Device> parseDevices(String xmlPath) throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Device> devices = new ArrayList<>();
        Device device;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File(xmlPath));
        logger.debug("Xml loaded: "+xmlPath);

        NodeList nodeList = document.getElementsByTagName("device");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            logger.debug("Device " +i+" parsing started");

            device = Device.builder().id(Integer.parseInt(node.getAttributes().item(0).getNodeValue())).build();

            Element element = (Element) node;

            device.setName(element.getElementsByTagName("name").item(0).getTextContent());
            device.setOrigin(element.getElementsByTagName("origin").item(0).getTextContent());
            device.setPrice(Integer.parseInt(element.getElementsByTagName("price").item(0).getTextContent()));
            device.setCritical(Boolean.parseBoolean(element.getElementsByTagName("critical").item(0).getTextContent()));
            device.setManufactureDate(element.getElementsByTagName("manufacture-date").item(0).getTextContent());

            //creates list of types of the device
            NodeList types = ((Element) node).getElementsByTagName("type");
            ArrayList<Type> typeArrayList = new ArrayList<>();
            for (int j = 0; j < types.getLength(); j++) {
                //get j type
                Element type = (Element) types.item(j);
                //get subtype of type
                Node subType = type.getFirstChild().getNextSibling();

                switch (subType.getNodeName()) {
                    case "group":
                    case "port":
                        typeArrayList.add(new Type(subType.getTextContent().trim()));
                        break;
                    case "power":
                        typeArrayList.add(new PowerType("power", Integer.parseInt(subType.getTextContent().trim())));
                        break;
                    case "fan":
                        typeArrayList.add(new FanType("fan", Boolean.parseBoolean(subType.getTextContent().trim())));
                        break;
                    case "peripheral":
                        typeArrayList.add(new PeripheralType("peripheral", Boolean.parseBoolean(subType.getTextContent().trim())));
                        break;
                    default:
                        break;
                }
            }
            device.setTypes(typeArrayList);

            devices.add(device);
            logger.debug("Device " +i+" parsed successfully");
        }


        return devices;
    }
}
