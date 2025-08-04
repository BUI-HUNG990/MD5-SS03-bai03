<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin sinh viên</title>
</head>
<body>
<h2>Nhập thông tin sinh viên</h2>
<form action="/StudentServlet" method="post">
    <p style="color:red;">
        ${errorMessage != null ? errorMessage : ""}
    </p>
    Họ tên: <input type="text" name="name"/><br/><br/>
    Tuổi: <input type="text" name="age"/><br/><br/>
    Địa chỉ: <input type="text" name="address"/><br/><br/>
    <input type="submit" value="Gửi thông tin"/>
</form>
</body>
</html>
