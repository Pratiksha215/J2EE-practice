<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table id="myTable" border="1">
  <tr>
    <th>Name</th>
    <th>country</th>
    <th>Age</th>
    <th>Salary</th>
  </tr>
  <tr>
    <td>Jill</td>
    <td>USA</td>
    <td>50</td>
    <td>1000</td>
  </tr>
  <tr>
    <td>Eve</td>
    <td>UK</td>
    <td>50</td>
    <td>2000</td>
  </tr>
  <tr>
    <td>John</td>
    <td>INDIA</td>
    <td>80</td>
    <td>3000</td>
  </tr>
  <tr>
    <td>sam</td>
    <td>AUSTRALIA</td>
    <td>80</td>
    <td>4000</td>
  </tr>
  <tr>
    <td>joe</td>
    <td>INDIA</td>
    <td>60</td>
    <td>5000</td>
  </tr>
  <tr>
    <td>John</td>
    <td>Australia</td>
    <td>90</td>
    <td>3000</td>
  </tr>
  <tr>
    <td>alan</td>
    <td>USA</td>
    <td>60</td>
    <td>6000</td>
  </tr>
  <tr>
    <td>Jill</td>
    <td>USA</td>
    <td>50</td>
    <td>5000</td>
  </tr>
  <tr>
    <td>Eve</td>
    <td>UK</td>
    <td>50</td>
    <td>4000</td>
  </tr>
  <tr>
    <td>John</td>
    <td>INDIA</td>
    <td>80</td>
    <td>3000</td>
  </tr>
  <tr>
    <td>sam</td>
    <td>AUSTRALIA</td>
    <td>80</td>
    <td>4000</td>
  </tr>
  <tr>
    <td>John</td>
    <td>INDIA</td>
    <td>90</td>
    <td>3000</td>
  </tr>
</table>

<select id="idName">
  <option value="all">Select Name</option>
  <option value="Jill">Jill</option>
  <option value="Eve">Eve</option>
  <option value="John">John</option>
  <option value="sam">sam</option>
  <option value="joe">joe</option>
  <option value="alan">alan</option>
</select>

<select id="idCountry">
  <option value="all">Select Country</option>
  <option value="USA">USA</option>
  <option value="UK">UK</option>
  <option value="INDIA">INDIA</option>
  <option value="AUSTRALIA">AUSTRALIA</option>
</select>

<select id="idAge">
  <option value="all">Select Age</option>
  <option value="50">50</option>
  <option value="60">60</option>
  <option value="80">80</option>
  <option value="90">90</option>
</select>

<select id="idSalary">
  <option value="all">Select Salary</option>
  <option value="1000">1000</option>
  <option value="2000">2000</option>
  <option value="3000">3000</option>
  <option value="4000">4000</option>
  <option value="5000">5000</option>
  <option value="6000">6000</option>
</select>

<input type="button" onclick="SearchData();" value="Submit" />


<script>
const table = document.getElementById("myTable");
//save all tr
const tr = table.getElementsByTagName("tr");

function SearchData() {

var name = document.getElementById("idName").value.toUpperCase();
var country = document.getElementById("idCountry").value.toUpperCase();
var age = document.getElementById("idAge").value.toUpperCase();
var salary = document.getElementById("idSalary").value.toUpperCase();

for (i = 1; i < tr.length; i++) {

 var rowName = tr[i].getElementsByTagName("td")[0].textContent.toUpperCase();
 var rowCountry = tr[i].getElementsByTagName("td")[1].textContent.toUpperCase();
 var rowAge = tr[i].getElementsByTagName("td")[2].textContent.toUpperCase();
 var rowSalary = tr[i].getElementsByTagName("td")[3].textContent.toUpperCase();

 var isDiplay = true;

 if (name != 'ALL' && rowName != name) {
   isDiplay = false;
 }
 if (country != 'ALL' && rowCountry != country) {
   isDiplay = false;
 }
 if (age != 'ALL' && rowAge != age) {
   isDiplay = false;
 }
 if (salary != 'ALL' && rowSalary != salary) {
   isDiplay = false;
 }
 
 if (isDiplay) {
   tr[i].style.display = "";
 } else {
   tr[i].style.display = "none";
 }


}
}
</script>


</body>



</html>