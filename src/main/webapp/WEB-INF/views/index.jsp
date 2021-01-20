<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <title>Spring MVC - User Login</title>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	    
	    <style>
	    .error{
	    		color:red
	    		}
	    </style>
</head>
<body>
  <h1>Spring Boot - MVC web application example</h1>
  <hr>

  <div class="container">
	        <h3 id="form_header" class="text-warning" align="center">Spring MVC Login Web Application</h3>
	        <div>&nbsp;</div>
	
	         <!-- User input form to validate a user -->
	        <form:form id="user_form" action="homepage" modelAttribute="login" method="POST">
	       
	            <div class="form-group">
	                <label for="name">Username:</label>
	                <form:input path="username" type="text" class="form-control" id="name" placeholder="Enter username" name="userName"/>
	                <form:errors path="username" cssClass="error" />
	            </div>
	            
	            <div class="form-group">
	                <label for="pwd">Password:</label>
	                <form:input path="password" type="password" class="form-control" id="pwd" placeholder="Enter password" name="password"/>
	                <form:errors path="password" cssClass="error" />
	            </div>
	            
	            <button id="confirm_user" type="submit" class="btn btn-primary">Login</button>
	            
	        </form:form>
	    </div>
	    
	    ${errormessage}

</body>
</html>
