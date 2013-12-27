package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImpressumController {
	
	/**
	 * Lädt die Über-Uns Seite
	 * @return string page name
	 */
	@RequestMapping("/impressum/")
	public String displayImpressum() {
		return "impressum";
	}
}
