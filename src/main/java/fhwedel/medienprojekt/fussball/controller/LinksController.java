package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LinksController {
	
	/**
	 * Lädt die Seite mit verlinkten Links
	 * @return string page name
	 */
	@RequestMapping(value="/links/", method=RequestMethod.GET)
	public String displayLinks() {
		return "links";
	}
}
