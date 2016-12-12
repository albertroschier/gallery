package gallery.dao;

import java.util.List;

import gallery.model.Image;

public interface ImageDao {
	
	Image getImage(int imageid);
	
	List<Image> listImages();
	
	List<Image> listImagesForAlbum(int albumId);
	
	void uploadImage(String filepath);

	void deleteImage(Image image);
}