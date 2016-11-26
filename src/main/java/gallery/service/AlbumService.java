package gallery.service;

import java.util.List;

import gallery.model.Album;

public interface AlbumService {

	Album getAlbum(int albumid);
	
	List<Album> listAlbums();
	
}