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
import fhwedel.medienprojekt.fussball.model.post.PostView;
import fhwedel.medienprojekt.fussball.model.post.forum.ForumEntry;
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
	
	/* --------------------- Anzeige -------------------------------- */
	/**
	 * Lädt die Spielberichte Seite
	 * @param	model	Model
	 * @return	String	Name der JSP
	 */
	@RequestMapping(value=Constants.linkReports, method=RequestMethod.GET)
	public String displayReports(Model model) {
		Page<Report> page = this.dataAccess.getPage(1, this.reportsPerPage);
		
		// In jsp zugreifbar machen
		model.addAttribute("reportPage", page);
		return Constants.viewNameReports;
	}
	
	/**
	 * Lädt eine bestimmte Seite der Spielberichte
	 * @param 	mode	Model
	 * @return  String 	Viewname
	 */
	@RequestMapping(value=Constants.linkReportsPage, method=RequestMethod.GET)
	public String displayForum(@PathVariable("page") int showPage, Model model) {
		// Erste Seite laden
		Page<Report> page = this.dataAccess.getPage(showPage, this.reportsPerPage);
		// In jsp zugreifbar machen
		model.addAttribute("reportPage", page);
		return Constants.viewNameReports;
	}
	
	/**
	 * Liefert Spielberichte, die mit bestimmtem String beginnen.
	 * @param	sub		String		String der enthalten sein soll
	 * @param	model	Model
	 */
	@RequestMapping(value=Constants.linkReportsContaining, method=RequestMethod.GET)
	public String getReportsIncluding(@PathVariable String sub, Model model) {
		Page<Report> page = new Page<Report>();
		page.setPageItems(this.dataAccess.getAllIncluding(sub));
		page.setPageNumber(1);
		page.setPagesAvailable(1);
		
		// In jsp zugreifbar machen
		model.addAttribute("reportPage", page);
		
		return Constants.viewNameReports;
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
		// neues Report Objekt in jsp zugreifbar machen
		model.addAttribute(new Report());
		// jsp zum Erstellen eines neuen Berichts laden
		return Constants.viewNameReportsEdit;
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
		
		// jsp zum Erstellen eines neuen Berichts laden
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
		// Report auslesen
		model.addAttribute("report", this.dataAccess.getById(id));
		return Constants.viewNameReportsEdit;
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
		
		// jsp zum Erstellen eines neuen Berichts laden
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
		this.dataAccess.deleteById(id);
		return Constants.redirectReports;
	}
}
