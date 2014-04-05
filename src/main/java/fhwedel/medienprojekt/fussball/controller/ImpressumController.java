package fhwedel.medienprojekt.fussball.controller;

/** externe Klassen */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;


/** eigene Klassen */
import fhwedel.medienprojekt.fussball.controller.Constants;
import fhwedel.medienprojekt.fussball.model.statics.ImpressumContent;
import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessImpressum;
import fhwedel.medienprojekt.fussball.service.dataErrors.DataErrorsImpressum;

/**
 * ImpressumController
 * 
 * @author Ellen Schwartau Minf9888
 *
 */
@Controller
public class ImpressumController {
	/* ---------------- Klassenvariablen ------------------------ */
	/** Service für den Datenbankzugriff */
	@Autowired
	private DataAccessImpressum dataAccessImpressum;
	
	/** Service für die Fehlerbehandlung */
	@Autowired
	private DataErrorsImpressum dataErrorsImpressum;
	
	/* ----------------- Methoden ------------------------------- */
	/**
	 * Lädt das Impressum
	 * @return string page name
	 */
	@RequestMapping(value=Constants.linkImpressum, method=RequestMethod.GET)
	public String displayImpressum(Model model) {
		// Inhalte aus Seite auslesen und anzeigen
		model.addAttribute("impressumContent", this.dataAccessImpressum.getContent());
		return Constants.viewNameImpressum;
	}
	
	/**
	 * Lädt die Seite zum bearbeiten des Impressums
	 * @return string page name
	 */
	@RequestMapping(value=Constants.linkImpressumEdit, method=RequestMethod.GET)
	public String showEditForm(Model model) {
		// Inhalte aus Datenbank auslesen und Formular anzeigen
		model.addAttribute("impressumContent", this.dataAccessImpressum.getContent());
		return Constants.viewNameImpressumEdit;
	}
	
	/**
	 * Speichert die Änderungen an der Impressums-Seite
	 * @return string page name
	 */
	@RequestMapping(value=Constants.linkImpressumEdit, method=RequestMethod.POST)
	public String editImpressum(@ModelAttribute("impressumContent") ImpressumContent content, BindingResult bindingResult, Model model) {
		// Auf Fehler prüfen
		if(bindingResult.hasErrors() || this.dataErrorsImpressum.hasErrors(content, bindingResult)) {
			// Fehlermeldungen anzeigen
			return Constants.viewNameImpressumEdit;
		}
		
		// Sonst speichern und auf die Impressumsseite redirecten
		this.dataAccessImpressum.save(content);
		
		return Constants.redirectImpressum;
	}
}
