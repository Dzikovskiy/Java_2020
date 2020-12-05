package by.training.task2_4.controller;

import by.training.task2_4.bean.DevicesBean;
import by.training.task2_4.service.DomParser;
import by.training.task2_4.service.XMLValidator;
import by.training.task2_4.view.DevicePrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VerifyServlet extends HttpServlet {
    DomParser domParser = new DomParser();
    DevicePrinter devicePrinter = new DevicePrinter();
    Logger logger = LogManager.getLogger();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (XMLValidator.validateXMLSchema("C:\\projects\\Java_2020\\Task_2.4_web\\out\\artifacts\\Task_2_4_web_war_exploded\\WEB-INF\\classes\\devices.xsd", DevicesBean.getXmlPath())) {
            request.setAttribute("message", "Xml document is correct");
            logger.debug("xml verified");
        } else {
            request.setAttribute("message", "Error while verifying");
            logger.debug("xml not verified");
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}