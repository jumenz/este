package fhwedel.medienprojekt.fussball.service.dataErrors;

/** externe Klassen */
import org.springframework.validation.BindingResult;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.statics.AboutUsContent;


/**
 * Service
 * Übernimmt die Fehlerbehandlung für Permissions.
 * 
 * @author Ellen Schwartau Minf9888
 *
 */
public class DataErrorsAboutUs extends AbstractDataErrors {
	/* ------------------ Konstruktorfunktionen --------------------------------- */
	/**
	 * Default-Konstruktor.
	 */
	public DataErrorsAboutUs() {}
	
	/* ---------------------------- Fehlerbehandlung ----------------------------------- */
	/**
	 * Überprüft, ob der neue Content valide ist.
	 * @param 	content			AboutUsContent	neuer Content
	 * @param 	bindingResult	BindingResult	zum anhängen der Fehler
	 * @return	boolean			true:			es liegen Fehler vor
	 * 							false:			es liegen keine Fehler vor
	 */
	public boolean hasErrors(AboutUsContent content, BindingResult bindingResult) {
		return bindingResult.hasErrors();
	}
	
}
