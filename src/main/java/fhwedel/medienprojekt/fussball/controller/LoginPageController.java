package fhwedel.medienprojekt.fussball.controller;

/** externe Klassen */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.user.User;
import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessUsers;

/**
 * Login Page Controller.
 * @author Ellen Schwartau Minf9888
 *
 */
@Controller
public class LoginPageController {
	/** Datenbankanbindung */
	@Autowired
	private DataAccessUsers dataAccessUsers;
	
	/**
	 * Lädt die Login Seite
	 * @return string page name
	 */
	@RequestMapping(value="/login/", method=RequestMethod.GET)
	public String displayLoginPage(Model model) {
		model.addAttribute("loginUser", new User());
		return "login";
	}
	
	@RequestMapping(value="/login/", method=RequestMethod.POST)
	public String login(User user, BindingResult bindingResult) {
		if(bindingResult.hasErrors() || !this.dataAccessUsers.checkLogin(user)) {
			return "login";
		}
		
		return "home";
	}
}
