<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored = "false"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uploaded sucessfully</title>
</head>
<body>
<h1> ${msg }
</h1>

<img alt="image" src="<c:url value="/resources/${fname}" />" />

</body>
</html>