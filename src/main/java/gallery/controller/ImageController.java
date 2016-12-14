package gallery.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import gallery.model.Image;
import gallery.service.ImageService;

@Controller
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@ResponseBody
	@GetMapping(value = "/image")
	public ResponseEntity<InputStreamResource> downloadImage(@RequestParam Integer imageid) throws FileNotFoundException {
		Image image = imageService.getImage(imageid);
		File imageFile = new File(image.getFilepath());
	
	return ResponseEntity.ok()
		.contentType(MediaType.parseMediaType("image/jpg"))
		.body(new InputStreamResource(new FileInputStream(imageFile)));
	}
	
	@GetMapping(value = "/image/delete")
	public String delete(@RequestParam Integer imageid) {
		imageService.deleteImage(imageid);
		return "redirect:/gallery";
	}
	
}