package fhwedel.medienprojekt.fussball.service.dataErrors;

/** externe Klassen */
import java.io.IOException;
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
		return !this.validUsername(newUser.getUsername(), bindingResult)
				|| !this.validPassword(newUser, bindingResult);
	}
	
	/**
	 * Prüft den Username auf Fehler.
	 * @param newUser		User 			neuer User
	 * @param bindingResult	BindingResult	zum anfügen von Fehlern
	 * @return	boolean		true: Fehler vorhanden
	 * 						false: keine Fehler vorhanden
	 */
	private boolean validUsername(String username, BindingResult bindingResult) {
		// Der Username darf nicht leer oder schon vergeben sein
		if (!this.inDb(Constants.dbUsers, Constants.dbUsersUsername, username)) {
			bindingResult.rejectValue("username", "error.login.username");
		}
		return !bindingResult.hasErrors();
	}
	
	/**
	 * Prüft das Passwort auf Fehler.
	 * @param 	pwd				String			Passwort
	 * @param 	pwdCompare		String			Vergleichspasswort
	 * @param 	bindingResult	BindingResult	zum anfügen von Fehlern
	 * @return	boolean		true: Fehler vorhanden
	 * 						false: keine Fehler vorhanden
	 */
	private boolean validPassword(User user, BindingResult bindingResult) {
		// Das Passwort muss dem der Datenbank entsprechen
		ArrayList<User> dbUser = this.dataAccessUsers.getUserData(user.getUsername());
		assert (dbUser.size() == 1);
		if(!areSame(dbUser.get(0).getPassword(), user.getPassword())) {
			bindingResult.rejectValue("password", "error.login.password");
		}
		return !bindingResult.hasErrors();
	}
}
