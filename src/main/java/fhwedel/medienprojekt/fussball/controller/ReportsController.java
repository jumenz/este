package fhwedel.medienprojekt.fussball.controller;

/** externe Klassen */
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import fhwedel.medienprojekt.fussball.model.pagination.Page;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.report.Report;
import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessReports;
import fhwedel.medienprojekt.fussball.service.dataErrors.DataErrorsReports;
import fhwedel.medienprojekt.fussball.controller.Constants;

/**
 * Controller für die Spielberichte.
 * @author Ellen Schwartau Minf9888
 *
 */
@Controller
public class ReportsController {
	/* ---------------- Klassenvariablen --------------------- */
	/** Service für die Datenbankarbeit */
	@Autowired
	private DataAccessReports dataAccess;
	
	/** Service für die Fehlerbehandlung */
	@Autowired
	private DataErrorsReports dataErrorsReports;
	
	/** Anzahl der Spielberichte pro Seite */
	final int reportsPerPage = 10;
	
	/* --------------------- Methoden ------------------------------ */
	/* --------------------- Hilfsfunktionen ----------------------- */
	/**
	 * Hilfsfunktion
	 * Bereitet die Anzeige der Spielberichte vor.
	 * @param 	model	Model
	 * @param 	page	Page	Seite mit Spielberichten
	 * @return	String	Viewname der Spielberichte
	 */
	private String prepareDisplayReports(Model model, Page<Report> page) {
		// In jsp zugreifbar machen
		model.addAttribute("reportPage", page);
		return Constants.viewNameReports;
	}
	
	/**
	 * Hilfsfunktion
	 * Bereitet das Bearbeiten oder neu Erstellen eines
	 * Spielberichts vor.
	 * @param 	model	Model
	 * @param 	report	Report	Spielbericht
	 * @return	String	Viewname des Bearbeitungsformulars
	 */
	private String prepareEditReport(Model model, Report report) {
		// neues Report Objekt in jsp zugreifbar machen
		model.addAttribute("report", report);
		// jsp zum Erstellen eines neuen Berichts laden
		return Constants.viewNameReportsEdit;
	}
	
	/* --------------- Anzeigen -------------------------------------- */
	
	/**
	 * Lädt die Spielberichte Seite
	 * @param	model	Model
	 * @return	String	Name der JSP
	 */
	@RequestMapping(value=Constants.linkReports, method=RequestMethod.GET)
	public String displayReports(Model model) {
		// erste Seite laden
		return this.prepareDisplayReports(model, this.dataAccess.getPage(1, this.reportsPerPage));
	}
	
	/**
	 * Lädt eine bestimmte Seite der Spielberichte
	 * @param 	mode	Model
	 * @return  String 	Viewname
	 */
	@RequestMapping(value=Constants.linkReportsPage, method=RequestMethod.GET)
	public String displayReports(@PathVariable("page") int showPage, Model model) {
		// gewünschte Seite laden
		return this.prepareDisplayReports(model, this.dataAccess.getPage(showPage, this.reportsPerPage));
	}
	
	/**
	 * Liefert Spielberichte, die einen bestimmtem String beinhalten.
	 * @param	sub		String		String der enthalten sein soll
	 * @param	model	Model
	 */
	@RequestMapping(value=Constants.linkReportsContaining, method=RequestMethod.GET)
	public String getReportsIncluding(@PathVariable String sub, Model model) {
		// Suchergebnisse auf einer Seite anzeigen
		ArrayList<Report> res = this.dataAccess.getAllIncluding(sub);
		Page<Report> page = this.dataAccess.setPage(1, 1, 1, res);
		return this.prepareDisplayReports(model, page);
	}
	
	/**
	 * Ermöglicht die Suche über das Suchfeld der Sidebar und leitet auf die 
	 * URL der Form "/reports/~<Sucheingabe>" weiter
	 * @param 	src		String nach dem gesucht wird
	 * @return	String	url auf die Redirect ausgeführt wird
	 */
	@RequestMapping(value=Constants.linkReportsSearch, method=RequestMethod.GET)
	public String searchEntries(@RequestParam(value="search") String sub) {
		// Auf entsprechenden Pfad weiterleiten
		return Constants.redirectReports +"~" + sub;
	}
	
	/* ----------------------- Berichte verfassen ------------------------ */
	/**
	 * Lädt die Seite um einen neuen Spielbericht zu verfassen.
	 * @param	model	Model
	 * @return	String	Name der JSP
	 */
	@RequestMapping(value=Constants.linkReportsNew, method=RequestMethod.GET)
	public String displayNewReportForm(Model model) {
		// Editierseitemit neuem Bericht laden
		return this.prepareEditReport(model, new Report());
	}
	
	/**
	 * Lädt die Seite um einen neuen Spielbericht zu verfassen.
	 * @param	newReport		Report	Spielbericht, der gespeichert werden soll
	 * @param	bindingResult	BindingResult
	 * @return	String			Name der JSP
	 */
	@RequestMapping(value=Constants.linkReportsNew, method=RequestMethod.POST)
	public String save(@ModelAttribute("report") Report newReport, BindingResult bindingResult) {
		// Bei Fehlern erneut Formular aufrufen
		if(bindingResult.hasErrors()  || this.dataErrorsReports.hasErrors(newReport, bindingResult)) {
			return Constants.viewNameReportsEdit;
		}
		// Speichern und Spielberichte laden
		this.dataAccess.save(newReport);
		
		return Constants.redirectReports;
	}
	
	/* ----------------- Bearbeiten -------------------------- */
	/**
	 * Lädt die Seite zum bearbeiten eines bestehenden Spielberichts.
	 * @param 	id		int		ID des Spielberichts 
	 * @param 	model	Model
	 * @return	String	Viewname zum mappen der JSP
	 */
	@RequestMapping(value=Constants.linkReportsEdit, method=RequestMethod.GET)
	public String loadEditForm(@PathVariable int id, Model model) {
		// Bearbeitungsformular mit referenziertem Bericht auslesen
		return this.prepareEditReport(model, this.dataAccess.getById(id));
	}
	
	/**
	 * Speichert einen editierten Spielbericht mit entsprechender ID.
	 * @param id			int		ID des Spielberichts
	 * @param report		Report	Spielbericht
	 * @param bindingResult	BindingResult
	 * @return	String	Redirect auf die Spielberichteseite
	 */
	@RequestMapping(value=Constants.linkReportsEdit, method=RequestMethod.POST)
	public String edit(@PathVariable int id, @ModelAttribute("report") Report report, BindingResult bindingResult) {
		// Bei Fehlern erneut Formular aufrufen
		if(bindingResult.hasErrors() || this.dataErrorsReports.hasErrors(report, bindingResult)) {
			return Constants.viewNameReports;
		}
		// Speichern und Spielberichte laden
		this.dataAccess.update(id, report);
		
		return Constants.redirectReports;
	}
	
	/* ----------------- Löschen ----------------------------- */
	/**
	 * Löscht einen Spielbereicht mit entsprechender ID.
	 * @param 	id		int	ID
	 * @return	String	Redirect auf Spielberichtseite
	 */
	@RequestMapping(value=Constants.linkReportsDelete, method=RequestMethod.POST) 
	public String delete(@PathVariable int id) {
		// Löschen und Redirect
		this.dataAccess.deleteById(id);
		return Constants.redirectReports;
	}
}
