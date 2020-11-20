<%--
  Created by IntelliJ IDEA.
  User: Hoang Tu
  Date: 20/11/2020
  Time: 4:19 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Result</title>
</head>
<body>

<c:if test="${result != null}">
    <h3>Result:${result}</h3>
</c:if>

</body>
</html>
