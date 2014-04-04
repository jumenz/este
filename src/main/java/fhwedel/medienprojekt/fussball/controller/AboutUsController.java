package fhwedel.medienprojekt.fussball.controller;

/** externe Klassen */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.controller.Constants;

@Controller
public class AboutUsController {
	
	/**
	 * Lädt die Über-Uns Seite
	 * @return string page name
	 */
	@RequestMapping(value=Constants.linkAboutUs, method=RequestMethod.GET)
	public String displayAboutUs() {
		return Constants.viewNameAboutUs;
	}
}
