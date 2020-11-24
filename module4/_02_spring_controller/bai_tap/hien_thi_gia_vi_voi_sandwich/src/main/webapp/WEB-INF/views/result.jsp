<%--
  Created by IntelliJ IDEA.
  User: Hoang Tu
  Date: 23/11/2020
  Time: 4:30 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<c:forEach var="result" items="${condiment}">
    <h2>${result}</h2>
</c:forEach>
</body>
</html>
