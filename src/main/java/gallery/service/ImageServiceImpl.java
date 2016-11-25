package gallery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gallery.dao.ImageDao;
import gallery.model.Image;

@Transactional
@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageDao imageDao;
	
	@Value("${gallery.images.folder}")
	private String imageFolder;
	
	@Override
	public Image getImage(int imageid) {
		Image result = imageDao.getImage(imageid);
		result.setFilepath(imageFolder + result.getFilepath());
		return result;
	}

	@Override
	public List<Image> listImages() {
		
		List<Image> images = imageDao.listImages();
		for (Image image : images) {
			image.setFilepath(imageFolder + image.getFilepath());
		
		}
		
		return images;
	}

	@Override
	public List<Image> listAlbumimages(int albumid) {
		return imageDao.listAlbumimages(albumid);
	}
	
}