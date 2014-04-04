package fhwedel.medienprojekt.fussball.service.dataErrors;

/** externe Klassen */
import org.springframework.validation.BindingResult;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.comment.*;;



/**
 * Service
 * Übernimmt die Fehlerbehandlung für Foreneinträge.
 * 
 * @author Ellen Schwartau Minf9888
 *
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
}
