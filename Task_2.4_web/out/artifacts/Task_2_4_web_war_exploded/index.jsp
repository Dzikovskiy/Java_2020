<%@ page import="by.training.task2_4.entity.Device" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="by.training.task2_4.view.DevicePrinter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <!-- Content here -->

    <h3>File Upload:</h3>
    Select a file to upload: <br/>
    <form action="UploadServlet" method="post"
          enctype="multipart/form-data" class="my-3">
        <input type="file" name="file" size="50" class="my-3"/>
        <br/>
        <input type="submit" value="Upload File" class="my-3"/>
    </form>

    <form action="DomServlet" method="post" class="my-3">
        <input type="submit" value="dom parser"/>
    </form>


    <form action="SaxServlet" method="post" class="my-3">
        <input type="submit" value="sax parser"/>
    </form>

    <form action="StaxServlet" method="post" class="my-3">
        <input type="submit" value="stax parser"/>
    </form>

    <form action="VerifyServlet" method="post" class="my-3">
        <input type="submit" value="verify by xsd"/>
    </form>


    <% String msg = (String) request.getAttribute("message");
        if (msg != null) {
            out.println(msg);
        }
    %>
    <%
        ArrayList<Device> list = (ArrayList<Device>) request.getAttribute("devices");

        if (list != null) {
            out.println("<table  class=\"my-3 table table-striped\" >");
            out.println("<thead><tr>\n" +
                    "    <th>id</th>\n" +
                    "    <th>name</th>\n" +
                    "    <th>origin</th>\n" +
                    "    <th>price</th>\n" +
                    "    <th>critical</th>\n" +
                    "    <th>manufacture date</th>\n" +
                    "    <th>types</th>\n" +
                    "  </tr> </thead><tbody>");

            for (Device device : list) {
                out.println("<tr>\n");
                out.println("<td>" + device.getId() + "</td>\n");
                out.println("<td>" + device.getName() + "</td>\n");
                out.println("<td>" + device.getOrigin() + "</td>\n");
                out.println("<td>" + device.getPrice() + "</td>\n");
                out.println("<td>" + device.isCritical() + "</td>\n");
                out.println("<td>" + device.getManufactureDate() + "</td>\n");
                out.println("<td>" + DevicePrinter.typesToString(device.getTypes()) + "</td>\n");
                out.println(" </tr>");

            }

            out.println("</tbody></table>");
        }
    %>
</div>
</body>
</html>
