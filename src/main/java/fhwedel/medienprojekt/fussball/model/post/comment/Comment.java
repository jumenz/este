package fhwedel.medienprojekt.fussball.model.post.comment;

/** externe Klassen */
import java.util.Date;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.Post;


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
	 */
	public Comment() {
		this("", "", "", new Date());
	}
	
	/**
	 * Konstruktorfunktion.
	 * @param topic		String		Thema
	 * @param text		String		Inhalt
	 * @param author	String		Author
	 * @param date		Date 		Erstellungszeitpunkt
	 */
	public Comment(String topic, String text, String author, Date date) {
		// TODO Author auslesen, der den Kommentar verfasst hat
		super(topic, text, author, date);
	}
	
}
