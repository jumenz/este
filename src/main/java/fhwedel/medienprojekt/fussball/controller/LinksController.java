package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LinksController {
	
	/**
	 * Lädt die Seite mit verlinkten Links
	 * @return string page name
	 */
	@RequestMapping("/links/")
	public String displayLinks() {
		return "links";
	}
}
