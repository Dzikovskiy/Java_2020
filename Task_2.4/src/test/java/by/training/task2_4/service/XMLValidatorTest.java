package by.training.task2_4.service;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.testng.Assert.*;

public class XMLValidatorTest {

    @Test
    public void testValidateXMLSchema() {
        //given
        String xmlFile = "devices.xml";
        String xsdFile = "devices.xsd";
        boolean isCorrect = false;
        try (InputStream input = XMLValidatorTest.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            //load a properties file from class path
            prop.load(input);
            xmlFile = prop.getProperty("xmlFileName");
            xsdFile = prop.getProperty("xsdFileName");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        isCorrect =  XMLValidator.validateXMLSchema(xsdFile, xmlFile);

        assertTrue(isCorrect);

    }
}