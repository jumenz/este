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
public class DataErrorsReports extends AbstractDataErrors {
	/* ------------------ Konstanten -------------------------------------------- */
	final String placeholderEmail = "E-Mail Adresse";
	
	/* ------------------ Konstruktorfunktionen --------------------------------- */
	/**
	 * Default-Konstruktor.
	 */
	public DataErrorsReports() {}
	
	/* ---------------------------- Fehlerbehandlung ----------------------------------- */
	
	/**
	 * Prüft einen Spielbericht auf Richtigkeit.
	 * @param 	report			Report			Spielbericht
	 * @param 	bindingResult	BindingResult	zum anhängen von Fehlern
	 * @return	boolean			true:			es liegen Fehler vor
	 * 							false:			es liegene keine Fehler vor
	 */
	public boolean hasErrors(Report report, BindingResult bindingResult) {
		return bindingResult.hasErrors();
	}
	
}
