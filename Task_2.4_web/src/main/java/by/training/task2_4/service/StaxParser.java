package by.training.task2_4.service;

import by.training.task2_4.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StaxParser {
    private static Logger logger = LogManager.getLogger();
    private ArrayList<Device> devices = new ArrayList<>();
    private ArrayList<Type> types = new ArrayList<>();
    private Device device;
    private Type type;
    private boolean bName, bOrigin, bPrice, bCritical, bManufactureDate;
    private boolean bGroup, bPort, bPower, bFan, bPeripheral;


    public List<Device> parseDevices(String xmlPath) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader =
                    factory.createXMLEventReader(new FileReader(xmlPath));
            logger.debug("Xml loaded: "+xmlPath);
            devices = new ArrayList<>();

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                switch (event.getEventType()) {

                    case XMLStreamConstants.START_ELEMENT:

                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();

                        if (qName.equalsIgnoreCase("device")) {
                            logger.debug("Device parsing started");
                            types = new ArrayList<>();

                            Iterator<Attribute> attributes = startElement.getAttributes();
                            String id = attributes.next().getValue();

                            device = Device.builder().id(Integer.parseInt(id)).types(types).build();
                        }
                        if (qName.equalsIgnoreCase("name")) {
                            bName = true;
                        }
                        if (qName.equalsIgnoreCase("origin")) {
                            bOrigin = true;
                        }
                        if (qName.equalsIgnoreCase("price")) {
                            bPrice = true;
                        }
                        if (qName.equalsIgnoreCase("critical")) {
                            bCritical = true;
                        }
                        if (qName.equalsIgnoreCase("manufacture-date")) {
                            bManufactureDate = true;
                        }
                        if (qName.equalsIgnoreCase("group")) {
                            bGroup = true;
                        }
                        if (qName.equalsIgnoreCase("port")) {
                            bPort = true;
                        }
                        if (qName.equalsIgnoreCase("power")) {
                            bPower = true;
                        }
                        if (qName.equalsIgnoreCase("fan")) {
                            bFan = true;
                        }
                        if (qName.equalsIgnoreCase("peripheral")) {
                            bPeripheral = true;
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();

                        if (bName) {
                            device.setName(characters.getData());
                            bName = false;
                        }
                        if (bOrigin) {
                            device.setOrigin(characters.getData());
                            bOrigin = false;
                        }
                        if (bPrice) {
                            device.setPrice(Integer.parseInt(characters.getData()));
                            bPrice = false;
                        }
                        if (bCritical) {
                            device.setCritical(Boolean.parseBoolean(characters.getData()));
                            bCritical = false;
                        }
                        if (bManufactureDate) {
                            device.setManufactureDate(characters.getData());
                            bManufactureDate = false;
                        }
                        if (bGroup) {
                            type = new Type(characters.getData().trim());
                            types.add(type);
                            bGroup = false;
                        }
                        if (bPort) {
                            type = new Type(characters.getData().trim());
                            types.add(type);
                            bPort = false;
                        }
                        if (bPower) {
                            type = new PowerType("power", Integer.parseInt(characters.getData().trim()));
                            types.add(type);
                            bPower = false;
                        }
                        if (bFan) {
                            type = new FanType("fan", Boolean.parseBoolean(characters.getData().trim()));
                            types.add(type);
                            bFan = false;
                        }
                        if (bPeripheral) {
                            type = new PeripheralType("peripheral", Boolean.parseBoolean(characters.getData().trim()));
                            types.add(type);
                            bPeripheral = false;
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();

                        if (endElement.getName().getLocalPart().equalsIgnoreCase("device")) {
                            devices.add(device);
                            logger.debug("Device parsed successfully");
                        }
                        break;
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }

        return devices;
    }


}
