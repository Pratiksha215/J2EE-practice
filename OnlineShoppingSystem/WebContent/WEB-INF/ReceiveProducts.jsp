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
  
<script>
var subjectObject = {
  "Maharashtra": {
    "Gudi-Padwa": ["Clothes","Jewellery","Pooja-Shahitya","Foot-wear","Beauty-products"],
    "Ganesh-Chaturthi": ["Pooja-Thali","Music Instruments","Decoration","Clothes","Decoration"],
    "Diwali": ["Clothes","Pooja-Shahitya","Sweets","Lights","fire-Crackers"],
    "Shiv-Jayanti": ["Flags","Statue","Clothes","Musical Instruments","Decoration"],
    "Holi": ["Clothes","Colour","Sweets","Pooja-Shahitya","Musical Instruments"],
    "Makar-Sankarati": ["Clothes","Sweets","Kite","Pooja-Shahitya","Jewellery"],
    "KRISHNA JANMASHTMI": ["Musical Instruments","Sweets","Clothes","Dahi-Handi products","Jewellery"],
    "Eid": ["Clothes","Sweets","Decoration","Lighting"],
    "Dusshera": ["Clothes","Pooja Sahitya","Fire-Crackers","Sticks","Decoration products"],
    "Chrismas": ["Clothes","Constume","Sweets","Decoration","Lights"]
    },
"Gujrat":
{
"Dangs Darbar Tribal Festival": ["Clothes","Musical Insruments","Musical Insruments","Jewellery","Beauty-Products","Foot-Wear"],
"Shamlaji Melo": ["Clothes","Pooja-sahitya","Jewellery","Beauty-products","Foot-Wear"],
"Rann Utsav": ["Clothes","Tents","Musical Instrument","Kite","hand-Looms"],
"Kavant Fair": ["Clothes","Musical_insruments","Colour","Foot-wear","Traditional Jewellery"],
"Janmashtami" : ["Musical Instruments","Sweets","Clothes","Dahi-Handi products","Jewellery"]
},
 "Karnataka": {
    "Ganesh-Chaturthi": ["Pooja-Thali","Music Instruments","Decoration products","Clothes","Lights"],
    "Dusshera": ["Clothes","Pooja Sahitya","Fire-Crackers","Sticks","Decoration products"],
    "Diwali": ["Fire-Crackers","Pooja-thali","Rangoli material","Sweet","Lights"],
    "Pongal": ["Poojai Items","Vegetables","Grocery","Lamps","Kolam"]
    },
    "Kerala": {
    "Onam": ["Constume","Statue","Clothes","Pooja-Sahitya","Sweets"],
    "Vishu": ["Statue","Clothes","Pooja-Sahitya","Sweets","Constume"],
    "Deepavali": ["Fire-Crackers","Pooja-thali","Rangoli material","Sweet","Lights"],
    "Chrismas": ["Cloths","Constume","Sweets","Decoration","Lights"]
    }
  }
window.onload = function() {
  var subjectSel = document.getElementById("state");
  var topicSel = document.getElementById("festival");
  var chapterSel = document.getElementById("accessories");
  for (var x in subjectObject) {
    subjectSel.options[subjectSel.options.length] = new Option(x, x);
  }
  subjectSel.onchange = function() {
    //empty Chapters- and Topics- dropdowns
    chapterSel.length = 1;
    topicSel.length = 1;
    //display correct values
    for (var y in subjectObject[this.value]) {
      topicSel.options[topicSel.options.length] = new Option(y, y);
    }
  }
  topicSel.onchange = function() {
    //empty Chapters dropdown
    chapterSel.length = 1;
    //display correct values
    var z = subjectObject[subjectSel.value][this.value];
    for (var i = 0; i < z.length; i++) {
      chapterSel.options[chapterSel.options.length] = new Option(z[i], z[i]);
    }
  }
}
</script>
  
  
  <%

	if (request.getParameter("cc_exp_mo") != null) {
		out.println("<script>alert('Your order has been placed successfully')</script>");
	}
%>
  
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
<li><a href="/ViewProfile" >My Profile</a></li>
 <li><a href="/MyCart" >Cart</a></li>
  <li><a href="/ReceiveProducts" >Home</a></li>
    
  
</ul>
	</br>
		<div class="col-12">
			
     <h3 class="text-center">List of products</h3>
			<hr>
			
			  <div class="form-row">
	<div class="form-group col-md-2">
      <label for="inputState">Search by Keyword</label>
       <input type="text" class="form-control" id="myInput" placeholder="Search..">
    </div>	
    
     <div class="form-group col-md-3">
      <label for="inputCity">State</label>
      <select id="state" class="form-control" name="product_state">
         <option  value="ALL">Select State</option>

      </select>
     
    </div>
     <div class="form-group col-md-3">
      <label for="inputCity">Festival</label>
      <select id="festival" class="form-control" name="product_festival">
         <option value="ALL">Select Festival</option>

      </select>
     
    </div>
     <div class="form-group col-md-3">
      <label for="inputCity">Accessories</label>
      <select id="accessories" class="form-control" name="product_accessories">
         <option value="ALL">Select Accessories</option>

      </select>
     
    </div>
     <div class="form-group col-md-1">
       <label for="inputState" class="fa" style="font-size:24px">&#xf0b0;</label>
       <button class="form-control btn btn-primary" id="myInput" onclick="SearchData();">Filter</button>
    </div>
    	  
  </div>
       	<hr>
			<table class="table" id ="customers">
				<thead class="thead-dark">
					<tr>
						<th scope="col" class = "text-center">IMAGE</th>
						<th scope="col">NAME</th>
						<th scope="col">DESCRIPTION</th>
						<th scope="col">STATE</th>
						<th scope="col">FESTIVAL</th>
						<th scope="col">ACCESSORIES</th>
						<th scope="col">PRICE</th>
						<th scope="col" class = "text-center">ACTION</th>
					</tr>
				</thead>
				<tbody id="myTable">
				 <c:forEach items="${products}" var="product" varStatus="status">
					<tr>
						<td scope="row" class = "text-center"><img alt="" src="data:image/jpeg;base64,${product.product_photo}" style="width: 200px;height: 200px;" class="border border-dark rounded"></td>
						<td>${product.product_name}
						</td>
						<td>${product.product_info} </td>
						<td>${product.product_state}</td>
					
						<td>${product.product_festival}</td>
					
						<td>${product.product_accessories}</td>
						<td>${product.product_price}
							
						</td>
						<td class = "text-center"><a href="/ViewProduct/${product.id}"
							class="btn btn-primary mt-4">Buy Now</a></td>
					</tr>
					 </c:forEach>
				</tbody>
			</table>
			<hr>
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
const table = document.getElementById("customers");
//save all tr
const tr = table.getElementsByTagName("tr");

function SearchData() {
	
	

var state = document.getElementById("state").value.toUpperCase();
console.log(state);
var festival = document.getElementById("festival").value.toUpperCase();
var accessories = document.getElementById("accessories").value.toUpperCase();

console.log("Hiiii");
for (i = 1; i < tr.length; i++) {
	console.log(tr.length);
 var rowState = tr[i].getElementsByTagName("td")[3].textContent.toUpperCase();
 console.log(rowState);
 var rowFestival = tr[i].getElementsByTagName("td")[4].textContent.toUpperCase();
 console.log(rowFestival);
 var rowAccessories = tr[i].getElementsByTagName("td")[5].textContent.toUpperCase();
 console.log(rowAccessories);
 
 var isDiplay = true;

 if (state != 'ALL' && rowState != state) {
   isDiplay = false;
 }
 if (festival != 'ALL' && rowFestival != festival) {
   isDiplay = false;
 }
 if (accessories != 'ALL' && rowAccessories != accessories) {
   isDiplay = false;
 }
 
 
 
 if (isDiplay) {
   tr[i].style.display = "";
 }
 else {
   tr[i].style.display = "none";
 }


}

}
</script>

		</body>
  </html>
