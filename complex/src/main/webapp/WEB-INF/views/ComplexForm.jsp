<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
          crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value="/resources/css/hey.css" />">


    <title>Hello, world!</title>
</head>
<body> <!-- style="background: #e2e2e2;" --> 

<div class="container mt-4">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body">
                    <h3 class="text-center">Complex Form</h3>
                    <div class = "alert alert-danger" role= "alert" >
                    <form:errors path = "com.*"/>
                    </div>
                    

                    <form action="handle" method="post">
                        <div class="form-group">
                            <label for="exampleInputName">Your Name</label>
                            <input name="name" type="text" class="form-control" id="exampleInputName" placeholder="Enter Name">
                        </div>

                        <div class="form-group">
                            <label for="exampleInputId">Your Id</label>
                            <input name="id" type="text" class="form-control" id="exampleInputId" placeholder="Enter ID">
                        </div>

                        <div class="form-group">
                            <label for="exampleInputDOB">Your DOB</label>
                            <input name="date" type="text" class="form-control" id="exampleInputDOB" placeholder="dd/mm/yyyy">
                        </div>

                        <div class="form-group">
                            <label for="exampleFormControlSelect1">Select Courses</label>
                            <select name="subjects" class="form-control" id="exampleFormControlSelect1" multiple>
                                <option>Java</option>
                                <option>Python</option>
                                <option>C++</option>
                                <option>Spring</option>
                                <option>Hibernate</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <span class="mr-3">Select Gender</span>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="male">
                                <label class="form-check-label" for="inlineRadio1">Male</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" id="inlineRadio2" value="female">
                                <label class="form-check-label" for="inlineRadio2">Female</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="typeSelect">Select Type</label>
                            <select class="form-control" name="type" id="typeSelect">
                                <option value="oldstudent">Old Student</option>
                                <option value="normalstudent">Normal Student</option>
                            </select>
                        </div>

                        <div class="card">
                            <div class="card-body">
                                <p>Address</p>
                                <div class="form-group">
                                    <input class="form-control" type="text" placeholder="Enter Street" name = "address.street"/>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="text" placeholder="Enter City" name = "address.city"/>
                                </div>
                            </div>
                        </div>

                        <div class="text-center mt-3">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

<!-- Optional JavaScript; choose one of the two! -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
        crossorigin="anonymous"></script>
</body>
</html>
