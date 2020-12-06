package by.training.task2_4.service;

import by.training.task2_4.entity.Device;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class DomParserTest {

    @Test
    public void testParseDevices() {
        DomParser domParser = new DomParser();
        //given
        String xmlFile = "devices.xml";
        boolean isCorrect = false;
        try (InputStream input = XMLValidatorTest.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            //load a properties file from class path
            prop.load(input);
            xmlFile = prop.getProperty("xmlFileName");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        ArrayList<Device> devicesDom = new ArrayList<>();
        try {
             devicesDom = (ArrayList<Device>) domParser.parseDevices(xmlFile);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        ArrayList<Device> devicesTest = new ArrayList<>();
        devicesTest.add(Device.builder().id(1).name("gtx1070").build());
        devicesTest.add(Device.builder().id(2).name("gtx570").build());

        Assert.assertEquals(devicesDom.size(),devicesTest.size());
        Assert.assertEquals(devicesDom.get(0).getId(),devicesTest.get(0).getId());
        Assert.assertEquals(devicesDom.get(0).getName(),devicesTest.get(0).getName());

    }
}