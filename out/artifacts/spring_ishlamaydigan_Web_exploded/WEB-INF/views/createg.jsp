<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.06.2022
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
<form action="add" method="post" >
<pre>
    <strong>Create Here | <a href="/group/all">Click for Read</a></strong>

	Name: <input type="text" name="name"/>

	Class Id: <input type="text" name="clasId"/>

	<input type="submit" value="Saqlash"/>
</pre>
</form>
${ketmon}
</body>
</html>
