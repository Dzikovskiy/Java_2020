<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h3>File Upload:</h3>
Select a file to upload: <br/>
<form action="UploadServlet" method="post"
      enctype="multipart/form-data">
    <input type="file" name="file" size="50"/>
    <br/>
    <input type="submit" value="Upload File"/>
</form>


<form action="DomServlet" method="post">
    <input type="submit" value="dom parser" />
</form>


<form action="SaxServlet" method="post">
    <input type="submit" value="sax parser"/>
</form>

<form action="StaxServlet" method="post">
    <input type="submit" value="stax parser"/>
</form>


<% String msg = (String) request.getAttribute("message");
    if (msg != null) {
        out.println(msg);
    }
%>
</body>
</html>
