<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:layout>

<main>

	<h1>Gallery</h1>

	<p>HTTP Status 403 - Access is denied</p>

	<div class="container">
	
	<c:choose>

		<c:when test="${empty username}">
			<p>You do not have permission to access this page!</p>
		</c:when>

		<c:otherwise>
			<p>Username : ${username} <br /> You do not have permission to access this page!</p>
		</c:otherwise>

	</c:choose>

	</div>

</main>

</tags:layout>