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
	 * @param topic		String		Thema
	 * @param text		String		Inhalt
	 * @param author	String		Author
	 * @param dateTime	Date		Erstellungszeitpunkt
	 */
	public Comment(String topic, String text, String author, Date date) {
		super(topic, text, author, date);
	}
	
	/* --------- getter / setter ------------- */
}
