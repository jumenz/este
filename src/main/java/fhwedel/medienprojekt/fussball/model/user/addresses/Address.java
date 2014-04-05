package fhwedel.medienprojekt.fussball.model.user.addresses;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import org.springframework.core.style.ToStringCreator;

/**
 * Address
 * Repräsentiert eine Adresse.
 * 
 * @author Julia
 *
 */
@Entity
@Table(name = "addresses")
public class Address {
	/* --------------- Klassenvariablen ----------------- */
	/** ID */
	@Column(name = "id")
	private int id;
	/** Name */
	@Column(name = "name")
	private String name;
	/** Vorname */
	@Column(name = "prename")
	private String prename;
	/** Geburtsdatum */
	@Column(name = "birthday")
	private String birthday;
	/** Handynummer */
    @Column(name = "mobile")
    @Digits(fraction = 0, integer = 15)
	private String mobile;
	/** Festnetznummer */
    @Column(name = "phone")
    @Digits(fraction = 0, integer = 15)
	private String phone;
	/** Straße */
	@Column(name = "street")
	private String street;
	/** Hausnummer */
	@Column(name = "nr")
	private String nr;
	/** PLZ */
    @Column(name = "zipcode")
    @Digits(fraction = 0, integer = 5)
	private String zipcode;
	/** Ort */
	@Column(name = "city")
	private String city;
	
	/* --------------- Konstruktorfunktionen ------------ */
	/**
	 * Default-Konstruktor.
	 */
	public Address() {
		this(0,"","","","","","","","","");
	}
	
	/**
	 * Konstruktorfunktion
	 * 
	 * @param id
	 * @param name
	 * @param prename
	 * @param birthday
	 * @param mobile
	 * @param phone
	 * @param street
	 * @param nr
	 * @param zipcode
	 * @param city
	 */
	public Address(int id, String name, String prename, String birthday, String mobile, String phone, String street, String nr, String zipcode, String city) {
		this.id = id;
		this.name = name;
		this.prename = prename;
		this.birthday = birthday;
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
		return this.name;
	}
	/**
	 * Setzt den Namen.
	 * @param String
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Liefert den Vorname.
	 * @return String Vorname
	 */
	public String getPrename() {
		return this.prename;
	}
	/**
	 * Setzt den Vorname.
	 * @param String Vorname
	 */
	public void setPrename(String prename) {
		this.prename = prename;
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
                .toString();
    }
}
