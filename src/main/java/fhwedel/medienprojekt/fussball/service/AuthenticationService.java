package fhwedel.medienprojekt.fussball.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Service zur Authentifizierung eines Users 
 * nach dem Login.
 * 
 * @author Ellen Schwartau Minf9888
 *
 */
public class AuthenticationService {
	/* ----------------- Klassenvariablen ---------------- */
	/** Manager für die Authentifizierung von Usern */
	@Autowired
	private AuthenticationManager authenticationManager;
	
	/* ---------------- Konstruktorfunktion -------------- */
	/**
	 * Default-Konstruktor.
	 */
	public AuthenticationService() {}
	
	/* ---------------- Funktionen ---------------------- */
	/**
	 * Authentifiziert einen User.
	 * @param 	username	String	Username
	 * @param 	password	String	Passwort
	 * @return	boolean		true	Authentifizierung war erfolgreich
	 * 						false	Authentifizierung ist fehlgeschlagen
	 */
	public boolean authenticate(String username, String password) {
	    try {
	        Authentication authenticate 
	        	= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	        if (authenticate.isAuthenticated()) {
	            SecurityContextHolder.getContext().setAuthentication(authenticate);             
	            return true;
	        }
	    }
	    catch (AuthenticationException e) {         
	    }
	    return false;
	}
	
}
