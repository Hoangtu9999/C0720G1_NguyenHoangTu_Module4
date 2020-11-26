<%--
  Created by IntelliJ IDEA.
  User: Hoang Tu
  Date: 24/11/2020
  Time: 3:13 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<p style="color: limegreen">${message}</p>--%>
<form:form action="create" method="get" modelAttribute="emailObj">
    <form:label path="languages">Languages:</form:label>
    <form:select path="languages">
        <form:option value="">----Languages-----</form:option>
        <form:option value="English">English</form:option>
        <form:option value="Vietnamese">Vietnamese</form:option>
        <form:option value="Chinese">Chinese</form:option>
        <form:option value="Thai">Thai</form:option>
    </form:select>
    </br>
    <form:label path="pageSize">Page Size</form:label>
    <form:select path="pageSize">
        <form:option value="25">--------------</form:option>
        <form:option value="25">25</form:option>
        <form:option value="50">50</form:option>
        <form:option value="75">75</form:option>
        <form:option value="100">100</form:option>
    </form:select>
    </br>
    <form:label path="spamsFilter">Spams Filter</form:label>
    <form:checkbox path="spamsFilter" value="true"></form:checkbox>
    </br>
    <form:label path="signature">Signature</form:label>
    <form:textarea path="signature"></form:textarea>
    </br>
    <form:button value="update">update</form:button>

</form:form>

</body>
</html>
