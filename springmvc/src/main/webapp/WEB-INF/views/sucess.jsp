<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@page isELIgnored  = "false" %>>
<title>Insert title here</title>
</head>
<body>
<% String h = (String)request.getAttribute("hey"); %>
<h1><%=h %></h1>
<h1>${user.name}</h1>
<h1> ${user.password} </h1>
<h1>${user.email}</h1>

</body>
</html>