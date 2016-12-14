$(document).ready(function() {
	
	var $lightbox = $("<div class='lightbox'></div>");
	var $img = $("<img>");

	$lightbox.append($img);

	$('body').append($lightbox);

	$('.gallery li').click(function(e) {
		e.preventDefault();

		var src = $(this).children('img').attr("src");

		$img.attr('src', src);

		$lightbox.fadeIn('fast');

		$lightbox.click(function() {
			$lightbox.fadeOut('fast');
		});
	});
	
});

//$lightbox.append(
//"<c:url var='deleteURL' value='/image/delete'>" +
//"<c:param name='imageid' value='${image.imageid}'/>" +
//"</c:url><a class='delete' href='<c:out value='${deleteURL}'/>Delete</a>"
//)