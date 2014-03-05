package fhwedel.medienprojekt.fussball.model.post.forum;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.Post;
import fhwedel.medienprojekt.fussball.model.post.comment.Comment;


/** externe Klassen  */
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

/**
 * Klasse zur Implementierung von Forenbeiträgen.
 * 
 * @author Ellen
 *
 */
public class ForumEntry extends Post {
	/* ---------- Variablen ------------------ */
	/** Kommentarliste */
	private List<Comment> comments = new ArrayList<Comment>();
	
	/* ---------- Funktionen ----------------- */
	/* --------- Konstruktor ----------------- */
	/**
	 * Konstruktorfunktion.
	 * @param topic		String		Thema
	 * @param text		String		Inhalt
	 * @param author	String		Author
	 * @param dateTime	DateTime	Erstellungszeitpunkt
	 * @param comments	List		Kommentarliste
	 */
	public ForumEntry(String topic, String text, String author, DateTime dateTime, List<Comment> comments) {
		super(topic, text, author, dateTime);
		this.comments = comments;
	}
	
	/**
	 * Konstruktorfunktion
	 * @param topic		String		Thema
	 * @param text		String		Inhalt
	 * @param author	String		Author
	 * @param dateTime	DateTime	Erstellungszeitpunkt
	 */
	public ForumEntry(String topic, String text, String author, DateTime dateTime) {
		this(topic, text, author, dateTime, new ArrayList<Comment>());
	}
	
	/* --------- getter / setter ------------- */
	/**
	 * Setzt die Kommentarliste des Forenbeitrags.
	 * @param comments
	 */
	public void setCommentList(List<Comment> comments) {
		this.comments = comments;
	}
	
	/**
	 * Liefert die Kommentarliste des Forenbeitrags.
	 * @return
	 */
	public List<Comment> getCommentList() {
		return this.comments;
	}
}
