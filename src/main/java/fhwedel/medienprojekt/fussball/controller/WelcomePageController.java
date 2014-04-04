package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.controller.Constants;

@Controller
public class WelcomePageController {
	
	/**
	 * Lädt die Willkommens-Seite
	 * @return string page name
	 */
	@RequestMapping(value=Constants.linkWelcome, method=RequestMethod.GET)
	public String displayWelcomePage() {
		return Constants.viewNameWelcome;
	}
}
