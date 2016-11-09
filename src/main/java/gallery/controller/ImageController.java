package gallery.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import gallery.model.Image;
import gallery.service.ImageService;

@Controller
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@ResponseBody
	@RequestMapping(value = "image", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> downloadImage(@RequestParam ("imageid") Integer imageid) throws FileNotFoundException {
		Image image = imageService.getImage(imageid);
		File imageFile = new File(image.getFilepath());
	
	return ResponseEntity.ok()
		.contentType(MediaType.parseMediaType("image/jpg"))
		.body(new InputStreamResource(new FileInputStream(imageFile)));
	}
	
}