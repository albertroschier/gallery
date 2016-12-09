package gallery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import gallery.ImageUploadForm;
import gallery.service.ImageService;

@Controller
public class UploadController {

	@GetMapping ("/upload")
	public String upload (Model model) {
		model.addAttribute("uploadForm", new ImageUploadForm());
		return "upload";
	}
	
	@PostMapping("/imageUpload")
	public String handleFileUpload (@ModelAttribute ImageUploadForm form) {
		imageService.uploadImage(form);
		return "redirect:/gallery";
	}
	
	@Autowired
	private ImageService imageService;

}