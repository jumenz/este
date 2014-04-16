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

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.Post;

/**
 * Service
 * Beinhaltet gemeinsame Methoden der Fehlerbehandlung der erbenden Klassen.
 */
abstract class AbstractDataErrorsPost<E extends Post> extends AbstractDataErrors {
	/* ------------------ Konstruktorfunktionen --------------------------------- */
	/**
	 * Default-Konstruktor.
	 */
	public AbstractDataErrorsPost() {}
	
	/* ---------------------------- Fehlerbehandlung ----------------------------------- */
	/**
	 * Prüft einen Post auf Richtigkeit.
	 * @param 	entry			generischer Typ	Eintrag der geprüft werden soll
	 * @param 	bindingResult	BindingResult	zum Anhängen von Fehlern
	 * @return	boolean			true:			es liegen Fehler vor
	 * 							false:			es liegene keine Fehler vor
	 */
	public abstract boolean hasErrors(E entry, BindingResult bindingResult);
	
	/**
	 * Prüft, ob der Titel des Foreneintrags nicht leer ist.
	 * @param topic 		String			Titel
	 * @param bindingResult	BindingResult
	 */
	protected void validateTopic(String topic, BindingResult bindingResult) {
		if(this.isEmpty(topic)) {
			bindingResult.rejectValue("topic", "error.post.topic");
		}  if (!this.checkLength(topic, 1, 100)) {
			bindingResult.rejectValue("topic", "error.length.100");
		}
	}

	/**
	 * Prüft, ob ein Text zum Foreneintrag angegeben ist.
	 * @param text			String			Text
	 * @param bindingResult	BindingResult	
	 * @param allowedLength	int				erlaubte Länge
	 * @param errorKey		String			Key der Längen-ErrorMessage
	 */
	protected void validateText(String text, BindingResult bindingResult) {
		if(this.isEmpty(text)) {
			bindingResult.rejectValue("text", "error.post.text");
		}  else if (!this.checkLength(text, 1, 10000)) {
			bindingResult.rejectValue("text", "error.length.10000");
		}
	}
	
}
