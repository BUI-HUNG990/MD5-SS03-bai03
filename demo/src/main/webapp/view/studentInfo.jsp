<%@ page import="com.example.demo.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin đã nhập</title>
</head>
<body>
<h2>Thông tin sinh viên</h2>
<%
    Student student = (Student) request.getAttribute("student");
    if (student != null) {
%>
Họ tên: <%= student.getName() %><br/>
Tuổi: <%= student.getAge() %><br/>
Địa chỉ: <%= student.getAddress() %><br/>
<%
    }
%>
<a href="view/studentForm.jsp">Quay lại</a>
</body>
</html>
