package gallery.dao;

import java.util.List;

import gallery.model.Image;

public interface ImageDao {
	
	Image getImage(int imageid);
	
	List<Image> listImages();
	
	List<Image> listAlbumimages(int albumid);

}