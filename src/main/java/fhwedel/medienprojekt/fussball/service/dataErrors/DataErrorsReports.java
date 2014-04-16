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
		Integer scores[] = { 	new Integer(report.getScoreFirstHalfHome()), 
								new Integer(report.getScoreFirstHalfGuest()), 
								new Integer(report.getScoreSecondHalfHome()), 
								new Integer(report.getScoreSecondHalfGuest()) 
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
		}  else if (!this.checkLength(opponent, 1, 100)) {
			bindingResult.rejectValue("opponent", "error.length.100");
		}
	}
	
	/**
	 * Prüft, ob die Spielstände richtig angegeben werden.
	 * @param scores		int[]			Spielstände
	 * @param bindingResult	BindingResult
	 */
	private void validateScores(Integer scores[], BindingResult bindingResult) {
		for(int i=0; (i<scores.length) && !bindingResult.hasErrors(); i++) {
			if(!this.isNumeric(scores[i].toString())) {
				bindingResult.rejectValue(getErrorFieldString(i), "error.report.scores.onlynumbers");
			}
		}
	}
	
	/**
	 * Liefert den key des Errorfeldes.
	 * @param 	i
	 * @return	String	key
	 */
	private String getErrorFieldString(int i) {
		switch(i) {
		case 0:
			return "scoreFirstHalfHome";
		case 1:
			return "scoreFirstHalfGuest";
		case 2:
			return "scoreSecondHalfHome";
		case 3:
			return "scoreSecondHalfGuest";
		default:
			return "";
		}
	}
}
