package gallery.dao;

import java.util.List;

import gallery.model.Album;

public interface AlbumDao {
	
	Album getAlbum(int albumid);
	
	List<Album> listAlbums();
	
}