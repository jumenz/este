package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginPageController {
	
	/**
	 * Lädt die Login Seite
	 * @return string page name
	 */
	@RequestMapping("/login/")
	public String displayLoginPage() {
		return "login";
	}
}
