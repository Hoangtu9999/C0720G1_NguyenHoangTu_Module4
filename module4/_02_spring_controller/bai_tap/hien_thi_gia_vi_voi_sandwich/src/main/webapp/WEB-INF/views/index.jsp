<%--
  Created by IntelliJ IDEA.
  User: Hoang Tu
  Date: 23/11/2020
  Time: 4:03 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<html>
<head>
    <title>Trang chủ</title>
</head>
<body>
    <form action="/save" method="get">
        <label >Lettuce</label>
        <input type="checkbox" name="condiment" value="lettuce" >
        <label >Tomato</label>
        <input type="checkbox" name="condiment" value="tomato" >
        <label >Mustard</label>
        <input type="checkbox" name="condiment" value="mustard" >
        <label >Sprouts</label>
        <input type="checkbox" name="condiment" value="sprouts" >
        <hr>
        </br>
        <input type="submit" value="save">

    </form>
</body>
</html>
