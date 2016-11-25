var images = function() {
	$.get("/rest/albums.json", function(data) {
		alert("success");
		console.log(data);
	})
}

var generate = function() {
	$("#modal").append(
	
	"<div class="album-image-container">" +
		
		"<div class="modal-header">" +
			"<span class="close" onclick="closeModal()">×</span>" +
			"<p class="album-name">${album.name}</p>" +
		"</div>" +
		
		"<div class="gallery">" +
		
		"<c:forEach items="${album.images}" var="image">" +
			
			"<c:url var="imageURL" value="/image" >");" +
				"<c:param name="imageid" value="${image.imageid}"/>" +
			"</c:url>" +
			
			"<ul>" +
				"<li>" +
					"<img src="${imageURL}">" +
				"</li>" +
			"</ul>" +
		
		"</c:forEach>" +
		
		"</div>" +
		
	"</div>");
	
}

$(document).ready(function() {
	test();
	generate();
});

var album = document.getElementById('album-gallery');
var modal = document.getElementById('modal');
var btn = document.getElementsByClassName("album");
var span = document.getElementsByClassName("close")[0];

for (var i = 0; i < btn.length; i++) {
	btn[i].onClick = function() {
		modal.style.display = "block";
		btn.style.display = "none";
	}
}

span.onclick = function() {
	$(".modal").css("display", "none")
	$(".album").css("display", "block")
}