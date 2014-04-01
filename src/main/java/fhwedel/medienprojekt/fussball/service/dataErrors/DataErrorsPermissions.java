package fhwedel.medienprojekt.fussball.service.dataErrors;

/** externe Klassen */
import org.springframework.validation.BindingResult;


import fhwedel.medienprojekt.fussball.model.user.Permission;
/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.user.User;


/**
 * Service
 * Übernimmt die Fehlerbehandlung für Permissions.
 * 
 * @author Ellen Schwartau Minf9888
 *
 */
public class DataErrorsPermissions extends AbstractDataErrors {
	/* ------------------ Konstanten -------------------------------------------- */
	/** placeholder in der jsp für das Email-Feld */
	final String placeholderEmail = "E-Mail Adresse";
	
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
		return !validEmail(newPermission.getEmail(), bindingResult);
	}
	
	/**
	 * Prüft eine Email Adresse auf Korrektheit.
	 * @param	email			String			Email-Adresse
	 * @param 	bindingResult	BindingResult	zum anfügen von Fehlern
	 * @return	boolean			true: 			Fehler vorhanden
	 * 							false: 			keine Fehler vorhanden
	 */
	public boolean validEmail(String email, BindingResult bindingResult) {
		// Die Emailadresse muss die Form einer EMail erfüllen 
		// und darf nicht bereits registriert sein
		if (this.isEmpty(email, this.placeholderEmail)) {
			bindingResult.rejectValue("email", "error.permission.empty");
		} else if (!this.isEmail(email)) {
			bindingResult.rejectValue("email", "error.permission.invalid");
		} else if (this.inDb(Constants.dbPermissions, Constants.dbUsersEmail, email)) {
			bindingResult.rejectValue("email", "error.permission.duplicate");
		}
		
		return bindingResult.hasErrors();
	}
}
