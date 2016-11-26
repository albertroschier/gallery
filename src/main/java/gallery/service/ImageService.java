package gallery.service;

import java.util.List;

import gallery.model.Image;

public interface ImageService {
	
	Image getImage(int imageid);
	
	List<Image> listImages();
	
	List<Image> listAlbumimages(int albumid);
	
}