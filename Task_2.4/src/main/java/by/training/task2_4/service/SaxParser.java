package by.training.task2_4.service;

import by.training.task2_4.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SaxParser {
    ArrayList<Device> devices = new ArrayList<>();
    ArrayList<Type> types = new ArrayList<>();
    Device device;
    Type type;

    public List<Device> parseDevices(String xmlPath) {
        try {
            File inputFile = new File(xmlPath);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            AdvancedXMLHandler xmlHandler = new AdvancedXMLHandler();
            saxParser.parse(inputFile, xmlHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return devices;
    }

    private class AdvancedXMLHandler extends DefaultHandler {
        boolean bName, bOrigin, bPrice,bCritical,bManufactureDate;
        boolean bGroup,bPort,bPower,bFan,bPeripheral;

        //calls when the element tag starts
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("device")) {
                types = new ArrayList<>();
                device = Device.builder().id(Integer.parseInt(attributes.getValue("id"))).types(types).build();

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

        }

        //calls when parse text inside of the element
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                device.setName(new String(ch, start, length));
                bName = false;
            }
            if (bOrigin) {
                device.setOrigin(new String(ch, start, length));
                bOrigin = false;
            }
            if (bPrice) {
                device.setPrice(Integer.parseInt(new String(ch, start, length)));
                bPrice = false;
            }
            if (bCritical) {
                device.setCritical(Boolean.parseBoolean(new String(ch, start, length)));
                bCritical = false;
            }
            if (bManufactureDate) {
                device.setManufactureDate(new String(ch, start, length));
                bManufactureDate = false;
            }
            if (bGroup) {
                type = new Type(new String(ch, start, length).trim());
                types.add(type);
                bGroup = false;
            }
            if (bPort){
                type = new Type(new String(ch, start, length).trim());
                types.add(type);
                bPort = false;
            }
            if (bPower){
                type = new PowerType("power",Integer.parseInt(new String(ch, start, length).trim()));
                types.add(type);
                bPower = false;
            }
            if (bFan){
                type = new FanType("fan",Boolean.parseBoolean(new String(ch, start, length).trim()));
                types.add(type);
                bFan = false;
            }
            if (bPeripheral){
                type = new PeripheralType("peripheral",Boolean.parseBoolean(new String(ch, start, length).trim()));
                types.add(type);
                bPeripheral = false;
            }

        }

        //calls when the element tag is closes
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("device")) {
                devices.add(device);
            }
        }
    }
}
