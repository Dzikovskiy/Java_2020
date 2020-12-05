package by.training.task2_4.view;

import by.training.task2_4.entity.Device;
import by.training.task2_4.service.DomParser;
import by.training.task2_4.service.SaxParser;
import by.training.task2_4.service.StaxParser;
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
    StaxParser staxParser = new StaxParser();
    ArrayList<Device> devices = new ArrayList<>();
    DevicePrinter printer = new DevicePrinter();

    public void menu() {
        while (true) {
            System.out.println("\n1. Verify xml by xsd");
            System.out.println("2. DOM");
            System.out.println("3. SAX");
            System.out.println("4. STAX");
            System.out.println("5. Print");
            System.out.println("6. exit");

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
                    devices = (ArrayList<Device>) staxParser.parseDevices(XMLPath);
                    System.out.println("Xml has been parsed with STAX correctly");
                    break;
                case 5:
                    printer.printDevices(devices);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Wrong command !");
                    break;
            }
        }
    }
}
