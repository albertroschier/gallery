package gallery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import gallery.model.Album;
import gallery.service.AlbumService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@GetMapping("rest/albums")
	public List<Album> listAlbums() {
		return albumService.listAlbums();
	}
	
	@Autowired
	private AlbumService albumService;
}