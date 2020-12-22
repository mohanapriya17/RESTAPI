<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FetchCustomer</title>
</head>
<style>
body{
background-color: skyblue;
}
</style>
<body>
<h1>FETCH CUSTOMER</h1>
    <table>
        <thead>
            <th>Customer Id</th>
            <th>Customer Name</th>
            <th>Customer address</th>
            <th>mobile Number</th>
        </thead>
        <tbody>
            <c:forEach var="customer" items="${customerDetails}">
                <tr>
                    <td>${customer.customerId }</td>
                    <td>${customer.customerName }</td>
                    <td>${customer.customerAddress }</td>
                    <td>${customer.mobileNumber }</td>
                
  
                    <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/editCustomer/${customer.customerId}">Edit</a>
                        <a class="btn btn-warning" href="${pageContext.request.contextPath}/deleteCustomer?custId=${customer.customerId}">Delete</a></td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
 
</body>
</html>