package gallery.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import gallery.service.ImageService;

@Controller
public class GalleryController {
	
	@GetMapping ("/gallery")
	public String frontpage (Map<String, Object> model) {
		model.put("images", imageService.listImages());
		return "gallery";
	}
	
	@Autowired
	private ImageService imageService;
	
}