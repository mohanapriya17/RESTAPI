<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD CUSTOMER</title>
</head>
<style>
body{
background-color: skyblue;
}
</style>
<body>

<div class="container">
 

<h1>Enter Customer Details</h1>
    <div class="container">
    <form:form modelAttribute="customer" action="${pageContext.request.contextPath}/saveCustomer" calss="form-signin">
        <div class="form-group">
            Customer Name:
            <form:input path="customerName" class="form-control" />
            <br />
        </div>
        <div class="form-group">
            Customer address:
            <form:input path="customerAddress" class="form-control" />
            <br />
        </div>
        <div class="form-group">
            Mobile Number:
            <form:input path="mobileNumber" class="form-control" />
            <br />
        </div>
        <form:input path="customerId" hidden="hidden"/>
        <button type="submit" value="Submit" class="btn btn-primary">Submit</button>
       
    </form:form>
</div>
</div>

</body>
</html>