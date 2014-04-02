package fhwedel.medienprojekt.fussball.service.dataErrors;

/** externe Klassen */
import org.springframework.validation.BindingResult;



/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.forum.ForumEntry;



/**
 * Service
 * Übernimmt die Fehlerbehandlung für Foreneinträge.
 * 
 * @author Ellen Schwartau Minf9888
 *
 */
public class DataErrorsForum extends AbstractDataErrors {
	/* ------------------ Konstanten -------------------------------------------- */
	final String placeholderTopic = "Titel";
	final String placeholderDescription = "Beschreibung";
	final String placeholderText = "Tippe hier deinen Text";
	
	/* ------------------ Konstruktorfunktionen --------------------------------- */
	/**
	 * Default-Konstruktor.
	 */
	public DataErrorsForum() {}
	
	/* ---------------------------- Fehlerbehandlung ----------------------------------- */
	/**
	 * Prüft einen Foreneintrag auf Richtigkeit.
	 * @param 	forumEntry		ForumEntry		Foreneintrag
	 * @param 	bindingResult	BindingResult	zum anhängen von Fehlern
	 * @return	boolean			true:			es liegen Fehler vor
	 * 							false:			es liegene keine Fehler vor
	 */
	public boolean hasErrors(ForumEntry forumEntry, BindingResult bindingResult) {
		/* Die Eingabefelder dürfen nicht leer sein */
		this.validateText(forumEntry.getText(), bindingResult);
		this.validateDescription(forumEntry.getDescription(), bindingResult);
		this.validateTopic(forumEntry.getTopic(), bindingResult);
		return bindingResult.hasErrors();
	}
	
	/**
	 * Prüft, ob der Titel des Foreneintrags nicht leer ist.
	 * @param title			String			Titel
	 * @param bindingResult	BindingResult
	 */
	private void validateTopic(String title, BindingResult bindingResult) {
		if(this.isEmpty(title, this.placeholderTopic)) {
			bindingResult.rejectValue("topic", "error.forum.topic");
		}
	}
	
	/**
	 * Prüft, ob eine Kurzbeschreibung des Forneintrags angegeben ist.
	 * @param description	String			Kurzbeschreibung
	 * @param bindingResult	BindingResult
	 */
	private void validateDescription(String description, BindingResult bindingResult) {
		if(this.isEmpty(description, this.placeholderDescription)) {
			bindingResult.rejectValue("description", "error.forum.description");
		}
	}

	/**
	 * Prüft, ob ein Text zum Foreneintrag angegeben ist.
	 * @param text			String			Text
	 * @param bindingResult	BindingResult	
	 */
	private void validateText(String text, BindingResult bindingResult) {
		if(this.isEmpty(text, this.placeholderText)) {
			bindingResult.rejectValue("text", "error.forum.text");
		}
	}
	
}
