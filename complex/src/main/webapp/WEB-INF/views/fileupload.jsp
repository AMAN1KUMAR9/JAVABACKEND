<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en" dir="ltr">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Standard Bootstrap CSS (LTR) -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" integrity="sha384-ZeGx9hZbV8ehfjmRHdYos9Lbc1W5qA8uKhc7AlTUnRHyM/MeF9Ra7p7piwFEO3X5" crossorigin="anonymous">
    <title>Hello, World!</title>
  </head>
  <body>
    <div class = "container ">
  
   <form action="upload" method="post" enctype="multipart/form-data">
    <input class="form-control" type="file" id="formFile" name="formupload">
    <button class="btn btn-outline-success" type="submit">Upload</button>
</form>


    </div>
    <!-- Optional JavaScript; Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>
