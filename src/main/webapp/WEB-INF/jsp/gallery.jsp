<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="ctx" value="${pageContext['request'].contextPath}" />

<html>

<head>

<link rel="icon" href="">
<link href="${pageContext.request.contextPath}/public/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/public/images.css" rel="stylesheet" type="text/css" />
<title>Gallery</title>

</head>

<body>

<main>

	<h1>Gallery</h1>
	
	<input id="tab1" type="radio" name="tabs" checked>
	<label for="tab1">Front</label>

	<input id="tab2" type="radio"name="tabs">
	<label for="tab2">Images</label>

	<input id="tab3" type="radio" name="tabs">
	<label for="tab3">Albums</label>

	<input id="tab4" type="radio" name="tabs">
	<label for="tab4">About</label>

	<section id="content1">
		<br><br><p>Welcome to the gallery!</p>
	</section>
	
	<section id="content2">
		<br><br><p>Here's all the images listed in chronological order.</p>

		<div class="gallery">
	
		<table>
			<c:forEach items="${images}" var="image">
				<c:url var="imageURL" value="/image" >
					<c:param name="imageid" value="${image.imageid}"/>
				</c:url>
				<tr>
					<td><img src="<c:out value="${imageURL}"/>‌‌"></td>
				</tr>
			</c:forEach>
		</table>
	
		</div>

	</section>
	
	<section id="content3">
		<br><br><p>Here are the images that are neatly organized into albums.</p>
	</section>

	<section id="content4">
		<br><br><p>This is an experimental image gallery made using Spring Boot, MySQL and various other tools.</p>
	</section>

</main>

<div class="footer">© 2016 Albert Roschier</div>

</body>

</html>