/**
 * FH Wedel - Projekt Medieninformatik
 * 
 * Ellen Schwartau 	- Minf9888
 * Julia Menzel 	- Minf9950
 * 
 *  @date	2014-04-16
 *  @author	Ellen Schwartau Minf9888
 */
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
import fhwedel.medienprojekt.fussball.model.user.User;
import fhwedel.medienprojekt.fussball.service.AuthenticationService;
import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessUsers;
import fhwedel.medienprojekt.fussball.service.dataErrors.DataErrorsLogin;
import fhwedel.medienprojekt.fussball.controller.Constants;

/**
 * Controller
 * Verarbeitet den Login der Seite.
 */
@Controller
public class LoginPageController {
	/* ----------------- Klassenvariablen ---------------------- */
	/** Datenbankanbindung */
	@Autowired
	private DataAccessUsers dataAccessUsers;
	
	/** Fehlerbehandlung */
	@Autowired
	private DataErrorsLogin dataErrosLogin;
	
	/** Manager für die Authentifizierung von Usern */
	@Autowired
	private AuthenticationService authenticationService;
	
	/* --------------- Methoden -------------------------------- */
	/* --------------- Anzeige --------------------------------- */
	/**
	 * Hilfsfunktion
	 * Bereitet das Anzeigen der Login Seite vor.
	 * @param 	model	Model
	 * @return	String	Viewname zum Mappen der JSP
	 */
	public String prepareLoginDisplay(Model model) {
		// User-Objekt zum Mappen der Eingabedaten bereitstellen
		model.addAttribute("loginUser", new User());
		return Constants.viewNameLogin;
	}
	
	/**
	 * Lädt die Login Seite
	 * @return string page name
	 */
	@RequestMapping(value=Constants.linkLogin, method=RequestMethod.GET)
	public String displayLoginPage(Model model) {
		return this.prepareLoginDisplay(model);
	}
	
	/* -------------- Login ------------------------------------ */
	/**
	 * Behandelt den Login-Request.
	 * @param 	user			User	User mit eingegebenen Login-Daten
	 * @param 	bindingResult	BindingResult
	 * @return	String			Viewname zum Mappen der JSP
	 */
	@RequestMapping(value=Constants.linkLogin, method=RequestMethod.POST)
	public String login(@ModelAttribute("loginUser") User user, BindingResult bindingResult) {
		/* Prüfen, ob Username und Passwort stimmen 
		 * Wenn Angaben stimmen, User authentifizieren */
		if(bindingResult.hasErrors() 
		|| this.dataErrosLogin.hasErrors(user, bindingResult)
		|| !this.authenticationService.authenticate(user.getUsername(), user.getPassword())) {
			// Falls Fehler vorliegen oder Authentifizierung nicht geklappt hat
			// Loginformular erneut anzeigen
			return Constants.viewNameLogin;
		}
		// Ansonsten auf die Home Seite redirecten
		return Constants.redirectHome;
	}

}
