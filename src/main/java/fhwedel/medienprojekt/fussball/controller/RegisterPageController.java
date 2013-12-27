package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterPageController {
	
	/**
	 * Lädt die Registrierungs-Seite
	 * @return string page name
	 */
	@RequestMapping("/registrieren/")
	public String displayRegisterPage() {
		return "register";
	}
}
