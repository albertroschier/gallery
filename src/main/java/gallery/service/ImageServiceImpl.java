package gallery.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gallery.ImageUploadForm;
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
	public List<Image> listImagesForAlbum(int albumId) {
		List<Image> images = imageDao.listImagesForAlbum(albumId);
		for (Image image : images) {
			image.setFilepath(imageFolder + image.getFilepath());
		
		}
		return images;
	}

	@Override
	public void uploadImage(ImageUploadForm iuf) {
		UUID uuid = UUID.randomUUID();String randomUUIDString = uuid.toString();
		try {
		String filepath = imageFolder+randomUUIDString;
		FileOutputStream out = new FileOutputStream(filepath);
		out.write(iuf.getImageUpload().getBytes());
			out.close();
			imageDao.uploadImage(filepath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}