package fhwedel.medienprojekt.fussball.controller;

/** externe Klassen */
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.PostView;
import fhwedel.medienprojekt.fussball.model.post.report.Report;
import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessReports;
import fhwedel.medienprojekt.fussball.controller.Constants;

/**
 * Controller für die Spielberichte.
 * @author Ellen
 *
 */
@Controller
public class ReportsController {
	/* ---------------- Klassenvariablen --------------------- */
	/** Service für die Datenbankarbeit */
	@Autowired
	private DataAccessReports dataAccess;
	
	/* --------------------- Anzeige -------------------------------- */
	/**
	 * Lädt die Spielberichte Seite
	 * @param	model	Model
	 * @return	String	Name des JSP
	 */
	@RequestMapping(value=Constants.linkReports, method=RequestMethod.GET)
	public String displayReports(Model model) {
		PostView<Report> view = new PostView<Report>();
		
		// Einträge aus der Datenbank auslesen
		ArrayList<Report> list = this.dataAccess.getAll();
		for(int i=0; i<list.size(); i++) {
			view.addEntry(list.get(i));
		}
		
		// In jsp zugreifbar machen
		model.addAttribute("reportModel", view);
		
		return Constants.viewNameReports;
	}
	
	/**
	 * Liefert Spielberichte, die mit bestimmtem String beginnen.
	 * 
	 */
	@RequestMapping(value=Constants.linkReports + "{sub}", method=RequestMethod.GET)
	public String getForumEntriesStartingWith(@PathVariable String sub, Model model) {
		PostView<Report> view = new PostView<Report>();
		
		// Einträge aus der Datenbank auslesen, die mit Substring beginnen
		ArrayList<Report> list = this.dataAccess.getAllStartingWith(sub);
		for(int i=0; i<list.size(); i++) {
			view.addEntry(list.get(i));
		}
		
		// In jsp zugreifbar machen
		model.addAttribute("reportModel", view);
		
		return Constants.viewNameReports;
	}
	
	/**
	 * Liefert Foreneinträge, die mit bestimmtem String beginnen.
	 * 
	 */
	@RequestMapping(value=Constants.linkReports + "~{sub}", method=RequestMethod.GET)
	public String getForumEntriesIncluding(@PathVariable String sub, Model model) {
		PostView<Report> view = new PostView<Report>();
		
		// Einträge aus der Datenbank auslesen, die den Substring enthalten
		ArrayList<Report> list = this.dataAccess.getAllIncluding(sub);
		for(int i=0; i<list.size(); i++) {
			view.addEntry(list.get(i));
		}
		
		// In jsp zugreifbar machen
		model.addAttribute("reportModel", view);
		
		return Constants.viewNameReports;
	}
	
	/* ----------------------- Berichte verfassen ------------------------ */
	/**
	 * Lädt die Seite um einen neuen Spielbericht zu verfassen.
	 * @param	model	Model
	 * @return	String	Name des JSP
	 */
	@RequestMapping(value=Constants.linkReportsNew, method=RequestMethod.GET)
	public String displayNewReportForm(Model model) {
		// neues Report Objekt in jsp zugreifbar machen
		model.addAttribute(new Report());
		// jsp zum Erstellen eines neuen Berichts laden
		return Constants.viewNameReportsNew;
	}
	
	/**
	 * Lädt die Seite um einen neuen Spielbericht zu verfassen.
	 * @param	newReport		Report	Spielbericht, der gespeichert werden soll
	 * @param	bindingResult	BindingResult
	 * @return	String	Name der JSP
	 */
	@RequestMapping(value=Constants.linkReportsNew, method=RequestMethod.POST)
	public String save(Report newReport, BindingResult bindingResult) {
		// Bei Fehlern erneut Formular aufrufen
		if(bindingResult.hasErrors()) {
			return Constants.viewNameReportsNew;
		}
		
		// Speichern und Spielberichte laden
		this.dataAccess.save(newReport);
		
		// jsp zum Erstellen eines neuen Berichts laden
		return Constants.redirectReports;
	}
}
