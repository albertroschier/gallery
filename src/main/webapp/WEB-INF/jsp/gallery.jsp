<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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
<link href="/public/loader.css" rel="stylesheet" type="text/css" />
<link href="/public/style.css" rel="stylesheet" type="text/css" />
<link href="/public/transition.css" rel="stylesheet" type="text/css" />
<link href="/public/images.css" rel="stylesheet" type="text/css" />
<link href="/public/albums.css" rel="stylesheet" type="text/css" />
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/public/scripts/loader.js" type="text/javascript"></script>
<script src="/public/scripts/lightbox.js" type="text/javascript" defer></script>
<script src="/public/scripts/albums.js" type="text/javascript" defer></script>
<style>
::-webkit-scrollbar {
	display: none;
}
</style>

<title>Gallery</title>
</head>

<body onload="myFunction()">

	<div id="loader"></div>

	<main>

	<div style="display: none;" id="myDiv" class="animate">

		<h1>Gallery</h1>

		<input id="tab1" type="radio" name="tabs" checked> <label
			for="tab1">Front</label> <input id="tab2" type="radio" name="tabs">
		<label for="tab2">Images</label> <input id="tab3" type="radio"
			name="tabs"> <label for="tab3">Albums</label> <input
			id="tab4" type="radio" name="tabs"> <label for="tab4">Info</label>

		<section id="content1">

			<div class="transition">

				<br> <br>
				<p>Welcome to the gallery!</p>

			</div>

		</section>
		<section id="content2">

			<div class="transition">

				<br> <br>
				<p>Here are the images.</p>

				<div class="container">
					<div class="gallery"></div>
				</div>
			</div>
		</section>
		
		<section id="content3">

			<div class="transition">

				<br> <br>
				<p>Here are the albums.</p>

				<div id="albumContainer" class="container">
					<ul id="albumList"></ul>
					<div id="modal"></div>
				</div>
			</div>
		</section>

		<section id="content4">

			<div class="transition">

				<br> <br>
				<p>This is an experimental image gallery made using Spring Boot,
					MySQL and various other tools.</p>
				<br> <br>
				<p>© 2016 Albert Roschier</p>

			</div>

		</section>

	</div>

	</main>

</body>

</html>