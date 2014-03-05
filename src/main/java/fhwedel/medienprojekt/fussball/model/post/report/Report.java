package fhwedel.medienprojekt.fussball.model.post.report;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.Post;

/** externe Klassen  */
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

/**
 * Klasse zur Implementierung von Spielberichten.
 * 
 * @author Ellen
 *
 */
public class Report extends Post {
	/* ---------- Variablen ------------------ */
	// TODO weitere Variablen einfügen
	
	/* ---------- Funktionen ----------------- */
	/* --------- Konstruktor ----------------- */
	/**
	 * Konstruktorfunktion.
	 * @param topic		String		Thema
	 * @param text		String		Inhalt
	 * @param author	String		Author
	 * @param dateTime	DateTime	Erstellungszeitpunkt
	 */
	public Report(String topic, String text, String author, DateTime dateTime) {
		super(topic, text, author, dateTime);
	}
	
	/* --------- getter / setter ------------- */
	
}
