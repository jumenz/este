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
public class DataErrorsUsers {
	/* ----------------------- Klassenvariablen --------------------------------- */
	/** Error Messages */
	final String ERROR_EMPTY_USERNAME 		= "Username darf nicht leer sein.";
	final String ERROR_EMPTY_EMAIL 			= "Die Email darf nicht leer sein.";
	final String ERROR_EMPTY_PASSWORD 		= "Fülle bitte beide Passwortfelder aus.";
	final String ERROR_PASSWORD_MISSMATCH 	= "Die Passwortfelder passen nicht zusammen.";
	final String ERROR_PASSWORD_LENGTH 		= "Das Passwort muss zwischen 5 und 50 Zeichen lang sein.";
			
	/* ------------------ Konstruktorfunktionen -----------------------------------*/
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
		if((newUser.getUsername().compareTo("") == 0) || (newUser.getUsername().compareTo("Username") == 0)) {
			bindingResult.rejectValue("username", this.ERROR_EMPTY_USERNAME);
			errorState = true;
		}
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
		// Beide Passwortfelder müssen ausgefüllt, gleich 
		// und zwischen 5 und 50 Zeichen lang sein
		if((newUser.getPassword().compareTo("") == 0) || (newUser.getPasswordCompare().compareTo("") == 0)) {
			bindingResult.rejectValue("password", this.ERROR_EMPTY_PASSWORD);
			errorState = true;
		} else if(!newUser.getPassword().equals(newUser.getPasswordCompare())) {
			bindingResult.rejectValue("password", this.ERROR_PASSWORD_MISSMATCH);
			errorState = true;
		} else if (newUser.getPassword().length()<5 || newUser.getPassword().length()>50) {
			bindingResult.rejectValue("password", this.ERROR_PASSWORD_LENGTH);
			errorState = true;
		}
		return errorState;
	}
	
}
