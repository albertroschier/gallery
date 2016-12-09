package gallery.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
	
	public static Authentication getAuth() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
}