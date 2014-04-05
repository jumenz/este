package fhwedel.medienprojekt.fussball.service.dataErrors;

/** externe Klassen */
import org.springframework.validation.BindingResult;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.report.Report;


/**
 * Service
 * Übernimmt die Fehlerbehandlung für Spielberichte.
 * 
 * @author Ellen Schwartau Minf9888
 *
 */
public class DataErrorsReports extends AbstractDataErrorsPost<Report> {
	/* ------------------ Konstruktorfunktionen --------------------------------- */
	/**
	 * Default-Konstruktor.
	 */
	public DataErrorsReports() {}
	
	/* ---------------------------- Fehlerbehandlung ----------------------------------- */
	
	/**
	 * Prüft einen Spielbericht auf Richtigkeit.
	 * @param 	report			Report			Spielbericht
	 * @param 	bindingResult	BindingResult	zum Anhängen von Fehlern
	 * @return	boolean			true:			es liegen Fehler vor
	 * 							false:			es liegene keine Fehler vor
	 */
	public boolean hasErrors(Report report, BindingResult bindingResult) {
		int scores[] = { 	report.getScoreFirstHalfHome(), 
							report.getScoreFirstHalfGuest(), 
							report.getScoreSecondHalfHome(), 
							report.getScoreSecondHalfGuest() 
						};
		/* Alle Felder des Formulars zum Anlegen oder Bearbeiten eines Spielberichts
		 * müssen ausgefüllt sein
		 * Die Angaben zu den Spielständen müssen außerdem numerisch sein
		 */
		this.validateTopic(report.getTopic(), bindingResult);
		this.validateOpponent(report.getOpponent(), bindingResult);
		this.validateScores(scores, bindingResult);
		this.validateText(report.getText(), bindingResult);
		return bindingResult.hasErrors();
	}
		
	/**
	 * Prüft, ob der Gegner des Berichts angegeben ist.
	 * @param opponent		String			Name des Gegners
	 * @param bindingResult	BindingResult
	 */
	private void validateOpponent(String opponent, BindingResult bindingResult) {
		if(this.isEmpty(opponent)) {
			bindingResult.rejectValue("opponent", "error.report.opponent");
		}
	}
	
	/**
	 * Prüft, ob die Spielstände richtig angegeben werden.
	 * @param scores		int[]			Spielstände
	 * @param bindingResult	BindingResult
	 */
	private void validateScores(int scores[], BindingResult bindingResult) {
		// TODO
	}
}
