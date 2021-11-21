
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Online Shopping System</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
  		    <link rel="stylesheet" href="css/style3.css">
  


   
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script> 
     
    <style>


    
    body {margin:0;
    
    }
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
  
}

li {
  float: right;
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
<ul>
	<li><a href="/" >Logout</a></li>
   <li><a href="/ReceiveProducts" >Home</a></li>
</ul>

</br></br>
<div class="container-login100" style="background-image: url('images/backg.jpg');">
<div class="main">

        <section class="signup">
            <!-- <img src="images/signup-bg.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content ">
                    <form id="signup-form" class="signup-form" method="POST" action="/saveCart" >
              
			<input type="hidden" name="id" value="${product.id}">
			<input type="hidden" name="product_name" value="${product.product_name}">
			<input type="hidden" name="product_info" value="${product.product_info}">
			<input type="hidden" name="product_photo" value="${product.product_photo}">
			
                        <div class="form-group row">
		<h5 class="col-sm-2">Product Name</h5>
	   <div class="col-sm-5">	<input type="text" class="form-control" disabled  value="${product.product_name }">
		</div>
		</div>
		</br>
	      	<div class="form-group row">
		<h5 class="col-sm-2">Product Description</h5>
	   <div class="col-sm-5">	<input type="text" class="form-control" disabled  value="${product.product_info }">
		</div>
		</div>
		</br>
		<div class="form-group row">
		<h5 class="col-sm-2">Product Price</h5>
	   <div class="col-sm-5">	<input type="text" class="form-control" name="id" disabled  value="${product.product_price }" >
	   							<input type="hidden" name="product_price" value="${product.product_price }">
		</div>
		</div>
		</br>
		<div class="form-group row">
		<h5 class="col-sm-2">Product Quantity</h5>
	   <div class="col-sm-5">	<input type="text" class="form-control" disabled  value="${product.product_quantity }">
		</div>
		</div>
		
</br>
	   <div align="center">
	    <img  src="data:image/jpeg;base64,${product.product_photo}" style="width: 400px;height: 400px;" class="border border-dark rounded" alt="Getting Error While Loading Product Image"> 
	    <h5>Product Image</h5>							
	   </div>
             </br>     
      <div class="form-group row">
		<h5 class="col-sm-2">Enter Quantity</h5>
	   <div class="col-sm-5">	<input type="text" class="form-control" name = "product_quantity">
		</div>
		</div>          
                   	</br>				
				<input type="submit" class="btn btn-success" value="Add to Cart" />
				
				 <a href="/ReceiveProducts" class="btn btn-dark">Back</a>
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

