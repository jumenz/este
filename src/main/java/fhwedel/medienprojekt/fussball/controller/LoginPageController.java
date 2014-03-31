package fhwedel.medienprojekt.fussball.controller;

/** externe Klassen */
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.user.User;
import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessUsers;
import fhwedel.medienprojekt.fussball.service.dataErrors.DataErrorsLogin;
import fhwedel.medienprojekt.fussball.controller.Constants;

/**
 * Login Page Controller.
 * @author Ellen Schwartau Minf9888
 *
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
	 * Setzt den Logged in Cookie des Users.
	 * @param 	user		User
	 * @param 	response	HttpServletResponse
	 */
	public void setLoggedInCookie(User user, HttpServletResponse response) {
		user.setUserGroup(this.dataAccessUsers.getUserGroup(user.getUsername(), user.getPassword()));
		/* Cookie setzen */
		// TODO verschlüsseln
		Cookie userCookie = new Cookie(Constants.cookieUser, user.getUsername());
		Cookie userStateCookie = new Cookie(Constants.cookieUserState, user.getUserGroupString());
		/* Expire Time auf eine Stunde */
		userCookie.setMaxAge(3600);
		userStateCookie.setMaxAge(3600);
		/* Cookie setzen */
		response.addCookie(userCookie);
		response.addCookie(userStateCookie);
	}
	
	/**
	 * Behandelt den Login-Request.
	 * @param 	user			User	User mit eingegebenen Login-Daten
	 * @param 	bindingResult	BindingResult
	 * @param 	model			Model
	 * @return	String			Viewname zum Mappen der JSP
	 */
	@RequestMapping(value=Constants.linkLogin, method=RequestMethod.POST)
	public String login(@ModelAttribute("loginUser") User user, BindingResult bindingResult, Model model, HttpServletResponse response) {
		/* Prüfen, ob Username und Passwort stimmen */
		if(bindingResult.hasErrors() 
		|| this.dataErrosLogin.hasErrors(user, bindingResult)) {
			return Constants.viewNameLogin;
		}
		
		/* Cookie bei erfolgreichem Login setzen und auf Landing Page weiterleiten */
		this.setLoggedInCookie(user, response);
		// TODO anders machen
		return Constants.redirectHome;
	}
}
