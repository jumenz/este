package fhwedel.medienprojekt.fussball.model.post;

import java.sql.Date;
import java.sql.Time;

import org.joda.time.DateTime;

/**
 * Klasse für allgemeine Posts.
 * Enthält gemeinsame Variablen und setter/getter-Methoden.
 * 
 * @author Ellen
 *
 */
public class Post {
	/* ---------- Variablen ------------------ */
	/** id des Eintrags */
	protected int id;
	/** Thema des Beitrags */
	//@Pattern(regexp=".*", message="Bitte gib einen Titel ein.")
	private String topic;
	
	/** Inhalt des Beitrags */
	//@Pattern(regexp=".*", message="Bitte gib einen Text ein.")
	private String text;
	
	/** Zeit und Datum der Erstellung */
	//@Pattern(regexp=".*", message="Bitte gib Datum und Uhrzeit an.")
	private Date date;
	private Time time;
	
	/** Autor des Beitrags */
	//@Pattern(regexp=".*", message="Der Author darf nicht leer sein.")
	private String author;
	
	/* ---------- Funktionen ----------------- */
	/* --------- Konstruktor ----------------- */
	/**
	 * Konstruiert die Klasse Post.
	 * @param topic		String		Thema des Beitrags
	 * @param text		String		Inhalt des Beitrags
	 * @param dateTime	DateTime	Erstellungszeitpunkt
	 * @param author	String		Author
	 */
	public Post(String topic, String text, String author, Date date, Time time) {
		this.topic = topic;
		this.text = text;
		this.date = date;
		this.time = time;
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
	 * Setzt Datum und Zeit des Beitrags.
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * Liefert Datum und Zeit des Beitrags.
	 * @return DateTime
	 */
	public Date getDate() {
		return this.date;
	}
	
	/**
	 * Setzt Datum und Zeit des Beitrags.
	 * @param date
	 */
	public void setTime(Time time) {
		this.time = time;
	}
	
	/**
	 * Liefert Datum und Zeit des Beitrags.
	 * @return DateTime
	 */
	public Time getTime() {
		return this.time;
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
