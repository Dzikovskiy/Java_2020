package by.training.task2_4.service;

import by.training.task2_4.entity.Device;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class SaxParserTest {

    @Test
    public void testParseDevices() {
        SaxParser saxParser = new SaxParser();
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

        ArrayList<Device> devicesSax = new ArrayList<>();
        devicesSax = (ArrayList<Device>) saxParser.parseDevices(xmlFile);

        ArrayList<Device> devicesTest = new ArrayList<>();
        devicesTest.add(Device.builder().id(1).name("gtx1070").build());
        devicesTest.add(Device.builder().id(2).name("gtx570").build());

        Assert.assertEquals(devicesSax.size(),devicesTest.size());
        Assert.assertEquals(devicesSax.get(0).getId(),devicesTest.get(0).getId());
        Assert.assertEquals(devicesSax.get(0).getName(),devicesTest.get(0).getName());

    }
}