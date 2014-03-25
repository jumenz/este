package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.controller.Constants;

@Controller
public class AdressesController {
	
	/**
	 * Lädt das Adressbuch
	 * @return string page name
	 */
	@RequestMapping(value=Constants.linkAdresses, method=RequestMethod.GET)
	public String displayAdresses() {
		return Constants.viewNameAdresses;
	}
}
