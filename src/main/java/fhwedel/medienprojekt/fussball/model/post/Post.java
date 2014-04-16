/**
 * FH Wedel - Projekt Medieninformatik
 * 
 * Ellen Schwartau 	- Minf9888
 * Julia Menzel 	- Minf9950
 * 
 *  @date	2014-04-16
 *  @author	Ellen Schwartau Minf9888
 */
package fhwedel.medienprojekt.fussball.model.post;

/** externe Klassen */
import java.util.Date;

/**
 * Post
 * Klasse für allgemeine Posts.
 * Enthält gemeinsame Variablen und setter/getter-Methoden.
 */
public abstract class Post {
	/* ---------- Variablen ------------------ */
	/** id des Eintrags */
	private int id;
	/** Thema des Beitrags */
	//@Pattern(regexp=".*", message="Bitte gib einen Titel ein.")
	private String topic;
	
	/** Inhalt des Beitrags */
	//@Pattern(regexp=".*", message="Bitte gib einen Text ein.")
	private String text;
	
	/** Zeit und Datum der Erstellung */
	//@Pattern(regexp=".*", message="Bitte gib Datum und Uhrzeit an.")
	private Date date;
	
	/** Autor des Beitrags */
	//@Pattern(regexp=".*", message="Der Author darf nicht leer sein.")
	private String author;
	
	/* ---------- Funktionen ----------------- */
	/* --------- Konstruktor ----------------- */
	/**
	 * Konstruiert die Klasse Post.
	 * @param topic		String		Thema des Beitrags
	 * @param text		String		Inhalt des Beitrags
	 * @param date		Date		Erstellungszeitpunkt
	 * @param author	String		Author
	 */
	public Post(String topic, String text, String author, Date date) {
		this.topic = topic;
		this.text = text;
		this.date = date;
		this.author = author;
	}
	
	/* --------- getter / setter ------------- */
	/**
	 * Setzt das Thema des Beitrags.
	 * @param topic
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	/**
	 * Liefert das Thema des Beitrags.
	 * @return String
	 */
	public String getTopic() {
		return this.topic;
	}
	
	/**
	 * Setzt den Text des Beitrags.
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Liefert den Text des Beitrags.
	 * @return String
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Setzt den Autor des Beitrags.
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * Liefert den Autor des Beitrags.
	 * @return String
	 */
	public String getAuthor() {
		return this.author;
	}
	
	/**
	 * Setzt den Zeitpunkt des Beitrags.
	 * @param date	Date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * Liefert den Zeitpunkt des Beitrags.
	 * @return DateTime
	 */
	public Date getDate() {
		return this.date;
	}
	
	/**
	 * Liefert die Id.
	 * return int
	 */
	public int getId() {
		return this.id;
	}
	/**
	 * Setzt die id.
	 * @param id	Wert der id
	 */
	public void setId(int id) {
		this.id = id;
	}
}
