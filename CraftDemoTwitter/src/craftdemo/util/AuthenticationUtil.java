package craftdemo.util;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationUtil {
	
	public static String getCurrentUserId() {
		String currentUserName = "arenfa";
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		     currentUserName = authentication.getName();

		}
		
		return currentUserName;
	}
}
