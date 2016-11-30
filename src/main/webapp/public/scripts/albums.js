var gallery = {

	initAlbums : function() {
		$.get("/rest/albums", function(data) {
			const albumList = $(".album-gallery")
			$.each(data, function(index, item) {
				albumList.append('<li class="album" onClick="gallery.openAlbum('+item.albumid+',\''+item.name+'\')">'+item.name+'</li>')
			});
		});
	},

	openAlbum: function(albumId, name) {
		const root = $("#modal")
		
		$.get('/rest/album/'+albumId+'/images', function(data) {
			root.empty()
			gallery.generateAlbumContents(root, name, data)
		});
	},
	
	generateAlbumContents: function(root, albumName, images) {
		const albumContainer = $('<div class="album-image-container"></div>')
		albumContainer.append(
		'<div class="modal-header">' +
		'<span class="close" onclick="gallery.closeModal()">×</span>' +
		'<p class="album-name">'+albumName+'</p>' +
		'</div>'
		)
			
		const imageList = $('<ul>')
		$.each(images, function(index, item) {
			var listItem = $('<li>')
			var image = $('<img src="/image?imageid='+item.imageid+'">')
			
			listItem.append(image)
			
			listItem.click(function(e) {
			e.preventDefault();

			var $lightbox = $(".lightbox");
			var $img = $lightbox.children('img')
			
			var src = $(this).children('img').attr("src");

			$img.attr('src', src);

			$lightbox.fadeIn('fast');

			$lightbox.click(function() {
				$lightbox.fadeOut('fast');
			});
			
			})
			
			imageList.append(listItem)
			
		})
		
		const galleryContainer = $('<div class="gallery"></div>')
		galleryContainer.append(imageList)
		albumContainer.append(galleryContainer)
		root.append(albumContainer)
	},
	
	closeModal: function() {
		$("#modal").empty()
	}
}

$(document).ready(function() {
	gallery.initAlbums()
});