package fhwedel.medienprojekt.fussball.service.dataErrors;

/** externe Klassen */
import org.springframework.validation.BindingResult;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.user.User;


/**
 * Service
 * Übernimmt die Fehlerbehandlung für Users.
 * 
 * @author Ellen
 *
 */
public class DataErrorsUsers extends AbstractDataErrors {
	/* ------------------ Konstanten -------------------------------------------- */
	final String placeholderUsername = "Username";
	final String placeholderEmail = "E-Mail Adresse";
	final String placeholderPassword = "passwort";
	
	/* ------------------ Konstruktorfunktionen --------------------------------- */
	/**
	 * Default-Konstruktor.
	 */
	public DataErrorsUsers() {}
	
	/* ---------------------------- Fehlerbehandlung ----------------------------------- */

	
	/**
	 * Prüft ob ein User Objekt Fehler aufweist.
	 * @param newUser		User neuer User
	 * @param bindingResult	BindingResult
	 * @return	boolean		true: Fehler vorhanden
	 * 						false: keine Fehler vorhanden
	 */
	public boolean hasErrors(User newUser, BindingResult bindingResult) {
		// Username, Passwort und Email-Adresse auf Fehler prüfen
		// Verkürzte Auswertung durch ||
		return this.validUsername(newUser, bindingResult) 
				|| this.validPassword(newUser, bindingResult);
	}
	
	/**
	 * Prüft den Username auf Fehler.
	 * @param newUser		User neuer User
	 * @param bindingResult	BindingResult
	 * @return	boolean		true: Fehler vorhanden
	 * 						false: keine Fehler vorhanden
	 */
	public boolean validUsername(User newUser, BindingResult bindingResult) {
		boolean errorState = false;
		// Der Username darf nicht leer sein
		if(this.isEmpty(newUser.getUsername(), this.placeholderUsername)) {
			bindingResult.rejectValue("username", "error.username.empty");
			errorState = true;
		} // else if (this.alreadyInUse(, col, value))
		return errorState;
	}
	
	/**
	 * Prüft das Passwort auf Fehler.
	 * @param newUser		User neuer User
	 * @param bindingResult	BindingResult
	 * @return	boolean		true: Fehler vorhanden
	 * 						false: keine Fehler vorhanden
	 */
	public boolean validPassword(User newUser, BindingResult bindingResult) {
		boolean errorState = false;
		if(this.isEmpty(newUser.getPassword(), this.placeholderPassword) 
			|| this.isEmpty(newUser.getPasswordCompare(), this.placeholderPassword)) {
			// Eines der Passwortfelder ist leer oder enthält den Placeholder
			bindingResult.rejectValue("password", "error.password.empty");
			errorState = true;
		} else if(!this.areSame(newUser.getPassword(), newUser.getPasswordCompare())) {
			// Passwörter passen nicht zusammen
			bindingResult.rejectValue("password", "error.password.missmatch");
			errorState = true;
		} else if (this.checkLength(newUser.getPassword(), 5, 50)) {
			// Passwort ist zu kurz oder zu lang
			bindingResult.rejectValue("password", "error.password.length");
			errorState = true;
		}
		return errorState;
	}
	
}
