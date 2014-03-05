package fhwedel.medienprojekt.fussball.model.post;

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
	/** Thema des Beitrags */
	private String topic;
	
	/** Inhalt des Beitrags */
	private String text;
	
	/** Zeit und Datum der Erstellung */
	private DateTime dateTime;
	
	/** Autor des Beitrags */
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
	public Post(String topic, String text, String author, DateTime dateTime) {
		this.topic = topic;
		this.text = text;
		this.dateTime = dateTime;
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
	 * @param dateTime
	 */
	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	/**
	 * Liefert Datum und Zeit des Beitrags.
	 * @return DateTime
	 */
	public DateTime getDateTime() {
		return this.dateTime;
	}
}
