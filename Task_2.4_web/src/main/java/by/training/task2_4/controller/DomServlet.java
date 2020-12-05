package by.training.task2_4.controller;

import by.training.task2_4.bean.DevicesBean;
import by.training.task2_4.entity.Device;
import by.training.task2_4.service.DomParser;
import by.training.task2_4.view.DevicePrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class DomServlet extends HttpServlet {
    DomParser domParser = new DomParser();
    DevicePrinter devicePrinter = new DevicePrinter();
    Logger logger = LogManager.getLogger();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            DevicesBean.setDevices((ArrayList<Device>) domParser.parseDevices(DevicesBean.getXmlPath()));
            request.setAttribute("message", "Dom parsed");

            logger.debug("Devices parsed with dom");

            devicePrinter.printDevices(DevicesBean.getDevices());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}