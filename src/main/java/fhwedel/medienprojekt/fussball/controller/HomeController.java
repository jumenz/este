package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
import org.springframework.beans.factory.annotation.Autowired;
import fhwedel.medienprojekt.fussball.service.TopPlayerService;
import org.springframework.ui.Model;
*/
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	/* Beispiel
	@Autowired
	private TopPlayerService topPlayerService;
	
	@RequestMapping("/home/") // Url die geladen wird
	public String displayHome(Model model) {
		model.addAttribute("topPlayers", topPlayerService.getTopPlayers());
		return "home";
	}
	*/
	
	/**
	 * Lädt die Home Seite
	 * @return string page name
	 */
	@RequestMapping(value="/home/", method=RequestMethod.GET)
	public String displayHome() {
		return "home";
	}
}
