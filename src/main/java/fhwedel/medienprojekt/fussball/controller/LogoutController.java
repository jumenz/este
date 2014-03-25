package fhwedel.medienprojekt.fussball.controller;

/** externe Klassen */
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.controller.Constants;

/**
 * Logout Controller.
 * @author Ellen Schwartau Minf9888
 *
 */
@Controller
public class LogoutController {
	/* --------------- Methoden -------------------------------- */
	/**
	 * Löscht den Cookie, der den User als angemeldet sichert.
	 * @param 	response	HttpServletResponse
	 */
	@RequestMapping(value=Constants.linkLogout, method=RequestMethod.GET)
	public String setLoggedInCookie(HttpServletRequest request) {
		Cookie cookies[] = request.getCookies();
		Cookie cookie = null;
		if( cookies != null ){
	      for (int i = 0; i < cookies.length; i++){
	         cookie = cookies[i];
	         /* Aus Cookies die gesuchten Cookies herausfinden */
	         if(((cookie.getName( )).compareTo(Constants.cookieUser) == 0)
	         || ((cookie.getName( )).compareTo(Constants.cookieUserState) == 0) ){
	        	 /* Cookies löschen (Expire Time auf 0 setzen) */
	        	 cookie.setMaxAge(0);
	         }
	      }
		}
		return Constants.redirectWelcome;
	}
}
