package gallery.service;

import java.util.List;

import gallery.ImageUploadForm;
import gallery.model.Image;

public interface ImageService {
	
	Image getImage(int imageid);
	
	List<Image> listImages();
	
	List<Image> listImagesForAlbum(int albumId);
	
	void uploadImage(ImageUploadForm iuf);
}