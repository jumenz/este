package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdressesController {
	
	/**
	 * Lädt das Adressbuch
	 * @return string page name
	 */
	@RequestMapping("/adressbuch/")
	public String displayAdresses() {
		return "adresses";
	}
}
