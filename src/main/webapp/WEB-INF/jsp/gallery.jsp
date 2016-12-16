<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<c:set var="ctx" value="${pageContext['request'].contextPath}" />

<tags:layout>

	<div id="loader"></div>

	<main>

	<div style="display: none;" id="myDiv" class="animate">

		<h1>Gallery</h1>

		<input id="tab1" type="radio" name="tabs" checked>
		<label for="tab1">Front</label>

		<input id="tab2" type="radio" name="tabs">
		<label for="tab2">Images</label>

		<input id="tab3" type="radio" name="tabs">
		<label for="tab3">Albums</label>

		<input id="tab4" type="radio" name="tabs">
		<label for="tab4">Account</label>

		<section id="content1">

			<div class="transition">

				<br><br>
				<p>Welcome to the gallery!</p>

				<br><p>This is an experimental single page image gallery made using Spring Boot,
				<br>MySQL and various other tools.</p>
				<br><br><br>
				<p>© 2016 Albert Roschier</p>

			</div>

		</section>

		<section id="content2">

			<div class="transition">

				<br><br>
				<p>Here are all of the images. <a href="/upload">Click here to upload more</a></p>

				<div class="container">
					<div class="gallery">

						<c:forEach items="${images}" var="image">

							<c:url var="imageURL" value="/image">
								<c:param name="imageid" value="${image.imageid}"/>
							</c:url>

							<ul>
								<li>
									<img src="${imageURL}">
								</li>
							</ul>

						</c:forEach>

					</div>
				</div>
					
			</div>

		</section>

		<section id="content3">

			<div class="transition">

				<br><br>
				<p>Here are the albums.</p>

				<div id="albumContainer" class="container">
					<ul class="album-gallery"></ul>
					<div id="modal"></div>
				</div>

			</div>
		</section>

		<section id="content4">

			<div class="transition">

				<br><br>
				<p>And here's your account information.</p>

				<div class="container">

					<div id="account">
					
						<br>
						<b>Username:</b> <c:out value="${user.username}"/>
						<br><br>
						<b>First name:</b> <c:out value="${user.firstname}"/>
						<br><br>
						<b>Last name:</b> <c:out value="${user.lastname}"/>
						<br><br>
						
					</div>

				</div>

			</div>

		</section> 

	</div>

	</main>

</tags:layout>

<!--

<c:url var='deleteURL' value='/image/delete'>
<c:param name='imageid' value='${image.imageid}'/>
</c:url><a class='context-menu__link' class='delete' href='<c:out value='${deleteURL}'/>'><i class='fa fa-trash'></i>  Delete</a>

-->