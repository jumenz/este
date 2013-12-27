package fhwedel.medienprojekt.fussball.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportsController {
	
	/**
	 * Lädt die Spielberichte Seite
	 * @return string page name
	 */
	@RequestMapping("/berichte/")
	public String displayReports() {
		return "reports";
	}
}
