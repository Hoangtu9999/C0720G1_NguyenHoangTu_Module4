<%--
  Created by IntelliJ IDEA.
  User: Hoang Tu
  Date: 24/11/2020
  Time: 10:17 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>

    <meta charset="UTF-8">

    <title>Upload Result</title>

</head>

<body>

<jsp:include page="_menu.jsp"/>

<h3>Uploaded Files:</h3>

Description: ${description}

<br/>

<c:forEach items="${uploadedFiles}" var="file">

    - ${file} <br>

</c:forEach>

</body>

</html>