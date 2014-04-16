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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.controller.Constants;

/**
 * Controller
 * Zuständig für die Anzeige der Willkommen-Seite.
 */
@Controller
public class WelcomePageController {
	
	/**
	 * Lädt die Willkommens-Seite
	 * @return string 	ViewName
	 */
	@RequestMapping(value=Constants.linkWelcome, method=RequestMethod.GET)
	public String displayWelcomePage() {
		return Constants.viewNameWelcome;
	}
}
