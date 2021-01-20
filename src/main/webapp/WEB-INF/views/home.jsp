<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>	    
	    <title>Spring MVC - User Login</title>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	</head>
	<body>
	    <div class="container">
	    Welcome <span style='color: #008000;'>${login.username}!</span>
	    </div>
	    
	    <table>
	    <tr>
	    	<td>User Id</td>
	    	<td>Username</td>
	    	<td>Password</td>
	    </tr>
	    <c:forEach var="tempUser" items="${userList}">
		    <tr>
		    	<td>${tempUser.id}</td>
		        <td>${tempUser.username}</td>
			    <td>${tempUser.password}</td>
		    </tr>
		    </c:forEach>
	    </table>
	    
	</body>
</html>

<!--  <table>
	    <tr>
	    	<td>User Id</td>
	    	<td>Username</td>
	    	<td>Password</td>
	    </tr>
	    <c:forEach var="tempUser" items="${userEntities}">
		    <tr>
		    	<td>${tempUser.id}</td>
		        <td>${tempUser.username}</td>
			    <td>${tempUser.password}</td>
		    </tr>
		    </c:forEach>
	    </table> -->