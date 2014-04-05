package fhwedel.medienprojekt.fussball.model.statics;

/**
 * Verwaltet den Inhalt des Impressums.
 * 
 * @author Ellen Schwartau Minf9888
 *
 */
public class ImpressumContent {
	/* ------------------ Klassenvariablen ----------------- */
	/** Inhalt des Impressums */
	private String text;

	/* ------------------ Konstruktorfunktionen ------------- */
	/**
	 * Default-Konstruktor.
	 */
	public ImpressumContent() {}
	
	/**
	 * Konstruktorfunktion.
	 * @param text	String	Inhalt
	 */
	public ImpressumContent (String text) {
		this.text = text;
	}
	
	/* ------------------ Setter / Getter ------------------- */
	
	/**
	 * Liefert den Inhalt des Impressums.
	 * @return String
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * Setzt den Text des Impressums
	 * @param text	String
	 */
	public void setText(String text) {
		this.text = text;
	}
}
