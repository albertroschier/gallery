package gallery;

import org.springframework.web.multipart.MultipartFile;

public class ImageUploadForm {
	
	private MultipartFile imageUpload;
	
	public MultipartFile getImageUpload() {
		return imageUpload;
	}

	public void setImageUpload(MultipartFile imageUpload) {
		this.imageUpload = imageUpload;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name; 
	
}