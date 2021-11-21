<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>College</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
    
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">
     
    <style>
    
    body {margin:0;}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
  
}

.active {
  background-color: #4CAF50;
}

li {
  float: Right;
}

li a, .dropbtn {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 12px 16px;
  text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
  background-color: #1DCB7B;
  text-decoration: none;
  
}

#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
  margin-left: auto;
  margin-right: auto;
  
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 10px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}



</style>
  
<script type="text/javascript">
	function validate() {

		if (document.getElementById("username").value == "") {
			alert("username should not be blank");
			document.getElementById("username").focus();
			return false;
		}
		if (document.getElementById("password").value == "") {
			alert("password should not be blank");
			document.getElementById("password").focus();
			return false;
		}
	}
</script>

<%

	if (request.getParameter("success") != null) {
		out.println("<script>alert('Registration Successful')</script>");
		}
	if (request.getParameter("failed") != null) {
		out.println("<script>alert('Invalid Username or password')</script>");
	}
%>
</head>
<body>

<ul>
  <li><a href="/AdminLogin" >Admin Portal</a></li>
   <li><a href="/register" >Register</a></li>
   <li><a href="/"  class='active'>Home</a></li>
</ul>
<div class="container-login100" style="background-image: url('images/backg.jpg');">

<div class="main">

        <section class="signup">
            <!-- <img src="images/signup-bg.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                    <form method="POST" id="signup-form" class="signup-form" action ='/login' onsubmit="return validate()">
                        <div class = "form-group" align = 'center'><h3>User   Login</h3></div>
                        
                        <div class="form-group">
                            <input type="text" class="form-input" name="username" id="email" placeholder="User Name" required/>
                        </div>
                       
                        <div class="form-group">
                            <input type="password" class="form-input" name="password" id="password" placeholder="Password" required/>
                           
                        </div>
                       
                        
                        <div class="submit1">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="LOGIN"/>
                        </div>
                        </br>
                    </form>
                   
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
    </div>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>