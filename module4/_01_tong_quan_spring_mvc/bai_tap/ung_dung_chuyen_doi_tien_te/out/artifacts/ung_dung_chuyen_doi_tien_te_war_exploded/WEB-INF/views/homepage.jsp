<%--
  Created by IntelliJ IDEA.
  User: Hoang Tu
  Date: 20/11/2020
  Time: 4:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>CONVERT</h2>
<form action="/convert">
    <label for="number1">USA</label>
    <input type="text" name="number1" id="number1">
    <label for="number2">VNĐ</label>
    <input type="text" name="number2" id="number2" value="23000" readonly>
    <input type="submit" value="Convert">
</form>
</body>
</html>
