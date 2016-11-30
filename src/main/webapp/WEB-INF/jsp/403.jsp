<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>

	<link href="/public/style.css" rel="stylesheet" type="text/css" />
	<link href="/public/login.css" rel="stylesheet" type="text/css" />

	<title>HTTP Status 403</title>

</head>

<body>

<main>

	<h1>Gallery</h1>

	<h3>HTTP Status 403 - Access is denied</h3>
	
	<div class="container">
	
	<c:choose>
		
		<c:when test="${empty username}">
			<h3>You do not have permission to access this page!</h3>
		</c:when>
		
		<c:otherwise>
			<h3>Username : ${username} <br /> You do not have permission to access this page!</h3>
		</c:otherwise>
		
	</c:choose>
	
	</div>

</main>

</body>

</html>