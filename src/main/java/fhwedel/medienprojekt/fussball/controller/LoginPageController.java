package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginPageController {
	
	/**
	 * Lädt die Login Seite
	 * @return string page name
	 */
	@RequestMapping(value="/login/", method=RequestMethod.GET)
	public String displayLoginPage() {
		return "login";
	}
}
