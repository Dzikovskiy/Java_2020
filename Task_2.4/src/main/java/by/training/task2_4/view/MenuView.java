package by.training.task2_4.view;

import by.training.task2_4.entity.Device;
import by.training.task2_4.service.DomParser;
import by.training.task2_4.service.SaxParser;
import by.training.task2_4.service.XMLValidator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuView {
    private final Scanner scanner = new Scanner(System.in);
    private final String XMLPath = "src/main/resources/devices.xml";
    private final String XSDPath = "src/main/resources/devices.xsd";
    DomParser domParser = new DomParser();
    SaxParser saxParser = new SaxParser();
    ArrayList<Device> devices = new ArrayList<>();

    public void menu()  {
        while (true) {
            System.out.println("\n1. Verify xml by xsd");
            System.out.println("2. Create Array from file");
            System.out.println("3. Create Array from random numbers");
            System.out.println("4. Print Array");
            System.out.println("5. exit");

            switch (scanner.nextInt()) {
                case 1:
                    if (XMLValidator.validateXMLSchema(XSDPath, XMLPath)) {
                        System.out.println("Xml document is correct");
                    } else {
                        System.out.println("Error while verifying");
                    }
                    break;
                case 2:
                    try {
                         devices = (ArrayList<Device>) domParser.parseDevices(XMLPath);

                    } catch (ParserConfigurationException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (SAXException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Xml has been parsed with DOM correctly");
                    break;
                case 3:
                    devices = (ArrayList<Device>) saxParser.parseDevices(XMLPath);
                    System.out.println("Xml has been parsed with SAX correctly");
                    break;
                case 4:

                    break;
                case 5:
                    return;
                default:
                    System.out.println("Wrong command !");
                    break;
            }
        }
    }
}
