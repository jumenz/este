/**
 * FH Wedel - Projekt Medieninformatik
 * 
 * Ellen Schwartau 	- Minf9888
 * Julia Menzel 	- Minf9950
 * 
 *  @date	2014-04-16
 *  @author	Ellen Schwartau Minf9888
 */
package fhwedel.medienprojekt.fussball.model.statics;

/**
 * ImpressumContent
 * Verwaltet den Inhalt des Impressums.
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
