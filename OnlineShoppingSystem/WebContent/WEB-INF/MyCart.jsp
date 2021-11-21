<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>

   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
  </head>
 
  
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
  width: 90%;
  margin-left: 5%;
  margin-right: 5%;
  
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
 
}



</style>
  <body>
<ul>
<li><a href="/" >Logout</a></li>
  <li><a href="/ReceiveProducts" >Home</a></li>
    
  
</ul>
	</br>
		<div class="col-12">
			 <form id="signup-form" class="signup-form" method="POST" action="/PaymentPage" >
     <h3 class="text-center">My Cart</h3>
			<hr>

       	<hr>
			<table class="table" id ="customers">
				<thead class="thead-dark">
					<tr>
						<th scope="col" class = "text-center">IMAGE</th>
						<th scope="col">NAME</th>
						<th scope="col">DESCRIPTION</th>
						<th scope="col">PRICE</th>
						<th scope="col">QUANTITY</th>
						<th scope="col" class = "text-center">TOTAL</th>
					</tr>
				</thead>
				<tbody id="myTable">
				 <c:forEach items="${products}" var="product" varStatus="status">
					<tr>
						<th scope="row" class = "text-center"><img alt="" src="data:image/jpeg;base64,${product.product_photo}" style="width: 200px;height: 200px;" class="border border-dark rounded"></th>
						<td>${product.product_name}
						</td>
						<td>${product.product_info} 
						
						</td>
						<td>${product.product_price}
							
						</td>
						<td>${product.product_quantity}
							
						</td>
						<td>${product.product_total} </td>
					</tr>
					 </c:forEach>
				</tbody>
			</table>
			<hr>
			
			        </br>     
      <div class="form-group row customers">
		&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<h5>Total Amount</h5>
	   <div class="col-sm-1">	<input type="text" id="total" class="form-control" disabled>
	   <input type="hidden" id="sum" name = "product_total">
		</div>
		</div>          
                   	</br>				
			 &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;	<input type="submit" class="btn btn-success" value="Procced for Payment" />
				&emsp;
				 <a href="/ReceiveProducts" class="btn btn-dark">Back</a>
				 </form>
		</div>
		
		    <script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
  <script>
            
            var table = document.getElementById("customers"), sumVal = 0;
            
            for(var i = 1; i < table.rows.length; i++)
            {
                sumVal = sumVal + parseInt(table.rows[i].cells[5].innerHTML);
            }
            
            document.getElementById("total").value = sumVal;
            document.getElementById("sum").value = sumVal;
            console.log(sumVal);
            
        </script>
		</body>
  </html>
