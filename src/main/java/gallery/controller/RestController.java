package gallery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import gallery.model.Album;
import gallery.service.AlbumService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import gallery.model.Image;
import gallery.service.ImageService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private AlbumService albumService;
	
	@ResponseBody
	@GetMapping("/album/{albumId}/images")
	public List<Image> getAlbumImages(@PathVariable int albumId) {
		return imageService.listImagesForAlbum(albumId);
	}
	
	@ResponseBody
	@GetMapping(value="/albums")
	public List<Album> listAlbums() {
		return albumService.listAlbums();
	}
}
