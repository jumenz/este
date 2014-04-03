package fhwedel.medienprojekt.fussball.controller;

/** externe Klassen */
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
	 * Wird nach erfolgreichen ausloggen aufgerufen und leitet auf
	 * die Welcome-Page weiter.
	 */
	@RequestMapping(value=Constants.linkClassPath, method=RequestMethod.GET)
	public String setLoggedInCookie() {
		return Constants.redirectWelcome;
	}
}
