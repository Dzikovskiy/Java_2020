package by.training.task2_4.controller;

import by.training.task2_4.bean.DevicesBean;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    private static int fileId = 1;
    private Logger logger = LogManager.getLogger();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        String name = new File(item.getName()).getName();
                        String path = "c:\\upload" + File.separator + fileId++ + name;
                        DevicesBean.setXmlPath(path);
                        item.write(new File(path));
                        logger.debug("File has been uploaded " + path);
                    }
                }
                //File uploaded successfully
                request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }
        } else {

            request.setAttribute("message", "No File found");
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }


}
