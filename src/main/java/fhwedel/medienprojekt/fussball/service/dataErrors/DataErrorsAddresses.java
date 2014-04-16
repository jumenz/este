/**
 * FH Wedel - Projekt Medieninformatik
 * 
 * Ellen Schwartau 	- Minf9888
 * Julia Menzel 	- Minf9950
 * 
 *  @date	2014-04-16
 *  @author	Julia Menzel 9950
 */
package fhwedel.medienprojekt.fussball.service.dataErrors;

/** externe Klassen */
import org.springframework.validation.BindingResult;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.user.addresses.Address;

/**
 * Service
 * Übernimmt die Fehlerbehandlung für das Adressbuch.
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
		if(this.isEmpty(name) || !this.isName(name)) {
			bindingResult.rejectValue("name", "error.address.name");
		}  else if (!this.checkLength(name, 1, 100)) {
			bindingResult.rejectValue("name", "error.length.100");
		}
	}
	
	/**
	 * Prüft, ob ein Vorname eingegeben wurde.
	 * @param name	String		Prename
	 * @param bindingResult		BindingResult
	 */
	private void validatePrename(String prename, BindingResult bindingResult) {
		if(this.isEmpty(prename) || !this.isName(prename)) {
			bindingResult.rejectValue("prename", "error.address.prename");
		} else if (!this.checkLength(prename, 1, 100)) {
			bindingResult.rejectValue("prename", "error.length.100");
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
		} else if (!this.checkLength(birthday, 1, 10)) {
			bindingResult.rejectValue("birthday", "error.length.10");
		}
	}
	
	/**
	 * Prüft, ob eine Handynummer eingegeben wurde.
	 * @param mobile	String		Handynummer
	 * @param bindingResult			BindingResult
	 */
	private void validateMobile(String mobile, BindingResult bindingResult) {
		if(!this.isEmpty(mobile) && !this.isPhoneNumber(mobile)) {
			bindingResult.rejectValue("mobile", "error.address.mobile.invalid");
		} else if (!this.checkLength(mobile, 1, 100)) {
			bindingResult.rejectValue("mobile", "error.length.100");
		}
	}
	
	/**
	 * Prüft, ob eine Festnetznummer eingegeben wurde.
	 * @param phone	String		Festnetznummer
	 * @param bindingResult		BindingResult
	 */
	private void validatePhone(String phone, BindingResult bindingResult) {
		if(!this.isEmpty(phone) && !this.isPhoneNumber(phone)) {
			bindingResult.rejectValue("phone", "error.address.phone.invalid");
		} else if (!this.checkLength(phone, 1, 100)) {
			bindingResult.rejectValue("phone", "error.length.100");
		}
	}
	
	/**
	 * Prüft, ob eine Straße eingegeben wurde.
	 * @param street	String		Straße
	 * @param bindingResult			BindingResult
	 */
	private void validateStreet(String street, BindingResult bindingResult) {
		if(this.isEmpty(street) || !this.isName(street)) {
			bindingResult.rejectValue("street", "error.address.street");
		}  else if (!this.checkLength(street, 1, 100)) {
			bindingResult.rejectValue("street", "error.length.100");
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
		} else if (!this.checkLength(nr, 1, 8)) {
			bindingResult.rejectValue("nr", "error.length.8");
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
		}  else if (!this.checkLength(zipcode, 1, 12)) {
			bindingResult.rejectValue("zipcode", "error.length.12");
		}
	}
	
	/**
	 * Prüft, ob ein Ort eingegeben wurde.
	 * @param city	String		Ort
	 * @param bindingResult		BindingResult
	 */
	private void validateCity(String city, BindingResult bindingResult) {
		if(this.isEmpty(city) || !this.isName(city)) {
			bindingResult.rejectValue("city", "error.address.city");
		} else if (!this.checkLength(city, 1, 100)) {
			bindingResult.rejectValue("city", "error.length.100");
		}
	}
}
