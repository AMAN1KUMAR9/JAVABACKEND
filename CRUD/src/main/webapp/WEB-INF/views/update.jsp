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
        <div class="col-md-6 offset-md-3">
            <h1 class="text-center mb-3">Update the product detail</h1>
            <form action="handle-product" method="post">
                <!-- Visible field for Product ID (Read-Only) -->
                <%-- <div class="form-group">
                    <label for="id">Product ID</label>
                    <input type="text" class="form-control" id="id" name="id" value="${product.id }" readonly>
                </div> --%>

                <div class="form-group">
                    <label for="name">Product Name</label> 
                    <input type="text" class="form-control" id="name" name="name" value="${product.name }" required>
                </div>
                <div class="form-group">
                    <label for="description">Product Description</label>
                    <textarea class="form-control" name="description" id="description" rows="5">${product.description }</textarea>
                </div>
                <div class="form-group">
                    <label for="price">Product Price</label>
                    <input type="number" name="price" class="form-control" id="price" value="${product.price }" required>
                </div>
                <div class="container text-center">
                    <a href="${pageContext.request.contextPath}/" class="btn btn-outline-danger">Back</a>
                    <button type="submit" class="btn btn-primary">Update</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html> 
