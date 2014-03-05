package fhwedel.medienprojekt.fussball.model.post.comment;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.Post;

/** externe Klassen  */
import java.util.ArrayList;
import java.util.List;

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
	 * @param dateTime	DateTime	Erstellungszeitpunkt
	 */
	public Comment(String topic, String text, String author, DateTime dateTime) {
		super(topic, text, author, dateTime);
	}
	
	/* --------- getter / setter ------------- */
}
