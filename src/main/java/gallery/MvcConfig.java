package gallery;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/").setViewName("redirect:/gallery");
	}

	@Bean (name = "filterMultipartResolver")
	public CommonsMultipartResolver filterMultipartResolver() {
	
	CommonsMultipartResolver filterMultipartResolver = new CommonsMultipartResolver();
	filterMultipartResolver.setDefaultEncoding("utf-8");
	//resolver.setMaxUploadSize(512000);
	return filterMultipartResolver;
	
	}

}