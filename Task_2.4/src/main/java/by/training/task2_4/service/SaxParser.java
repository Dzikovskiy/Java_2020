package by.training.task2_4.service;

import by.training.task2_4.entity.Device;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SaxParser {
    ArrayList<Device> devices = new ArrayList<>();
    Device device;

    public List<Device> parseDevices(String xmlPath){
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
        private String name, job, lastElementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("device")){
               device = Device.builder().id( Integer.parseInt(attributes.getValue("id"))).build();
            }
            lastElementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {

        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("device")) {
                devices.add(device);
            }
        }
    }
}
