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
import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessPermissions;
import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessUsers;
import fhwedel.medienprojekt.fussball.service.dataErrors.DataErrorsUsers;
import fhwedel.medienprojekt.fussball.model.user.Permission;
import fhwedel.medienprojekt.fussball.controller.Constants;

/**
 * RegisterController
 * @author Ellen Schwartau Minf9888
 *
 */
@Controller
public class RegisterPageController {
	/* ------------- Klassenvariablen --------------------- */
	/** Service für die Datenbankarbeit */
	@Autowired
	private DataAccessUsers dataAccessUsers;

	/** Datenbanksevice für die Registrierungszulassungen */
	@Autowired
	private DataAccessPermissions dataAccessPermissions;
	
	/** Service zum prüfen von Errors */
	@Autowired
	private DataErrorsUsers dataErrors;
	
	/* ------------- Anzeige ------------------------------ */
	/**
	 * Lädt die Registrierungs-Seite
	 * @param model	Model
	 * @return string page name
	 */
	@RequestMapping(value=Constants.linkRegister, method=RequestMethod.GET)
	public String displayRegisterPage(Model model) {
		// neues User Objekt zugreifbar machen
		model.addAttribute("newUser", new User());
		// TODO nur wenn Admin
		model.addAttribute("newPermission", new Permission());
		// TODO nur wenn Admin
		model.addAttribute("allPermissions", this.dataAccessPermissions.getAll());
		
		return Constants.viewNameRegister;
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
	@RequestMapping(value=Constants.linkRegisterSaveUser, method=RequestMethod.POST)
	public String register(User newUser, BindingResult bindingResult, Model model) {
		// Bei Fehlern wieder auf Formular redirecten
		if(bindingResult.hasErrors() || this.dataErrors.hasErrors(newUser, bindingResult)) {
			model.addAttribute("newUser", newUser);
			model.addAttribute("newPermission", new Permission());
			return Constants.viewNameRegister;
		}
		
		// User speichern, wenn dieser zur Registrierung zugelassen wurde
		if(this.dataAccessPermissions.hasPermission(newUser)) {
			this.dataAccessUsers.save(newUser);
		}
		// TODO einloggen
		return Constants.redirectHome;
	}
	
	/**
	 * Speichert eine EMail in der Permission Tabelle, um die EMail-Adresse 
	 * zur Registrierung zuzulassen.
	 * @param 	newPermission		Permission		Neue Registrierungszulassung
	 * @param 	bindingResult		BindingResult
	 * @param 	model				Model
	 * @return	String				Redirect auf Registrierungsseite
	 */
	@RequestMapping(value=Constants.linkRegisterNewPermission, method=RequestMethod.POST)
	public String addPermission(Permission newPermission, BindingResult bindingResult, Model model) {
		// Bei Fehlern wieder auf Formular redirecten
		if(bindingResult.hasErrors()) {
			return Constants.viewNameRegister;
		}
		
		// User speichern, wenn dieser zur Registrierung zugelassen wurde
		this.dataAccessPermissions.save(newPermission);
		
		return Constants.redirectRegister;
	}

	/* -------------------- Nutzer löschen --------------------------- */
	/**
	 * Löscht eine Email-Adresse auf der Permission Tabelle, der zugehörige User
	 * wird ebenfalls gelöscht, falls einer vorhanden ist.
	 * @param	id		PathVariable	id der Permission, die gelöscht werden soll
	 * @param 	model	Model
	 * @return	String
	 */
	@RequestMapping(value=Constants.linkRegisterRemovePermission + "{id}/", method=RequestMethod.POST)
	public String removePermission(@PathVariable int id, Model model) {
		// User speichern, wenn dieser zur Registrierung zugelassen wurde
		this.dataAccessPermissions.remove(id);
		
		return Constants.redirectRegister;
	}
}
