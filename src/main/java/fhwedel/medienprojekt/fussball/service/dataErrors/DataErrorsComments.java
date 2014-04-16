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
import fhwedel.medienprojekt.fussball.model.post.comment.*;;

/**
 * Service
 * Übernimmt die Fehlerbehandlung für die Kommentare.
 */
public class DataErrorsComments extends AbstractDataErrorsPost<Comment> {
	/* ------------------ Konstruktorfunktionen --------------------------------- */
	/**
	 * Default-Konstruktor.
	 */
	public DataErrorsComments() {}
	
	/* ---------------------------- Fehlerbehandlung ----------------------------------- */
	/**
	 * Prüft einen Foreneintrag auf Richtigkeit.
	 * @param 	forumEntry		ForumEntry		Foreneintrag
	 * @param 	bindingResult	BindingResult	zum anhängen von Fehlern
	 * @return	boolean			true:			es liegen Fehler vor
	 * 							false:			es liegene keine Fehler vor
	 */
	public boolean hasErrors(Comment comment, BindingResult bindingResult) {
		/* Die Eingabefelder dürfen nicht leer sein */
		this.validateText(comment.getText(), bindingResult);
		return bindingResult.hasErrors();
	}
	
	/**
	 * Prüft, ob ein Text zum Foreneintrag angegeben ist.
	 * @param text			String			Text
	 * @param bindingResult	BindingResult	
	 * @param allowedLength	int				erlaubte Länge
	 * @param errorKey		String			Key der Längen-ErrorMessage
	 */
	@Override
	protected void validateText(String text, BindingResult bindingResult) {
		if(this.isEmpty(text)) {
			bindingResult.rejectValue("text", "error.post.text");
		}  else if (!this.checkLength(text, 1, 1000)) {
			bindingResult.rejectValue("text", "error.length.1000");
		}
	}
}
