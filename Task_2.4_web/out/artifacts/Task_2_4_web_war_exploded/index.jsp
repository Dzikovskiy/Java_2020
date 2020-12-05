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
<% String msg = (String) request.getAttribute("message");
    if (msg!=null) {
        out.println(msg);
    }

%>
</body>
</html>
