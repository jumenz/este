/**
 * FH Wedel - Projekt Medieninformatik
 * 
 * Ellen Schwartau 	- Minf9888
 * Julia Menzel 	- Minf9950
 * 
 *  @date	2014-04-16
 *  @author	Ellen Schwartau Minf9888
 */
package fhwedel.medienprojekt.fussball.service.dataErrors;

/** externe Klassen */
import org.springframework.validation.BindingResult;

/* ** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.statics.ImpressumContent;

/**
 * Service
 * Übernimmt die Fehlerbehandlung für das Impressum.
 */
public class DataErrorsImpressum extends AbstractDataErrors {
	/* ------------------ Konstruktorfunktionen --------------------------------- */
	/**
	 * Default-Konstruktor.
	 */
	public DataErrorsImpressum() {}
	
	/* ---------------------------- Fehlerbehandlung ----------------------------------- */
	/**
	 * Überprüft, ob der neue Content valide ist.
	 * @param 	content			ImpressumContent	neuer Content
	 * @param 	bindingResult	BindingResult	zum anhängen der Fehler
	 * @return	boolean			true:			es liegen Fehler vor
	 * 							false:			es liegen keine Fehler vor
	 */
	public boolean hasErrors(ImpressumContent content, BindingResult bindingResult) {
		this.validateText(content, bindingResult);
		return bindingResult.hasErrors();
	}
	
	/**
	 * Prüft den Text des Impressums, ob etwas eingetragen ist.
	 * @param content		ImpressumContent	neuer Inhalt
	 * @param bindingResult	BindingResult
	 */
	private void validateText(ImpressumContent content,  BindingResult bindingResult) {
		// Das Feld darf nicht leer sein und die Länge muss stimmen
		String text = content.getText();
		if(this.isEmpty(text)) {
			bindingResult.rejectValue("text", "error.impressum.empty");
		} else if (!this.checkLength(text, 1, 5000)) {
			bindingResult.rejectValue("text", "error.length.5000");
		}
	}
	
}
