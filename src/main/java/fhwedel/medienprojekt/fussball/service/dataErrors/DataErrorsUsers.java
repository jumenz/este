package fhwedel.medienprojekt.fussball.service.dataErrors;

/** externe Klassen */
import org.springframework.validation.BindingResult;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.user.User;


/**
 * Service
 * Übernimmt die Fehlerbehandlung für Users.
 * 
 * @author Ellen Schwartau Minf9888
 *
 */
public class DataErrorsUsers extends AbstractDataErrors {
	/* ------------------ Konstanten -------------------------------------------- */
	final String placeholderUsername = "Username";
	final String placeholderEmail = "E-Mail Adresse";
	final String placeholderPassword = "Passwort";
	
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
		// Verkürzte Auswertung durch ||, allerdings alle Fehler anzeigen über &&
		this.validateUsername(newUser.getUsername(), bindingResult); 
		this.validateEmail(newUser.getEmail(), bindingResult);
		this.validatePassword(newUser.getPassword(), newUser.getPasswordCompare(), bindingResult);
		return bindingResult.hasErrors();
	}
	
	/**
	 * Prüft den Username auf Fehler.
	 * @param newUser		User 			neuer User
	 * @param bindingResult	BindingResult	zum anfügen von Fehlern
	 */
	public void validateUsername(String username, BindingResult bindingResult) {
		// Der Username darf nicht leer oder schon vergeben sein
		if(this.isEmpty(username, this.placeholderUsername)) {
			bindingResult.rejectValue("username", "error.username.empty");
		} else if (this.inDb(Constants.dbUsers, Constants.dbUsersUsername, username)) {
			bindingResult.rejectValue("username", "error.username.duplicate");
		}
	}
	
	/**
	 * Prüft das Passwort auf Fehler.
	 * @param 	pwd				String			Passwort
	 * @param 	pwdCompare		String			Vergleichspasswort
	 * @param 	bindingResult	BindingResult	zum anfügen von Fehlern
	 */
	public void validatePassword(String pwd, String pwdCompare, BindingResult bindingResult) {
		// Die Passwörter müssen zusammenpassen, dürfen nicht leer sein
		// und müssen eine bestimmte Länge haben
		if(this.isEmpty(pwd, this.placeholderPassword) || this.isEmpty(pwdCompare, this.placeholderPassword)) {
			bindingResult.rejectValue("password", "error.password.empty");
		} else if(!this.areSame(pwd, pwdCompare)) {
			bindingResult.rejectValue("password", "error.password.missmatch");
		} else if (!this.checkLength(pwd, 5, 50)) {
			bindingResult.rejectValue("password", "error.password.length");
		}
	}
	
	/**
	 * Validiert die Email-Adresse eines neuen Users.
	 * @param 	email			String	  		Email-Adresse
	 * @param 	bindingResult	BindingResult	zum anfügen von Fehlern
	 */
	public void validateEmail(String email, BindingResult bindingResult) {
		// Die Emailadresse muss die Form einer EMail erfüllen 
		// und darf nicht bereits registriert sein
		if (this.isEmpty(email, this.placeholderEmail)) {
			bindingResult.rejectValue("email", "error.email.empty");
		} else if (!this.isEmail(email)) {
			bindingResult.rejectValue("email", "error.email.invalid");
		} else if (this.inDb(Constants.dbUsers, Constants.dbUsersEmail, email)) {
			bindingResult.rejectValue("email", "error.email.duplicate");
		} else if (!this.inDb(Constants.dbPermissions, Constants.dbUsersEmail, email)) {
			bindingResult.rejectValue("email", "error.email.permission");
		}
	}
}
