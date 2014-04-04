package fhwedel.medienprojekt.fussball.model.statics;

/**
 * Verwaltet die Texte für die Über-Uns Seite.
 * 
 * @author Ellen Schwartau Minf9888
 *
 */
public class AboutUsContent {
	/* ------------------ Klassenvariablen ----------------- */
	/** Texte, die auf der Über-uns Seite angezeigt werden sollen */
	/** Vereinstext */
	private String companyText;
	/** Text über das Team */
	private String teamText;
	/** Text über das Training */
	private String trainingText;
	/** Texte über die Trainer */
	private String trainerFirstPartText;
	private String trainerSecondPartText;
	/** Texte zur Anfahrt */
	private String approachPlayingFieldTrainingText;
	private String approachPlayingFieldMatchText;
	private String approachPublicTransportText;
	/** Kontakttext */
	private String contactText;
	
	/* ------------------ Konstruktorfunktionen ------------- */
	/**
	 * Default-Konstruktor.
	 */
	public AboutUsContent() {}
	
	/**
	 * Konstruktorfunktion.
	 * @param companyText						String	
	 * @param teamText							String
	 * @param trainerFirstPartText				String
	 * @param trainerSecondPartText				String
	 * @param approachPlayingFieldTrainingText	String
	 * @param approachPlayingFieldMatchText		String
	 * @param approachPublicTransportText		String
	 * @param contactText						String
	 */
	public AboutUsContent (	String companyText, String teamText, String trainingText, String trainerFirstPartText, String trainerSecondPartText, 
							String approachPlayingFieldTrainingText, String approachPlayingFieldMatchText, 
							String approachPublicTransportText, String contactText) {
		this.companyText = companyText;
		this.teamText = teamText;
		this.trainingText = trainingText;
		this.trainerFirstPartText = trainerFirstPartText;
		this.trainerSecondPartText = trainerSecondPartText;
		this.approachPlayingFieldMatchText = approachPlayingFieldMatchText;
		this.approachPlayingFieldTrainingText = approachPlayingFieldTrainingText;
		this.approachPublicTransportText = approachPublicTransportText;
		this.contactText = contactText;
	}
	
	/* ------------------ Setter / Getter ------------------- */
	/**
	 * Liefert den Text über den Verein.
	 * @return	String
	 */
	public String getCompanyText() {
		return this.companyText;
	}
	/**
	 * Setzt den Text über den Verein.
	 * @param text	String
	 */
	public void setCompanyText(String text) {
		this.companyText = text;
	}
	/**
	 * Liefert den Text über das Team
	 * @return	String
	 */
	public String getTeamText() {
		return this.teamText;
	}
	/**
	 * Setzt den Text über das Team.
	 * @param text	String
	 */
	public void setTeamText(String text) {
		this.teamText = text;
	}
	/**
	 * Liefert den Text über das Training
	 * @return	String
	 */
	public String getTrainingText() {
		return this.trainingText;
	}
	/**
	 * Setzt den Text über das Training
	 * @param text	String
	 */
	public void setTrainingText(String text) {
		this.trainingText = text;
	}
	/**
	 * Liefert den Text über den ersten Part der Trainer
	 * @return	String
	 */
	public String getTrainerFirstPartText() {
		return this.trainerFirstPartText;
	}
	/**
	 * Setzt den Text über den ersten Part der Trainer.
	 * @param text	String
	 */
	public void setTrainerFirstPartText(String text) {
		this.trainerFirstPartText = text;
	}
	/**
	 * Liefert den Text über den zweiten Part der Trainer
	 * @return	String
	 */
	public String getTrainerSecondPartText() {
		return this.trainerSecondPartText;
	}
	/**
	 * Setzt den Text über den zweiten Part der Trainer.
	 * @param text	String
	 */
	public void setTrainerSecondtPartText(String text) {
		this.trainerSecondPartText = text;
	}
	/**
	 * Liefert den Text über die Anfart zum Traingingssportplatz
	 * @return	String
	 */
	public String getApproachPlayingFieldTrainingText() {
		return this.approachPlayingFieldTrainingText;
	}
	/**
	 * Setzt den Text über die Anfart zum Traingingssportplatz.
	 * @param text	String
	 */
	public void setApproachPlayingFieldTrainingText(String text) {
		this.approachPlayingFieldTrainingText = text;
	}
	/**
	 * Liefert den Text über die Anfart zum Sportplatz für Spiele
	 * @return	String
	 */
	public String getApproachPlayingFieldMatchText() {
		return this.approachPlayingFieldMatchText;
	}
	/**
	 * Setzt den Text über die Anfart zum Traingingssportplatz.
	 * @param text	String
	 */
	public void setApproachPlayingFieldMatchText(String text) {
		this.approachPlayingFieldMatchText = text;
	}
	/**
	 * Liefert den Text über die Anfart über öffentliche Verkehrsmittel
	 * @return	String
	 */
	public String getApproachPublicTransportText() {
		return this.approachPublicTransportText;
	}
	/**
	 * Setzt den Text über die Anfart über öffentliche Verkehrsmittel.
	 * @param text	String
	 */
	public void setApproachPublicTransportText(String text) {
		this.approachPublicTransportText = text;
	}
	/**
	 * Liefert den Kontakt-Text
	 * @return	String
	 */
	public String getContactText() {
		return this.contactText;
	}
	/**
	 * Setzt den Kontakt-Text.
	 * @param text	String
	 */
	public void setContactText(String text) {
		this.contactText = text;
	}
}
