<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>Testing spring MVC flow .....</h5>
<h5><a href="<spring:url value='/product/list'/>">Show Products</a></h5>
<h5><a href="<spring:url value='/product/add'/>">Add New Product</a></h5>
<h5><a href="<spring:url value='/product/fetch/5'/>">Test Path Variable</a></h5>

</body>
</html>