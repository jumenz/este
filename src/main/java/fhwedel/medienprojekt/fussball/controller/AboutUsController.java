package fhwedel.medienprojekt.fussball.controller;

/** externe Klassen */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.controller.Constants;
import fhwedel.medienprojekt.fussball.model.statics.AboutUsContent;

@Controller
public class AboutUsController {
	
	/**
	 * Lädt die Über-Uns Seite
	 * @param	model	Model
	 * @return 	String	Viewname der JSP
	 */
	@RequestMapping(value=Constants.linkAboutUs, method=RequestMethod.GET)
	public String displayAboutUs(Model model) {
		model.addAttribute("content", new AboutUsContent());
		return Constants.viewNameAboutUs;
	}
	
	/**
	 * Lädt das Formular zum bearbeiten der Über-Uns Seite
	 * @param	model	Model
	 * @return 	String	Viewname der JSP
	 */
	@RequestMapping(value=Constants.linkAboutUsEdit, method=RequestMethod.GET)
	public String edit(Model model) {
		model.addAttribute("content", new AboutUsContent());
		return Constants.viewNameAboutUsEdit;
	}
	
	/**
	 * Speichert den neuen Inhalt der Über-Uns Seite
	 * @param	model	Model
	 * @return 	String 	Redirect auf die Über uns Seite
	 */
	@RequestMapping(value=Constants.linkAboutUsEdit, method=RequestMethod.POST)
	public String save(Model model) {
		// TODO
		return Constants.redirectAboutUs;
	}
	
}
