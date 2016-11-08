package gallery.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.core.net.SyslogOutputStream;
import gallery.model.Image;
import gallery.service.ImageService;

@Controller
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@RequestMapping(value = "image", method = RequestMethod.GET)
	
	@ResponseBody
	public ResponseEntity<InputStreamResource> downloadImage(@RequestParam ("imageid") String imageid) throws FileNotFoundException {
	
		System.out.println(imageid);
		int number = Integer.parseInt(imageid);
		Image image = imageService.getImage(number);
		File imageFile = new File(image.getFilepath());
	
	return ResponseEntity.ok()
		.contentType(MediaType.parseMediaType("image/jpg"))
		.body(new InputStreamResource(new FileInputStream(imageFile)));
	}
	
}