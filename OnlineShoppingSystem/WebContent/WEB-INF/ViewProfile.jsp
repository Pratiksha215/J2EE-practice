<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

    <!-- Main css -->

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
  
    <style>
    body {margin:0;}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
  
}

li {
  float: left;
}

li a, .dropbtn {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 8px 16px;
  text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
  background-color: #1DCB7B;
   text-decoration: none;
  
}


</style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li><a href="/Home">Home</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>
</br></br>

<div class="main">

        <section class="signup">
            <!-- <img src="images/signup-bg.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                    <form method="post" action="" id="signup-form" class="signup-form" >
                      <%
		
			int id = 2;
            String sid;
            
         //   Class.forName("com.mysql.cj.jdbc.Driver"); 
    	//	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Online_Donation_System","root","");
          //  sid = request.getParameter("id");
          //  id = Integer.parseInt(sid);
		//	PreparedStatement ps=con.prepareStatement("SELECT * FROM user where id='"+id+"'");
		//	ResultSet rs=ps.executeQuery();
		//	while(rs.next())
			{
			%>
			<input type="hidden" name="id" value="">
                        <div class="form-group row">
		<label class="col-sm-2 col-form-label">First Name</label>
	   <div class="col-sm-5">	<input type="text" class="form-control" disabled name="first_name" value="${user.first_name}">
		</div>
		</div>
		
		<div class="form-group row">
		<label class="col-sm-2 col-form-label">Last Name</label>
	   <div class="col-sm-5">	<input type="text" class="form-control" disabled name="last_name" value='${user.last_name}'>
		</div>
		</div>
		
		
		<div class="form-group row">
		<label class="col-sm-2 col-form-label">Mobile Number</label>
	   <div class="col-sm-5">	<input type="text" class="form-control" disabled name="mobile_number" value="${user.mobile_number}">
		</div>
		</div>
		<div class="form-group row">
		<label class="col-sm-2 col-form-label">Email ID</label>
	   <div class="col-sm-5">	<input type="text" class="form-control" disabled name="email_id" value="${user.email_id}">
		</div>
		</div>
		
		<%
					//  session.setAttribute("username", rs.getString("username"));
			}
		%>

				
				<a href="/ReceiveProducts" class="btn btn-primary">Back</a>
				<p></br></p>
                    </form>
                   
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>

