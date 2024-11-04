<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Main page</h1>

<!-- Display the 'idd' attribute -->
<h1>${idd}</h1>

<!-- Loop through 'ls' attribute using JSTL -->
<c:forEach var="item" items="${ls}">
    <h1>${item}</h1>
</c:forEach>

</body>
</html>


<%-- <% 
    List<String> ls = (List<String>)request.getAttribute("ls");
    if (ls != null) {
%>
    <ul>
    <% for(String item : ls) { %>
        <li><%= item %></li>
    <% } %>
    </ul>
<% 
    } else {
%>
    <p>No items available.</p>
<% 
    }
%>
 --%>