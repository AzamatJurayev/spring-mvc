<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.06.2022
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
<p><strong>Update Here | <a href="/group/all">Click for Read</a></strong></p>
<form action="/group/update" method="post">
<pre>
<c:forEach var="group" items="${ketmon}">

    Id: <input type="number" name="id" value="${group.id}" disabled="disabled"/>
    <input type="hidden" name="id" value="${group.id}"/>
    Name: <input type="text" name="name" value="${group.name}"/>

    Class Id: <input type="text" name="clasId" value="${group.clasId}"/>

    <input type="submit" value="Update"/>
</c:forEach>
</pre>
</form>
${msg}
</body>
</html>