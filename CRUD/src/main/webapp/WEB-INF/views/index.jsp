<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file = "./base.jsp" %>
</head>
<body>

<div class="container mt-3">
    <div class="row">
        <div class="col-md-12">
            <h1 class="text-center mb-5">Welcome to Product App</h1>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">S.No</th>
                        <th scope="col">Name</th>
                        <th scope="col">Description</th>
                        <th scope="col">Price</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${products}">
                        <tr>
                            <th scope="row">${product.id}</th>
                            <td>${product.name}</td>
                            <td>${product.description}</td>
                            <td>${product.price}</td>
                            <td>
                                <a href="edit/${product.id}" class="btn btn-warning btn-sm">Edit</a>
                                <a href="delete/${product.id}" class="btn btn-danger btn-sm">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="container text-center">
                <a href="${pageContext.request.contextPath}/add-product" class="btn btn-outline-success">Add Product</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>
