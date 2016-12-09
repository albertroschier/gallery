<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true" %>

<html>

<head>

	<link href="/public/style.css" rel="stylesheet" type="text/css" />
	<link href="/public/form.css" rel="stylesheet" type="text/css" />
	
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

	<title>Upload Page</title>

</head>

<body>

<main>

	<h1>Gallery</h1>

	<p>Upload a new image to the gallery.</p>

	<div class="container">

		<p>Upload form</p>

		<form:form enctype="multipart/form-data" modelAttribute="uploadForm" action="/imageUpload" method='POST'>
			
			<tr>
				<td>
					<form:input path="imageUpload" type='file' id="file" />
					<label for="file" class="custom-file-upload">Browse<br><br><span id="filename">No image selected</span></label>
				</td>
			</tr><br><br>
			
			<tr>
				<td colspan='2'><input id="submit" type="submit" value="Upload" /></td>
			</tr>
			
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

		</form:form>

	<br><p style="font-size: 12px;">Note: You can only upload one image at a time.<p>
	
	</div>

</main>

<script type="text/javascript">

$('#file').change(function() {
	var filepath = this.value;
	var m = filepath.match(/([^\/\\]+)$/);
	var filename = m[1];
	$('#filename').html(filename);
});

</script>

</body>

</html>