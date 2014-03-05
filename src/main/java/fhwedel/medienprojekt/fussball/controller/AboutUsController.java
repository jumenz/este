package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutUsController {
	
	/**
	 * Lädt die Über-Uns Seite
	 * @return string page name
	 */
	@RequestMapping("/ueber-uns/")
	public String displayAboutUs() {
		return "aboutUs";
	}
}
