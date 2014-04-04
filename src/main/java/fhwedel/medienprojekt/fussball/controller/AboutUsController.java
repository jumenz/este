package fhwedel.medienprojekt.fussball.controller;

/** externe Klassen */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.controller.Constants;
import fhwedel.medienprojekt.fussball.model.statics.AboutUsContent;
import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessAboutUs;
import fhwedel.medienprojekt.fussball.service.dataErrors.DataErrorsAboutUs;

/**
 * Bearbeitet alle Requests, die mit /ueber-uns/ beginnen.
 * 
 * @author Ellen Schwartau Minf9888
 *
 */
@Controller
public class AboutUsController {
	/* ----------------------- Klassenvariablen ----------------------- */
	/** Service für den Datenbankzugriff */
	@Autowired
	private DataAccessAboutUs dataAccess;
	/** Service für die Fehlerbehandlung */
	@Autowired
	private DataErrorsAboutUs dataErrors;
	
	/* ---------------------- Funktionen ------------------------------- */
	private void prepareView(Model model) {
		AboutUsContent content = this.dataAccess.getAboutUsContent();
		model.addAttribute("content", content);
	}
	
	/**
	 * Lädt die Über-Uns Seite
	 * @param	model	Model
	 * @return 	String	Viewname der JSP
	 */
	@RequestMapping(value=Constants.linkAboutUs, method=RequestMethod.GET)
	public String displayAboutUs(Model model) {
		this.prepareView(model);
		return Constants.viewNameAboutUs;
	}
	
	/**
	 * Lädt das Formular zum bearbeiten der Über-Uns Seite
	 * @param	model	Model
	 * @return 	String	Viewname der JSP
	 */
	@RequestMapping(value=Constants.linkAboutUsEdit, method=RequestMethod.GET)
	public String edit(Model model) {
		this.prepareView(model);
		return Constants.viewNameAboutUsEdit;
	}
	
	/**
	 * Speichert den neuen Inhalt der Über-Uns Seite
	 * @param	content	A		boutUsContent	neuer Conten
	 * @param	bindingResult	BindingResult
	 * @param	model			Model
	 * @return 	String 			Redirect auf die Über uns Seite
	 */
	@RequestMapping(value=Constants.linkAboutUsEdit, method=RequestMethod.POST)
	public String save(@ModelAttribute("content") AboutUsContent content, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors() || this.dataErrors.hasErrors(content, bindingResult)) {
			return Constants.viewNameAboutUsEdit;
		}
		
		this.dataAccess.save(content);
		
		return Constants.redirectAboutUs;
	}
	
}
