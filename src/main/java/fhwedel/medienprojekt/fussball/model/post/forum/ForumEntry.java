package fhwedel.medienprojekt.fussball.model.post.forum;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.Post;
import fhwedel.medienprojekt.fussball.model.post.comment.Comment;

import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessForum;

/** externe Klassen  */
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


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
	
	/** Kurzbeschreibung */
	//@Pattern(regexp=".*", message="Bitte gib eine Kurzbeschreibung ein.")
	private String description;
	
	/* ---------- Funktionen ----------------- */
	/* --------- Konstruktor ----------------- */
	/**
	 * Default Konstruktor.
	 */
	public ForumEntry() {
		this("", "", "", new Date());
	}
	
	/**
	 * Konstruktorfunktion.
	 * @param topic		String		Thema
	 * @param text		String		Inhalt
	 * @param author	String		Author
	 * @param dateTime	Date		Erstellungszeitpunkt
	 * @param comments	List		Kommentarliste
	 */
	public ForumEntry(String topic, String text, String author, Date date, String description, List<Comment> comments) {
		super(topic, text, author, date);
		this.comments = comments;
		this.description = description;
	}
	
	/**
	 * Konstruktorfunktion
	 * @param topic		String		Thema
	 * @param text		String		Inhalt
	 * @param author	String		Author
	 * @param date		Date		Erstellungszeitpunkt
	 */
	public ForumEntry(String topic, String text, String author, Date date) {
		this(topic, text, author, date, "", new ArrayList<Comment>());
	}
	
	/* --------- getter / setter ------------- */
	/**
	 * Setzt die Kommentarliste des Forenbeitrags.
	 * @param comments
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	/**
	 * Liefert die Kommentarliste des Forenbeitrags.
	 * @return
	 */
	public List<Comment> getComments() {
		return this.comments;
	}
	
	/**
	 * Setzt die Kurzbeschreibung des Foreneintrags.
	 * @param description	Kurzbeschreibung
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Liefert die Kurzbeschreibung des Foreneintrags.
	 * @return	String
	 */
	public String getDescription() {
		return this.description;
	}
}
