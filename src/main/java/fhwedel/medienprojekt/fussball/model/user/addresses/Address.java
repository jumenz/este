/**
 * FH Wedel - Projekt Medieninformatik
 * 
 * Ellen Schwartau 	- Minf9888
 * Julia Menzel 	- Minf9950
 * 
 *  @date	2014-04-16
 *  @author	Julia Menzel Minf9950
 */
package fhwedel.medienprojekt.fussball.model.user.addresses;

import org.springframework.core.style.ToStringCreator;

/**
 * Address
 * Repräsentiert eine Adresse.
 */
public class Address {
	/* --------------- Klassenvariablen ----------------- */
	/** ID */
	private int id;
	/** Name */
	private String name;
	/** Vorname */
	private String prename;
	/** E-Mail */
	private String email;
	private String birthday;
	/** Handynummer */
	private String mobile;
	/** Festnetznummer */
	private String phone;
	/** Straße */
	private String street;
	/** Hausnummer */
	private String nr;
	/** PLZ */
	private String zipcode;
	/** Ort */
	private String city;
	/** Username */
	private String username;
	
	/* --------------- Konstruktorfunktionen ------------ */
	/**
	 * Default-Konstruktor.
	 */
	public Address() {
		this(0,"","","","","","","","","","","");
	}
	
	/**
	 * Konstruktorfunktion
	 * 
	 * @param id
	 * @param name
	 * @param prename
	 * @param birthday
	 * @param email
	 * @param mobile
	 * @param phone
	 * @param street
	 * @param nr
	 * @param zipcode
	 * @param city
	 * @param username
	 */
	public Address(int id, String name, String prename, String birthday, String email, String mobile, 
			String phone, String street, String nr, String zipcode, String city, String username) {
		this.id = id;
		this.name = name;
		this.prename = prename;
		this.birthday = birthday;
		this.email = email;
		this.mobile = mobile;
		this.phone = phone;
		this.street = street;
		this.nr = nr;
		this.zipcode = zipcode;
		this.city = city;
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
	 * Liefert den Namen.
	 * @return String
	 */
	public String getName() {
		return this.name.toUpperCase();
	}
	/**
	 * Setzt den Namen.
	 * @param String
	 */
	public void setName(String name) {
		this.name = name.toUpperCase();
	}
	/**
	 * Liefert den Vorname.
	 * @return String Vorname
	 */
	public String getPrename() {
		return this.prename.toUpperCase();
	}
	/**
	 * Setzt den Vorname.
	 * @param String Vorname
	 */
	public void setPrename(String prename) {
		this.prename = prename.toUpperCase();
	}
	/**
	 * Liefert den Geburtstag.
	 * @return	String	Geburtstag
	 */
	public String getBirthday() {
		return this.birthday;
	}
	/**
	 * Setzt den Geburtstag.
	 * @param String Geburtstag
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * Liefert die E-Mail.
	 * @return	String	E-Mail
	 */
	public String getEmail() {
		return this.email;
	}
	/**
	 * Setzt die E-Mail.
	 * @param String E-Mail
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Liefert die Straße.
	 * @return	String	Straße
	 */
	public String getStreet() {
		return this.street;
	}
	/**
	 * Setzt die Straße.
	 * @param String Straße
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * Liefert die Hausnummer.
	 * @return String Hausnummer
	 */
	public String getNr() {
		return this.nr;
	}
	/**
	 * Setzt die Hausnummer.
	 * @param String Hausnummer
	 */
	public void setNr(String nr) {
		this.nr = nr;
	}
	/**
	 * Liefert die PLZ.
	 * @return String PLZ
	 */
	public String getZipcode() {
		return this.zipcode;
	}
	/**
	 * Setzt die PLZ.
	 * @param String PLZ
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * Liefert die Stadt.
	 * @return String Stadt
	 */
	public String getCity() {
		return this.city;
	}
	/**
	 * Setzt die Stadt.
	 * @param String Stadt
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * Liefert die Handynummer.
	 * @return String Handynummer
	 */
	public String getMobile() {
		return this.mobile;
	}
	/**
	 * Setzt die Handynummer.
	 * @param String Handynummer
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * Liefert die Festnetznummer.
	 * @return String Festnetznummer
	 */
	public String getPhone() {
		return this.phone;
	}
	/**
	 * Setzt den Festnetznummer.
	 * @param String Festnetznummer
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * Liefert die Benutzernamen.
	 * @return String Benutzernamen
	 */
	public String getUsername() {
		return this.username;
	}
	/**
	 * Setzt den Benutzernamen.
	 * @param String Benutzernamen
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String toString() {
        return new ToStringCreator(this)

                .append("id", this.id)
                .append("name", this.name)
                .append("prename", this.prename)
                .append("birthday", this.birthday)
                .append("mobile", this.mobile)
                .append("phone", this.phone)
                .append("street", this.street)
                .append("nr", this.nr)
                .append("zipcode", this.zipcode)
                .append("city", this.city)
                .append("username", this.username)
                .toString();
    }
}
