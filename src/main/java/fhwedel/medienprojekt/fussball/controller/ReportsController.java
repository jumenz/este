package fhwedel.medienprojekt.fussball.controller;

/** externe Klassen */
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.PostView;
import fhwedel.medienprojekt.fussball.model.post.report.Report;

/**
 * Controller für die Spielberichte.
 * @author Ellen
 *
 */
@Controller
public class ReportsController {
	
	/**
	 * Lädt die Spielberichte Seite
	 * @param	model	Model
	 * @return	String	Name des JSP
	 */
	@RequestMapping(value="/berichte/", method=RequestMethod.GET)
	public String displayReports(Model model) {
		PostView<Report> view = new PostView<Report>();
		// TODO Einträge aus Datenbank auslesen
		Report entry = new Report("Erster Spielbericht", "Etwas Text", "Author Eins", new Date(), "Gegner", 0,0,1,1);
		view.addEntry(entry);	
		
		// In jsp zugreifbar machen
		model.addAttribute("reportModel", view);
		
		return "reports";
	}
	
	/**
	 * Lädt die Seite um einen neuen Spielbericht zu verfassen.
	 * @param	model	Model
	 * @return	String	Name des JSP
	 */
	@RequestMapping("/berichte/verfassen/")
	public String displayNewReportForm(Model model) {
		// neues Report Objekt in jsp zugreifbar machen
		model.addAttribute(new Report());
		// jsp zum Erstellen eines neuen Berichts laden
		return "reportNew";
	}
	
}
