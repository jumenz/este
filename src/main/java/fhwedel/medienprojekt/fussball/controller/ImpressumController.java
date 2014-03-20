package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ImpressumController {
	
	/**
	 * Lädt die Über-Uns Seite
	 * @return string page name
	 */
	@RequestMapping(value="/impressum/", method=RequestMethod.GET)
	public String displayImpressum() {
		return "impressum";
	}
}
