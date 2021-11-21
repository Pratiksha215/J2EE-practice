<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="css/style2.css">

<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">

	<link rel="stylesheet" type="text/css" href="css/util.css">

<meta charset="ISO-8859-1">
<title>Admin Home Page</title>
</head>

<%

		session.getAttribute("username");


%>

<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li class="active"><a href="/Home">Home</a></li>
      <li><a href="/AddProduct">Add Product</a></li>
      <li><a href="/listProducts">View Product</a></li>
   
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/AdminLogin"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>

	</br></br></br></br></br></br></br>
<div class="main">

        <section class="signup">
            <!-- <img src="images/signup-bg.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                    <form method="POST" id="signup-form" class="signup-form" action ='PoliceLogin' onsubmit="return validate()">
                        <div class = "form-group" align = 'center'><h1>Online Shopping System</h1></div>
                       
                       </br>
                        <a href="/AddProduct" id="submit-file" class="btn btn-success btn-lg">Add New Product</a>
                        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                        
                     	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                       <a href="/listProducts" id="submit-file" class="btn btn-warning btn-lg">View Uploaded Products</a> 
                        
                        </br>
                    </form>
                   
                </div>
            </div>
        </section>

    </div>


</br></br></br></br></br></br></br></br></br></br>

</body>
</html>