package fhwedel.medienprojekt.fussball.service.dataErrors;

/** externe Klassen */
import org.springframework.validation.BindingResult;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.statics.AboutUsContent;


/**
 * Service
 * Übernimmt die Fehlerbehandlung für die Über Uns Seite.
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
		this.validateTexts(content, bindingResult);
		return bindingResult.hasErrors();
	}
	
	/**
	 * Prüft alle Felder des neuen Content darauf, ob etwas eingetragen ist
	 * und hängt ggf. entsprechende Fehlermeldungen an, sollte ein Feld
	 * leer sein.
	 * @param content		AboutUsContent	neuer Inhalt
	 * @param bindingResult	BindingResult
	 */
	private void validateTexts(AboutUsContent content,  BindingResult bindingResult) {
		int lengthText = 5000;
		int lengthName = 50;
		/* Bei allen Feldern muss etwas eingetragen sein
		 * Die Texte dürfen nicht mehr als 5.000 Zeichen land sein
		 * Namen können maximal 50 Zeichen lang sein */
		if(this.isEmpty(content.getApproachPlayingFieldMatchText())) {
			bindingResult.rejectValue("approachPlayingFieldMatchText", "error.aboutus.empty");
		} else if (!this.checkLength(content.getApproachPlayingFieldMatchText(), 1, lengthText)) {
			bindingResult.rejectValue("approachPlayingFieldMatchText", "error.length.5000");
		}
		if(this.isEmpty(content.getApproachPlayingFieldTrainingText())) {
			bindingResult.rejectValue("approachPlayingFieldTrainingText", "error.aboutus.empty");
		} else if (!this.checkLength(content.getApproachPlayingFieldTrainingText(), 1, lengthText)) {
			bindingResult.rejectValue("approachPlayingFieldTrainingText", "error.length.5000");
		}
		if(this.isEmpty(content.getApproachPublicTransportText())) {
			bindingResult.rejectValue("approachPublicTransportText", "error.aboutus.empty");
		} else if (!this.checkLength(content.getApproachPublicTransportText(), 1, lengthText)) {
			bindingResult.rejectValue("approachPublicTransportText", "error.length.5000");
		}
		if(this.isEmpty(content.getCompanyText())) {
			bindingResult.rejectValue("companyText", "error.aboutus.empty");
		} else if (!this.checkLength(content.getCompanyText(), 1, lengthText)) {
			bindingResult.rejectValue("companyText", "error.length.5000");
		}
		if(this.isEmpty(content.getContactText())) {
			bindingResult.rejectValue("contactText", "error.aboutus.empty");
		} else if (!this.checkLength(content.getContactText(), 1, lengthText)) {
			bindingResult.rejectValue("contactText", "error.length.5000");
		}
		if(this.isEmpty(content.getTeamText())) {
			bindingResult.rejectValue("teamText", "error.aboutus.empty");
		} else if (!this.checkLength(content.getTeamText(), 1, lengthText)) {
			bindingResult.rejectValue("teamText", "error.length.5000");
		}
		if(this.isEmpty(content.getTrainerFirstName())) {
			bindingResult.rejectValue("trainerFirstName", "error.aboutus.empty");
		} else if (!this.checkLength(content.getTrainerFirstName(), 1, lengthName)) {
			bindingResult.rejectValue("trainerFirstName", "error.length.50");
		}
		if(this.isEmpty(content.getTrainerFirstText())) {
			bindingResult.rejectValue("trainerFirstText", "error.aboutus.empty");
		} else if (!this.checkLength(content.getTrainerFirstText(), 1, lengthText)) {
			bindingResult.rejectValue("trainerFirstText", "error.length.5000");
		}
		if(this.isEmpty(content.getTrainerSecondName())) {
			bindingResult.rejectValue("trainerSecondName", "error.aboutus.empty");
		} else if (!this.checkLength(content.getTrainerSecondName(), 1, lengthName)) {
			bindingResult.rejectValue("trainerSecondName", "error.length.50");
		}
		if(this.isEmpty(content.getTrainerSecondText())) {
			bindingResult.rejectValue("trainerSecondText", "error.aboutus.empty");
		} else if (!this.checkLength(content.getTrainerSecondText(), 1, lengthText)) {
			bindingResult.rejectValue("trainerSecondText", "error.length.5000");
		}
		if(this.isEmpty(content.getTrainingText())) {
			bindingResult.rejectValue("trainingText", "error.aboutus.empty");
		} else if (!this.checkLength(content.getTrainingText(), 1, lengthText)) {
			bindingResult.rejectValue("trainingText", "error.length.5000");
		}
	}
	
}
