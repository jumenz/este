package fhwedel.medienprojekt.fussball.model.post.report;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.Post;

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
	// private int[] scores = new int[4];
	private int scoreFirstHalfHome;
	private int scoreFirstHalfGuest;
	private int scoreSecondHalfHome;
	private int scoreSecondHalfGuest;
	/** Angabe, ob das Spiel ein Heimspiel war */
	private boolean homeMatch;
	
	/* ---------- Funktionen ----------------- */
	/* --------- Konstruktor ----------------- */
	/**
	 * Default Konstruktor.
	 */
	public Report() {
		this("", "", "", new Date());
	}
	
	/**
	 * Konstruktorfunktion.
	 * @param topic		String		Thema
	 * @param text		String		Inhalt
	 * @param author	String		Author
	 * @param dateTime	Date		Erstellungszeitpunkt
	 */
	public Report(String topic, String text, String author, Date date) {
		this(topic, text, author, date, "", true, 0, 0, 0, 0);
	}
	
	/**
	 * Konstruktorfunktion.
	 * @param topic				String		Thema
	 * @param text				String		Inhalt
	 * @param author			String		Author
	 * @param date				Date		Erstellungszeitpunkt
	 * @param opponent			String		Name des Gegners
	 * @param homeMatch			Boolean		Angabe, ob das Spiel ein Heimspiel war
	 * @param firstHalfHome,	int			Spielstände 
	 * 		  firstHalfGuest, 
	 * 		  secondHalfHome, 
	 * 		  secondHalfGuest	
	 */
	public Report(	String topic, String text, String author, Date date, String opponent, Boolean homeMatch,
					int firstHalfHome, int firstHalfGuest, int secondHalfHome, int secondHalfGuest) {
		super(topic, text, author, date);
		this.opponent = opponent;
		this.homeMatch = homeMatch;
		setScore(Scores.FIRST_HALF_HOME, firstHalfHome);
		setScore(Scores.FIRST_HALF_GUEST, firstHalfGuest);
		setScore(Scores.SECOND_HALF_HOME, secondHalfHome);
		setScore(Scores.SECOND_HALF_GUEST, secondHalfGuest);
	}
	
	/* ------------------------ getter / setter --------------------- */
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
	 * Liefert die Angabe, ob das Spiel ein Heimspiel war.
	 * @return	boolean
	 */
	public boolean getHomeMatch() {
		return this.homeMatch;
	}
	/**
	 * Setzt die Heimspieleigenschaft auf true oder false.
	 * @param	homeMatch	Angabe, ob das Spiel ein Heimspiel war
	 */
	public void setHomeMatch(boolean home) {
		this.homeMatch = home;
	}
	
	/* ------------- Punktestand ------------------- */
	/**
	 * Setzt den Puntkestand der Heimmannschaft zur Halbzeit.
	 * @param score		Punktestand
	 */
	public void setScoreFirstHalfHome(int score) {
		this.scoreFirstHalfHome = score;
	}
	/**
	 * Liefert den Punktestand der Heimmannschaft zur Halbzeit.
	 * @return int	Punktestand
	 */
	public int getScoreFirstHalfHome() {
		return this.scoreFirstHalfHome;
	}
	
	/**
	 * Setzt den Puntkestand der Gastmannschaft zur Halbzeit.
	 * @param score		Punktestand
	 */
	public void setScoreFirstHalfGuest(int score) {
		this.scoreFirstHalfGuest = score;
	}
	/**
	 * Liefert den Punktestand der Gastmannschaft zur Halbzeit.
	 * @return int	Punktestand
	 */
	public int getScoreFirstHalfGuest() {
		return this.scoreFirstHalfGuest;
	}
	
	/**
	 * Setzt den Puntkestand der Heimmannschaft zur Halbzeit.
	 * @param score		Punktestand
	 */
	public void setScoreSecondHalfHome(int score) {
		this.scoreSecondHalfHome = score;
	}
	/**
	 * Liefert den Punktestand der Heimmannschaft zur Halbzeit.
	 * @return int	Punktestand
	 */
	public int getScoreSecondHalfHome() {
		return this.scoreSecondHalfHome;
	}
	
	/**
	 * Setzt den Puntkestand der Heimmannschaft zur Halbzeit.
	 * @param score		Punktestand
	 */
	public void setScoreSecondHalfGuest(int score) {
		this.scoreSecondHalfGuest = score;
	}
	/**
	 * Liefert den Punktestand der Heimmannschaft zur Halbzeit.
	 * @return int	Punktestand
	 */
	public int getScoreSecondHalfGuest() {
		return this.scoreSecondHalfGuest;
	}
	
	/**
	 * Setzt einen Spielstand zu einer bestimmten Halbzeit.
	 * @param score		spezifiziert den zu setzenden Spielstand
	 * @param value		Spielstand
	 */
	public void setScore(Scores score, int value) {
		assert(value>=0);
		// this.scores[score.ordinal()] = value;
	}
	/**
	 * Liefert den Spielstand einer Mannschaft zu einer bestimmten Halbzeit.
	 * @param score		gefragter Spielstand
	 * @return			Spielstand
	 */
	//public int getScore(Scores score) {
		// return this.scores[score.ordinal()];
	//}
	
}
