/**
 * FH Wedel - Projekt Medieninformatik
 * 
 * Ellen Schwartau 	- Minf9888
 * Julia Menzel 	- Minf9950
 * 
 *  @date	2014-04-16
 *  @author	Ellen Schwartau Minf9888
 */
package fhwedel.medienprojekt.fussball.model.post.comment;

/** externe Klassen */
import java.util.Date;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.Post;


/**
 * Comments
 * Klasse zur Implementierung von Kommentaren.
 */
public class Comment extends Post {
	/* ---------- Variablen ------------------ */
	/** Verweis auf zugehörigen Forenbeitrag */
	private int refForumEntry;
	
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
	 * @param date		DateTime	Erstellungszeitpunkt
	 */
	public Comment(String topic, String text, String author, Date date) {
		// TODO Author auslesen, der den Kommentar verfasst hat
		super(topic, text, author, date);
	}
	
	/* ---------------- getter / setter ----------------------------- */
	/**
	 * Liefert die ID des Foreneintrags, zu dem der Kommentar gehört.
	 * @return 	int	Referenz auf Foreneintrag
	 */
	public int getRef() {
		return this.refForumEntry;
	}
	/**
	 * Setzt die Referenz des zugehörigen Foreneintrags.
	 * @param ref
	 */
	public void setRef(int ref) {
		this.refForumEntry = ref;
	}
	
}
