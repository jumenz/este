package fhwedel.medienprojekt.fussball.controller;

/** Externe Klassen */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/** Eigene Klassen */
import fhwedel.medienprojekt.fussball.model.user.User;
import fhwedel.medienprojekt.fussball.service.DataAccessPermissions;
import fhwedel.medienprojekt.fussball.service.DataAccessUsers;
import fhwedel.medienprojekt.fussball.service.DataErrorsUsers;
import fhwedel.medienprojekt.fussball.model.user.Permission;

@Controller
public class RegisterPageController {
	/* ------------- Klassenvariablen --------------------- */
	/** Service für die Datenbankarbeit */
	@Autowired
	private DataAccessUsers dataAccessUsers;

	/** Datenbanksevice für die Registrierungszulassungen */
	@Autowired
	private DataAccessPermissions dataAccessPermissions;
	
	@Autowired
	private DataErrorsUsers dataErrors;
	
	/* ------------- Anzeige ------------------------------ */
	/**
	 * Lädt die Registrierungs-Seite
	 * @param model	Model
	 * @return string page name
	 */
	@RequestMapping(value="/registrieren/", method=RequestMethod.GET)
	public String displayRegisterPage(Model model) {
		// neues User Objekt zugreifbar machen
		model.addAttribute("newUser", new User());
		// TODO nur wenn Admin
		model.addAttribute("newPermission", new Permission());
		// TODO nur wenn Admin
		model.addAttribute("allPermissions", this.dataAccessPermissions.getAll());
		return "register";
	}
	
	/* --------------- neuen User registrieren ----------- */
	/**
	 * Registriert einen neuen User mit der Vorraussetzund, dass dessen 
	 * eMail-Adresse zugelassen wurde.
	 * @param newUser
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/registrieren/user-speichern/", method=RequestMethod.POST)
	public String register(User newUser, BindingResult bindingResult, Model model) {
		// Bei Fehlern wieder auf Formular redirecten
		if(bindingResult.hasErrors() || this.dataErrors.hasErrors(newUser, bindingResult)) {
			model.addAttribute("newUser", newUser);
			model.addAttribute("newPermission", new Permission());
			return "register";
		}
		
		// User speichern, wenn dieser zur Registrierung zugelassen wurde
		if(this.dataAccessPermissions.hasPermission(newUser)) {
			this.dataAccessUsers.save(newUser);
		}
		// TODO einloggen
		return "redirect:/home/";
	}
	
	/**
	 * Speichert eine EMail in der Permission Tabelle, um die EMail-Adresse 
	 * zur Registrierung zuzulassen.
	 * @param newPermission
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/registrieren/email-zulassen/", method=RequestMethod.POST)
	public String addPermission(Permission newPermission, BindingResult bindingResult, Model model) {
		// Bei Fehlern wieder auf Formular redirecten
		if(bindingResult.hasErrors()) {
			return "register";
		}
		
		// User speichern, wenn dieser zur Registrierung zugelassen wurde
		this.dataAccessPermissions.save(newPermission);
		
		return "redirect:/registrieren/";
	}

	/* -------------------- Nutzer löschen --------------------------- */
	/**
	 * Speichert eine EMail in der Permission Tabelle, um die EMail-Adresse 
	 * zur Registrierung zuzulassen.
	 * @param newPermission
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/registrieren/loeschen-{id}/", method=RequestMethod.POST)
	public String addPermission(@PathVariable int id, Model model) {
		// User speichern, wenn dieser zur Registrierung zugelassen wurde
		this.dataAccessPermissions.remove(id);
		
		return "redirect:/registrieren/";
	}
}
