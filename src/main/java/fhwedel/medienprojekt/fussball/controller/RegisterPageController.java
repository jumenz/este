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

/** Externe Klassen */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/** Eigene Klassen */
import fhwedel.medienprojekt.fussball.model.user.User;
import fhwedel.medienprojekt.fussball.model.user.UserGroup;
import fhwedel.medienprojekt.fussball.service.AuthenticationService;
import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessPermissions;
import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessUsers;
import fhwedel.medienprojekt.fussball.service.dataErrors.DataErrorsPermissions;
import fhwedel.medienprojekt.fussball.service.dataErrors.DataErrorsUsers;
import fhwedel.medienprojekt.fussball.model.user.Permission;
import fhwedel.medienprojekt.fussball.controller.Constants;

/**
 * Controller
 * Übernimmt die Anzeige und Verarbeitung der Register-Seite.
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
	
	/** Service zum Prüfen von Errors neuer User */
	@Autowired
	private DataErrorsUsers dataErrorsUsers;
	
	/** Service zum Prüfen von Fehlern beim Anlegen neuer Permissions */
	@Autowired
	private DataErrorsPermissions dataErrorsPermissions;
	
	/** Manager für die Authentifizierung von Usern */
	@Autowired
	private AuthenticationService authenticationService;
	
	/* ------------- Anzeige ------------------------------ */
	/**
	 * Bereitet das Anzeigen der Registerseite vor.
	 * @param 	model	Model
	 * @return	String	Viewname der JSP
	 */
	private String prepareRegisterDisplay(Model model) {
		// neues User Objekt zugreifbar machen
		model.addAttribute("newUser", new User());
		model.addAttribute("newPermission", new Permission());
		model.addAttribute("allPermissions", this.dataAccessPermissions.getAll());
		
		return Constants.viewNameRegister;
	}
	
	/**
	 * Lädt die Registrierungs-Seite
	 * @param model	Model
	 * @return string page name
	 */
	@RequestMapping(value=Constants.linkRegister, method=RequestMethod.GET)
	public String displayRegisterPage(Model model) {
		return this.prepareRegisterDisplay(model);
	}
	
	/* --------------- neuen User registrieren ----------- */
	/**
	 * Registriert einen neuen User mit der Vorraussetzund, dass dessen 
	 * eMail-Adresse zugelassen wurde.
	 * @param 	newUser			User			neuer User
	 * @param 	bindingResult	BindingResult
	 * @param 	model			Model
	 * @return	String			Viewname der JSP oder Redirect auf Homeseite
	 */
	@RequestMapping(value=Constants.linkRegisterSaveUser, method=RequestMethod.POST)
	public String register(@ModelAttribute("newUser") User newUser, BindingResult bindingResult, Model model, Errors errors) {
		// Bei Fehlern wieder auf Formular redirecten
		if(bindingResult.hasErrors() || this.dataErrorsUsers.hasErrors(newUser, bindingResult)) {
			model.addAttribute("newPermission", new Permission());
			model.addAttribute("allPermissions", this.dataAccessPermissions.getAll());
			return Constants.viewNameRegister;
		}

		// User speichern, wenn dieser zur Registrierung zugelassen wurde
		if(this.dataAccessPermissions.hasPermission(newUser)) {
			// Adminstatus aus Permission auslesen und speichern
			UserGroup userGroup = (this.dataAccessPermissions.isAdmin(newUser)) 
									? UserGroup.USER_GROUP_ADMIN 
									: UserGroup.USER_GROUP_NO_ADMIN;
			newUser.setUserGroup(userGroup);
			// ID auf Permission übernehmen
			newUser.setId(this.dataAccessPermissions.getPermissionId(newUser));
			this.dataAccessUsers.save(newUser);
			
			// Neuen User Anmelden
			if(this.authenticationService.authenticate(newUser.getUsername(), newUser.getPassword())) {
				return Constants.redirectHome;
			} else {
				// Falls einloggen nicht klappen sollte, auf die Login-Seite weiterleiten
				return Constants.redirectLogin;
			}
		}
		// Falls bei der Registrierung andere Fehler autreten, erneut Registerseite anzeigen
		return Constants.redirectRegister;
	}
		
	/**
	 * Speichert eine EMail in der Permission Tabelle, um die EMail-Adresse 
	 * zur Registrierung zuzulassen.
	 * @param 	newPermission		Permission		Neue Registrierungszulassung
	 * 				@ModelAttribute sorgt dafür, dass bei Fehlern die alte Permission
	 * 				bereitgestellt wird
	 * @param 	bindingResult		BindingResult
	 * @param 	model				Model
	 * @return	String				Redirect auf Registrierungsseite
	 */
	@RequestMapping(value=Constants.linkRegisterNewPermission, method=RequestMethod.POST)
	public String addPermission(@ModelAttribute("newPermission") Permission newPermission, BindingResult bindingResult, Model model) {
		// Bei Fehlern wieder auf Formular redirecten
		if(bindingResult.hasErrors() || this.dataErrorsPermissions.hasErrors(newPermission, bindingResult)) {
			// Andere Bestandteile bereitstellen, die keine Fehler enthalten
			// neues User Objekt zugreifbar machen
			model.addAttribute("newUser", new User());
			model.addAttribute("allPermissions", this.dataAccessPermissions.getAll());
			return Constants.viewNameRegister;
		}
		
		// User speichern, wenn dieser zur Registrierung zugelassen wurde
		this.dataAccessPermissions.save(newPermission);
		
		return Constants.redirectRegister;
	}
	
	/* -------------------- Nutzer bearbeiten ------------------------ */
	/**
	 * Ändert den Admin-Status eines Users.
	 * @param 	id	int	 ID des Users, der bearbeitet werden soll
	 * @return	String	Redirect auf Registrierungsseite
	 */
	@RequestMapping(value=Constants.linkRegisterChangeUserStatus + "{id}/", method=RequestMethod.GET)
	public String changeUserState(@PathVariable int id) {
		// User und Permission updaten
		this.dataAccessUsers.changeUserStatus(id);	
		this.dataAccessPermissions.changeUserStatus(id);
		
		return Constants.redirectRegister;
	}
	
	/* -------------------- Nutzer löschen --------------------------- */
	/**
	 * Löscht eine Email-Adresse auf der Permission Tabelle, der zugehörige User
	 * wird ebenfalls gelöscht, falls einer vorhanden ist.
	 * @param	id		PathVariable	id der Permission, die gelöscht werden soll
	 * @return	String
	 */
	@RequestMapping(value=Constants.linkRegisterRemovePermission + "{id}/", method=RequestMethod.POST)
	public String removePermission(@PathVariable int id) {
		// User speichern, wenn dieser zur Registrierung zugelassen wurde
		this.dataAccessPermissions.remove(id);
		
		return Constants.redirectRegister;
	}
}
