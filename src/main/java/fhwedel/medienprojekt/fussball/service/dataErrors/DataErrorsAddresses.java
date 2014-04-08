package fhwedel.medienprojekt.fussball.service.dataErrors;

/** externe Klassen */
import org.springframework.validation.BindingResult;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.user.addresses.Address;



/**
 * Service
 * Übernimmt die Fehlerbehandlung für das Adressbuch.
 * 
 * @author julia
 *
 */
public class DataErrorsAddresses extends AbstractDataErrors {
	/* ------------------ Konstanten -------------------------------------------- */
	final String placeholderDescription = "Beschreibung";
	
	/* ------------------ Konstruktorfunktionen --------------------------------- */
	/**
	 * Default-Konstruktor.
	 */
	public DataErrorsAddresses() {}
	
	/* ---------------------------- Fehlerbehandlung ----------------------------------- */
	/**
	 * Prüft einen Adresseintrag auf Richtigkeit.
	 * @param 	address			Address			Adresse
	 * @param 	bindingResult	BindingResult	zum anhängen von Fehlern
	 * @return	boolean			true:			es liegen Fehler vor
	 * 							false:			es liegene keine Fehler vor
	 */
	public boolean hasErrors(Address address, BindingResult bindingResult) {
		/* Die Eingabefelder dürfen nicht leer oder ungültig sein */
		this.validateName(address.getName(), bindingResult);
		this.validatePrename(address.getPrename(), bindingResult);
		this.validateBirthday(address.getBirthday(), bindingResult);
		this.validateEmail(address.getEmail(), bindingResult);
		this.validateMobile(address.getMobile(), bindingResult);
		this.validatePhone(address.getPhone(), bindingResult);
		this.validateStreet(address.getStreet(), bindingResult);
		this.validateNr(address.getNr(), bindingResult);
		this.validateZipcode(address.getZipcode(), bindingResult);
		this.validateCity(address.getCity(), bindingResult);
		return bindingResult.hasErrors();
	}
	
	/**
	 * Prüft, ob ein Name eingegeben wurde.
	 * @param name	String		Name
	 * @param bindingResult		BindingResult
	 */
	private void validateName(String name, BindingResult bindingResult) {
		if(this.isEmpty(name) || !this.onlyLetters(name)) {
			bindingResult.rejectValue("name", "error.address.name");
		}
	}
	
	/**
	 * Prüft, ob ein Vorname eingegeben wurde.
	 * @param name	String		Prename
	 * @param bindingResult		BindingResult
	 */
	private void validatePrename(String prename, BindingResult bindingResult) {
		if(this.isEmpty(prename) || !this.onlyLetters(prename)) {
			bindingResult.rejectValue("prename", "error.address.prename");
		}
	}
	
	/**
	 * Prüft, ob ein Geburtsdatum eingegeben wurde.
	 * @param birthday	String		Geburtsdatum
	 * @param bindingResult			BindingResult
	 */
	private void validateBirthday(String birthday, BindingResult bindingResult) {
		if(this.isEmpty(birthday) || !this.isDate(birthday)) {
			bindingResult.rejectValue("birthday", "error.address.birthday");
		}
	}
	
	/**
	 * Prüft, ob eine E-Mail eingegeben wurde.
	 * @param email	String		E-Mail
	 * @param bindingResult		BindingResult
	 */
	private void validateEmail(String email, BindingResult bindingResult) {
		if(this.isEmpty(email) || !this.isEmail(email)) {
			bindingResult.rejectValue("email", "error.email.invalid");
		}
	}
	
	/**
	 * Prüft, ob eine Handynummer eingegeben wurde.
	 * @param mobile	String		Handynummer
	 * @param bindingResult			BindingResult
	 */
	private void validateMobile(String mobile, BindingResult bindingResult) {
		if(this.isEmpty(mobile) || !this.isPhoneNumber(mobile)) {
			bindingResult.rejectValue("mobile", "error.address.mobile.invalid");
		}
	}
	
	/**
	 * Prüft, ob eine Festnetznummer eingegeben wurde.
	 * @param phone	String		Festnetznummer
	 * @param bindingResult		BindingResult
	 */
	private void validatePhone(String phone, BindingResult bindingResult) {
		if(this.isEmpty(phone) || !this.isPhoneNumber(phone)) {
			bindingResult.rejectValue("phone", "error.address.phone.invalid");
		}
	}
	
	/**
	 * Prüft, ob eine Straße eingegeben wurde.
	 * @param street	String		Straße
	 * @param bindingResult			BindingResult
	 */
	private void validateStreet(String street, BindingResult bindingResult) {
		if(this.isEmpty(street) || !this.onlyLetters(street)) {
			bindingResult.rejectValue("street", "error.address.street");
		}
	}
	
	/**
	 * Prüft, ob eine Hausnummer eingegeben wurde.
	 * @param nr	String		Hausnummer
	 * @param bindingResult		BindingResult
	 */
	private void validateNr(String nr, BindingResult bindingResult) {
		if(this.isEmpty(nr)) {
			bindingResult.rejectValue("nr", "error.address.nr");
		}
	}
	
	/**
	 * Prüft, ob eine PLZ eingegeben wurde.
	 * @param zipcode	String		PLZ
	 * @param bindingResult			BindingResult
	 */
	private void validateZipcode(String zipcode, BindingResult bindingResult) {
		if(this.isEmpty(zipcode) || !this.isNumeric(zipcode)) {
			bindingResult.rejectValue("zipcode", "error.address.zipcode.invalid");
		}
	}
	
	/**
	 * Prüft, ob ein Ort eingegeben wurde.
	 * @param city	String		Ort
	 * @param bindingResult		BindingResult
	 */
	private void validateCity(String city, BindingResult bindingResult) {
		if(this.isEmpty(city) || !this.onlyLetters(city)) {
			bindingResult.rejectValue("city", "error.address.city");
		}
	}
}
