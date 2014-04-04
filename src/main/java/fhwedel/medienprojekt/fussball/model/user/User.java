package fhwedel.medienprojekt.fussball.model.user;

/**
 * User
 * repräsentiert einen Nutzer der Seite.
 * 
 * @author Ellen
 *
 */
public class User {
	/* --------------- Klassenvariablen ----------------- */
	/** ID */
	private int id;
	/** Username des Benutzers */
	private String username;
	/** eMail */
	private String email;
	/** Passwort des Benutzers */
	private String password;
	/** Zweite Passworteingabe bei Registrierung */
	private String passwordCompare;
	/** Gruppe des Users */
	// TODO Permission setzen
	private UserGroup userGroup;
	
	/* --------------- Konstruktorfunktionen ------------ */
	/**
	 * Default-Konstruktor.
	 */
	public User() {
		this("","","", UserGroup.USER_GROUP_NO_ADMIN);
	}
	
	/**
	 * Konstruktorfunktion
	 * @param username	String
	 * @param password	String
	 * @param email		String
	 * @param userGroup	UserGroup
	 */
	public User(String username, String password, String email, UserGroup userGroup) {
		// TODO Verschlüsselung?
		this.username = username;
		this.password = password;
		this.email = email;
		this.userGroup = userGroup;
	}
	
	
	/* --------------- Setter / Getter ------------------ */
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
	 * Liefert den Username des users.
	 * @return String
	 */
	public String getUsername() {
		return this.username;
	}
	/**
	 * Setzt den Username.
	 * @param username	String	Username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * Liefert das Passwort des Users.
	 * @return	String	Passwort
	 */
	public String getPassword() {
		return this.password;
	}
	/**
	 * Setzt das Passwort.
	 * @param password	String	Passwort
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Liefert das Passwort des Users.
	 * @return	String	Passwort
	 */
	public String getPasswordCompare() {
		return this.passwordCompare;
	}
	/**
	 * Setzt das Passwort.
	 * @param passwordCompare	String	Passwort Vergleich
	 */
	public void setPasswordCompare(String passwordCompare) {
		this.passwordCompare = passwordCompare;
	}
	/**
	 * Setzt die Email-Adresse des Users.
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
	 * Liefert die Gruppe zu der ein User gehört.
	 * @return	UserGroup	Gruppe
	 */
	public UserGroup getUserGroup() {
		return this.userGroup;
	}
	public String getUserGroupString() {
		if(this.userGroup == UserGroup.USER_GROUP_ADMIN) {
			return "USER_GROUP_ADMIN";
		}
		return "USER_GROUP_NO_ADMIN";
	}
	/**
	 * Setzt die Gruppe eines Users.
	 * @param userGroup	UserGroup	Gruppe
	 */
	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}
}
