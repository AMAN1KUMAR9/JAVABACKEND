<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>about</title>
</head>
<body>
<h1>about</h1>
<%
Integer id = (Integer)request.getAttribute("id");

%>

<h1>
<%= id
%>
</h1>
</body>
</html>