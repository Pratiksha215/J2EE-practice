<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--To support form binding , import spring supplied form tag lib  --%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product Form</title>
</head>
<body>
<form:form  method="post" modelAttribute="product">
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td>Enter Product Category</td>
				<td><form:input path="category" /></td>
			</tr>
			<tr>
				<td>Enter Product Name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Enter Product Price</td>
				<td><form:input type="number" path="price" /></td>
			</tr>
			<tr>
				<td>Enter Expiry Date</td>
				<td><form:input type="date" path="expDate" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Add New Product" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>