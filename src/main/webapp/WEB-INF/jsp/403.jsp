<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>

	<link href="/public/style.css" rel="stylesheet" type="text/css" />
	<link href="/public/form.css" rel="stylesheet" type="text/css" />

	<title>HTTP Status 403</title>

</head>

<body>

<main>

	<h1>Gallery</h1>

	<p>HTTP Status 403 - Access is denied</p>

	<div class="container">
	
	<c:choose>

		<c:when test="${empty username}">
			<p>You do not have permission to access this page!</p>
		</c:when>

		<c:otherwise>
			<p>Username : ${username} <br /> You do not have permission to access this page!</p3>
		</c:otherwise>

	</c:choose>

	</div>

</main>

</body>

</html>