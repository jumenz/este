package fhwedel.medienprojekt.fussball.model.post.comment;

/** eigene Klassen */
import java.util.Date;

import fhwedel.medienprojekt.fussball.model.post.Post;

import org.joda.time.DateTime;

/**
 * Klasse zur Implementierung von Kommentaren.
 * 
 * @author Ellen
 *
 */
public class Comment extends Post {
	/* ---------- Variablen ------------------ */
	
	/* ---------- Funktionen ----------------- */
	/* --------- Konstruktor ----------------- */
	/**
	 * Konstruktorfunktion.
	 * @param topic		String		Thema
	 * @param text		String		Inhalt
	 * @param author	String		Author
	 * @param date		Date 		Erstellungszeitpunkt
	 */
	public Comment(String topic, String text, String author, Date date) {
		super(topic, text, author, date);
	}
	
	/* --------- getter / setter ------------- */
}
