package fhwedel.medienprojekt.fussball.model.user;

/**
 * Erlaubnis für bestimmte EMail-Adresse, sich als
 * User zu registrieren.
 * 
 * @author Ellen
 *
 */
public class Permission {
	/* ------------- Klassenvariablen ----------- */
	/** id */
	private int id;
	/** zugelassene EMail-Adresse */
	private String email;
	/** Adminstatus */
	private boolean adminStatus;
	
	/* ------------- Getter / Setter ------------ */
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
	/**
	 * Setzt die Email-Adresse der Users.
	 * @param email	String	Email-Adresse
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Liefert die Email-Adresse des Users.
	 * @return	String	Email-Adresse
	 */
	public String getEmail() {
		return this.email;
	}
	/**
	 * Setzt den Admin Status.
	 * @param 	adminStatus	boolean
	 */
	public void setAdminStatus(boolean adminStatus) {
		this.adminStatus = adminStatus;
	}
	/**
	 * Liefert den Admin Status.
	 * @return	Boolean
	 */
	public boolean getAdminStatus() {
		return this.adminStatus;
	}
}
