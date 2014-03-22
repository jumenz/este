package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterPageController {
	
	/**
	 * Lädt die Registrierungs-Seite
	 * @return string page name
	 */
	@RequestMapping(value="/register/", method=RequestMethod.GET)
	public String displayRegisterPage() {
		return "register";
	}
}
