package fhwedel.medienprojekt.fussball.model.post.report;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.Post;
import fhwedel.medienprojekt.fussball.service.DataAccessForum;

/** externe Klassen */
import java.util.Date;

/**
 * Klasse zur Implementierung von Spielberichten.
 * 
 * @author Ellen
 *
 */
public class Report extends Post {
	/* ---------- Variablen ------------------ */
	/** Name des Gegners */
	//@Pattern(regexp=".*", message="Bitte gib den Namen des Gegners ein.")
	private String opponent;
	/** Spielstände */
	private int[] scores = new int[4];
	
	/* ---------- Funktionen ----------------- */
	/* --------- Konstruktor ----------------- */
	/**
	 * Default Konstruktor.
	 */
	public Report() {
		this("Kein Thema", "Kein Text", "Unbekannter Autor", new Date());
	}
	
	/**
	 * Konstruktorfunktion.
	 * @param topic		String		Thema
	 * @param text		String		Inhalt
	 * @param author	String		Author
	 * @param dateTime	Date		Erstellungszeitpunkt
	 */
	public Report(String topic, String text, String author, Date date) {
		this(topic, text, author, date, "", 0, 0, 0, 0);
	}
	
	/**
	 * Konstruktorfunktion.
	 * @param topic		String		Thema
	 * @param text		String		Inhalt
	 * @param author	String		Author
	 * @param dateTime	Date		Erstellungszeitpunkt
	 */
	public Report(	String topic, String text, String author, Date date, String opponent,
					int firstHalfHome, int firstHalfGuest, int secondHalfHome, int secondHalfGuest) {
		super(topic, text, author, date);
		this.opponent = opponent;
		setScore(Scores.FIRST_HALF_HOME, firstHalfHome);
		setScore(Scores.FIRST_HALF_GUEST, firstHalfGuest);
		setScore(Scores.SECOND_HALF_HOME, secondHalfHome);
		setScore(Scores.SECOND_HALF_GUEST, secondHalfGuest);
	}
	
	/* --------- getter / setter ------------- */
	/**
	 * Setzt den Namen des Gegners.
	 * @param opponent	Name
	 */
	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}
	/**
	 * Liefert den Namen des Gegners.
	 * @return String
	 */
	public String getOpponent() {
		return this.opponent;
	}
	/**
	 * Setzt einen Spielstand zu einer bestimmten Halbzeit.
	 * @param score		spezifiziert den zu setzenden Spielstand
	 * @param value		Spielstand
	 */
	public void setScore(Scores score, int value) {
		assert(value>=0);
		this.scores[score.ordinal()] = value;
	}
	/**
	 * Liefert den Spielstand einer Mannschaft zu einer bestimmten Halbzeit.
	 * @param score		gefragter Spielstand
	 * @return			Spielstand
	 */
	public int getScore(Scores score) {
		return this.scores[score.ordinal()];
	}
	
	/**
	 * Setzt die Id des Foren-Eintrags ausgehend von der Id in der Datenbank.
	 */
	public void setId() {
		/* Service holen */
		//DataAccessForum dataAccessService = new DataAccessForum();
		/* Id auslesen und speichern */
		//this.id = dataAccessService.getId(this);
	}
}
