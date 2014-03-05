package fhwedel.medienprojekt.fussball.controller;

/** externe Klassen */
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@RequestMapping("/berichte/")
	public String displayReports(Model model) {
		PostView<Report> view = new PostView<Report>();
		// TODO Einträge aus Datenbank auslesen
		Report entry = new Report("Erster Spielbericht", "Etwas Text", "Author Eins", new DateTime());
		view.addEntry(entry);	
		
		// In jsp zugreifbar machen
		model.addAttribute("reportModel", view);
		
		return "reports";
	}
}
