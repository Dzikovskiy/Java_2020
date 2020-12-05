package by.training.task2_4.controller;

import by.training.task2_4.bean.DevicesBean;
import by.training.task2_4.entity.Device;
import by.training.task2_4.service.SaxParser;
import by.training.task2_4.view.DevicePrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SaxServlet extends HttpServlet {
    SaxParser saxParser = new SaxParser();
    DevicePrinter devicePrinter = new DevicePrinter();
    Logger logger = LogManager.getLogger();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DevicesBean.setDevices((ArrayList<Device>) saxParser.parseDevices(DevicesBean.getXmlPath()));
        request.setAttribute("message", "Sax parsed");
        request.setAttribute("devices", DevicesBean.getDevices());

        logger.debug("Devices parsed with sax");

        devicePrinter.printDevices(DevicesBean.getDevices());

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}