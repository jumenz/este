package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdressesController {
	
	/**
	 * Lädt das Adressbuch
	 * @return string page name
	 */
	@RequestMapping(value="/adressbuch/", method=RequestMethod.GET)
	public String displayAdresses() {
		return "adresses";
	}
}
