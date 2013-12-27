package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomePageController {
	
	/**
	 * Lädt die Willkommens-Seite
	 * @return string page name
	 */
	@RequestMapping("/willkommen/")
	public String displayWelcomePage() {
		return "welcome";
	}
}
