package fhwedel.medienprojekt.fussball.model.post.report;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.Post;

/** externe Klassen  */
import org.joda.time.DateTime;

/**
 * Klasse zur Implementierung von Spielberichten.
 * 
 * @author Ellen
 *
 */
public class Report extends Post {
	/* ---------- Variablen ------------------ */
	/** Name des Gegners */
	private String opponent;
	/** Spielstände */
	private int[] scores = new int[4];
	
	/* ---------- Funktionen ----------------- */
	/* --------- Konstruktor ----------------- */
	/**
	 * Konstruktorfunktion.
	 * @param topic		String		Thema
	 * @param text		String		Inhalt
	 * @param author	String		Author
	 * @param dateTime	DateTime	Erstellungszeitpunkt
	 */
	public Report(String topic, String text, String author, DateTime dateTime) {
		this(topic, text, author, dateTime, "", 0, 0, 0, 0);
	}
	
	/**
	 * Konstruktorfunktion.
	 * @param topic		String		Thema
	 * @param text		String		Inhalt
	 * @param author	String		Author
	 * @param dateTime	DateTime	Erstellungszeitpunkt
	 */
	public Report(	String topic, String text, String author, DateTime dateTime, String opponent,
					int firstHalfHome, int firstHalfGuest, int secondHalfHome, int secondHalfGuest) {
		super(topic, text, author, dateTime);
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
}
