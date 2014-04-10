package fhwedel.medienprojekt.fussball.service.dataErrors;

/** externe Klassen */
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.user.User;
import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessUsers;


/**
 * Service
 * Übernimmt die Fehlerbehandlung für Users.
 * 
 * @author Ellen Schwartau Minf9888
 *
 */
public class DataErrorsLogin extends AbstractDataErrors {
	/* ------------------ Konstruktorfunktionen --------------------------------- */
	/** Datenbankanbindung */
	@Autowired
	private DataAccessUsers dataAccessUsers;
	
	/**
	 * Default-Konstruktor.
	 */
	public DataErrorsLogin() {}
	
	/* ---------------------------- Fehlerbehandlung ----------------------------------- */

	/**
	 * Prüft ob ein User Objekt Fehler aufweist.
	 * @param newUser		User neuer User
	 * @param bindingResult	BindingResult
	 * @return	boolean		true: Fehler vorhanden
	 * 						false: keine Fehler vorhanden
	 */
	public boolean hasErrors(User newUser, BindingResult bindingResult) {
		this.validateUsername(newUser.getUsername(), bindingResult);
		this.validatePassword(newUser, bindingResult);
		return bindingResult.hasErrors();
	}
	
	/**
	 * Prüft den Username auf Fehler.
	 * @param newUser		User 			neuer User
	 * @param bindingResult	BindingResult	zum Anfügen von Fehlern
	 */
	private void validateUsername(String username, BindingResult bindingResult) {
		// Der Username darf nicht leer oder schon vergeben sein
		if (this.isEmpty(username) || !this.inDb(Constants.dbUsers, Constants.dbUsersUsername, username)) {
			bindingResult.rejectValue("username", "error.login.missmatch");
		}
	}
	
	/**
	 * Prüft das Passwort auf Fehler.
	 * @param 	pwd				String			Passwort
	 * @param 	pwdCompare		String			Vergleichspasswort
	 * @param 	bindingResult	BindingResult	zum Anfügen von Fehlern
	 */
	private void validatePassword(User user, BindingResult bindingResult) {
		ArrayList<User> dbUser = this.dataAccessUsers.getUserData(user.getUsername());
		// Nur prüfen, wenn noch kein Fehler vorliegt, damit die Fehlermeldung nur einmal
		// angehängt wird
		if(!bindingResult.hasErrors()) {
			// Das Passwort muss dem der Datenbank entsprechen
			if(	this.isEmpty(user.getPassword()) 
				||!areSame(dbUser.get(0).getPassword(), user.getPassword())) {
					bindingResult.rejectValue("password", "error.login.missmatch");
			}
		}
	}
}
