/**
 * FH Wedel - Projekt Medieninformatik
 * 
 * Ellen Schwartau 	- Minf9888
 * Julia Menzel 	- Minf9950
 * 
 *  @date	2014-04-16
 *  @author	Ellen Schwartau Minf9888
 */
package fhwedel.medienprojekt.fussball.controller;

/** externe Klassen */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.controller.Constants;

/**
 * Controller
 * Übernimmt die Verarbeitung der Logout-Seite.
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
