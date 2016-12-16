<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page session="true" %>

<tags:layout>

<main>

	<a href="/gallery" title="Click here to go back to the main page."><h1>Gallery</h1></a>

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

		</form:form>

	<br><p style="font-size: 12px;">Note: You can only upload one image at a time.<p>
	
	</div>

	<script type="text/javascript">
	
	$('#file').change(function() {
		var filepath = this.value;
		var m = filepath.match(/([^\/\\]+)$/);
		var filename = m[1];
		$('#filename').html(filename);
	});
	
	</script>

</main>

</tags:layout>