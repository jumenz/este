package fhwedel.medienprojekt.fussball.model.post.forum;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.Post;
import fhwedel.medienprojekt.fussball.model.post.comment.Comment;


import fhwedel.medienprojekt.fussball.service.DataAccessForum;




import java.security.Timestamp;
import java.sql.Date;
import java.sql.Time;
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
	
	/** Kurzbeschreibung */
	//@Pattern(regexp=".*", message="Bitte gib eine Kurzbeschreibung ein.")
	private String description;
	
	/* ---------- Funktionen ----------------- */
	/* --------- Konstruktor ----------------- */
	/**
	 * Default Konstruktor.
	 */
	public ForumEntry() {
		this("Kein Thema", "Kein Inhalt", "unbekannter Author", new Date(1000), new Time(1000)); /* TODO rausfinden wie das geht */
	}
	
	/**
	 * Konstruktorfunktion.
	 * @param topic		String		Thema
	 * @param text		String		Inhalt
	 * @param author	String		Author
	 * @param dateTime	DateTime	Erstellungszeitpunkt
	 * @param comments	List		Kommentarliste
	 */
	public ForumEntry(String topic, String text, String author, Date date, Time time, String description, List<Comment> comments) {
		super(topic, text, author, date, time);
		this.comments = comments;
		this.description = description;
	}
	
	/**
	 * Konstruktorfunktion
	 * @param topic		String		Thema
	 * @param text		String		Inhalt
	 * @param author	String		Author
	 * @param dateTime	DateTime	Erstellungszeitpunkt
	 */
	public ForumEntry(String topic, String text, String author, Date date, Time time) {
		this(topic, text, author, date, time, "", new ArrayList<Comment>());
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
	
	/**
	 * Setzt die Id des Foren-Eintrags ausgehend von der Id in der Datenbank.
	 */
	public void setId() {
		/* Service holen */
		DataAccessForum dataAccessService = new DataAccessForum();
		/* Id auslesen und speichern */
		this.id = dataAccessService.getId(this);
	}
}
