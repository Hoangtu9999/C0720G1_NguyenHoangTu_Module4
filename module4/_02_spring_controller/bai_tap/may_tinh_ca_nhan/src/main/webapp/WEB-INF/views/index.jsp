<%--
  Created by IntelliJ IDEA.
  User: Hoang Tu
  Date: 23/11/2020
  Time: 4:03 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Trang chủ</title>
</head>
<body>
<form action="/calculate" method="get">
    <input type="text" name="number1">
    <input type="text" name="number2">

    <input type="submit" name="calculate" value="+">
    <input type="submit" name="calculate" value="-">
    <input type="submit" name="calculate" value="*">
    <input type="submit" name="calculate" value="/">
</form>

<c:if test="${result != null}">
    <h2>${result}</h2>
</c:if>

</body>
</html>
