<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>

<html>

<head>

	<link href="/public/style.css" rel="stylesheet" type="text/css" />
	<link href="/public/login.css" rel="stylesheet" type="text/css" />

	<title>Login Page</title>

</head>

<body onload='document.loginForm.username.focus();'>

<main>

	<h1>Gallery</h1>

	<p>Spring Security Login Form (Database Authentication)</p>

	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>

	<div class="container">

		<p>Login</p>

		<form name='loginForm' action="<c:url value='/login' />" method='POST'>
					
			<tr>
				<td><input type='text' id="username" name='username' placeholder="Username"></td>
			</tr><br>
			<tr>
				<td><input type='password' id="password" name='password' placeholder="Password" /></td>
			</tr><br><br>
			<tr>
				<td colspan='2'><input name="submit" id="login" type="submit" value="Submit" /></td>
			</tr>

			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

		</form>
		
	</div>

</main>

</body>

</html>