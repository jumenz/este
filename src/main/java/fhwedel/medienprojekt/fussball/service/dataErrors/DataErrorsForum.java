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
import fhwedel.medienprojekt.fussball.model.post.forum.ForumEntry;

/**
 * Service
 * Übernimmt die Fehlerbehandlung für Foreneinträge.
 */
public class DataErrorsForum extends AbstractDataErrorsPost<ForumEntry> {
	/* ------------------ Konstanten -------------------------------------------- */
	final String placeholderDescription = "Beschreibung";
	
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
	 * Prüft, ob eine Kurzbeschreibung des Forneintrags angegeben ist.
	 * @param description	String			Kurzbeschreibung
	 * @param bindingResult	BindingResult
	 */
	private void validateDescription(String description, BindingResult bindingResult) {
		if(this.isEmpty(description)) {
			bindingResult.rejectValue("description", "error.forum.description");
		}  else if (!this.checkLength(description, 1, 500)) {
			bindingResult.rejectValue("description", "error.length.500");
		}
	}
	
}
