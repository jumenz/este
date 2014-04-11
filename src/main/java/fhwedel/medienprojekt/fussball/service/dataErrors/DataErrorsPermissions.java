package fhwedel.medienprojekt.fussball.service.dataErrors;

/** externe Klassen */
import org.springframework.validation.BindingResult;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.user.Permission;


/**
 * Service
 * Übernimmt die Fehlerbehandlung für Permissions.
 * 
 * @author Ellen Schwartau Minf9888
 *
 */
public class DataErrorsPermissions extends AbstractDataErrorsDBHelper {
	/* ------------------ Konstruktorfunktionen --------------------------------- */
	/**
	 * Default-Konstruktor.
	 */
	public DataErrorsPermissions() {}
	
	/* ---------------------------- Fehlerbehandlung ----------------------------------- */
	/**
	 * Überprüft, ob bei einer neuen Permisson Fehler
	 * vorliegen, also die Email valide ist.
	 * @param 	newPermission	Permission		neue Registrierungserlaubnis
	 * @param 	bindingResult	BindingResult	zum anhängen der Fehler
	 * @return	boolean			true:			es liegen Fehler vor
	 * 							false:			es liegen keine Fehler vor
	 */
	public boolean hasErrors(Permission newPermission, BindingResult bindingResult) {
		validateEmail(newPermission.getEmail(), bindingResult);
		return bindingResult.hasErrors();
	}
	
	/**
	 * Prüft eine Email Adresse auf Korrektheit.
	 * @param	email			String			Email-Adresse
	 * @param 	bindingResult	BindingResult	zum Anfügen von Fehlern
	 */
	public void validateEmail(String email, BindingResult bindingResult) {
		// Die Emailadresse muss die Form einer EMail erfüllen 
		// und darf nicht bereits registriert sein
		if (this.isEmpty(email)) {
			bindingResult.rejectValue("email", "error.permission.empty");
		} else if (!this.isEmail(email)) {
			bindingResult.rejectValue("email", "error.permission.invalid");
		} else if (this.inDb(Constants.dbPermissions, Constants.dbUsersEmail, email)) {
			bindingResult.rejectValue("email", "error.permission.duplicate");
		}
	}
}
