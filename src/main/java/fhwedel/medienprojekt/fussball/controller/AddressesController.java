package fhwedel.medienprojekt.fussball.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/** eigene Klassen */
import fhwedel.medienprojekt.fussball.controller.Constants;
import fhwedel.medienprojekt.fussball.model.user.addresses.Address;
import fhwedel.medienprojekt.fussball.model.user.addresses.AddressView;
import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessAddresses;


/**
 * AddressesController
 * 
 * @author Julia
 **/

@Controller
public class AddressesController {
	
	/* ---------------- Klassenvariablen --------------------- */
	/** Service für die Datenbankarbeit */
	@Autowired
	private DataAccessAddresses dataAccessAddresses;
	
	/* --------------------- Anzeige -------------------------------- */
	/**
	 * Bereitet das Anzeigen der Registerseite vor.
	 * @param 	model	Model
	 * @return	String	Viewname der JSP
	 */
	private String prepareAddressesDisplay(Model model) {
		AddressView<Address> addresses = new AddressView<Address>();
		// Einträge aus der Datenbank auslesen
		ArrayList<Address> list = this.dataAccessAddresses.getAll();
		for(int i=0; i<list.size(); i++) {
			addresses.addEntry(list.get(i));
		}
		
		// In jsp zugreifbar machen
		model.addAttribute("addressModel", addresses);
		model.addAttribute("updateAddressModel", new Address());
		
		return Constants.viewNameAddresses;
	}
	
	/**
	 * Lädt die Adressbuch Seite
	 * 
	 * @param	model	Model
	 * @return	String	Name des JSP
	 */
	@RequestMapping(value=Constants.linkAddresses, method=RequestMethod.GET)
	public String displayAddresses(Model model) {
		return this.prepareAddressesDisplay(model);
	}
	
	/* -------------------- Adresse bearbeiten ------------------------ */
	
	/**
	 * Speichert eine editierte Adresse mit entsprechender ID.
	 * 
	 * @param addressId		PathVariable	id der Adresse, die gelöscht werden soll
	 * @param updateAddress	Address			Adresse
	 * @param bindingResult	BindingResult
	 * @return	String		Redirect auf die Adressbuchseite
	 */
	@RequestMapping(value=Constants.linkAddresses, method=RequestMethod.POST)
	public String edit(@PathVariable int addressId, Address updateAddress, BindingResult bindingResult) {
		System.exit(addressId);
		// Bei Fehlern erneut Formular aufrufen
		if(bindingResult.hasErrors()) {
			return Constants.viewNameAddresses;
		}
		
		// Speichern und Seite laden
		this.dataAccessAddresses.update(updateAddress.getId(), updateAddress);
		return Constants.redirectAddresses;
	}
	
	/**
	 * Lädt die Adressbuch Seite neu
	 * @param	model	Model
	 * @return	String	Name des JSP
	 
	@RequestMapping(value=Constants.linkAddressesEdit, method=RequestMethod.GET)
	public String displayAddressesEdit(Model model) {
		return this.prepareAddressesDisplay(model);
	}*/
	
	/* -------------------- Adresse löschen --------------------------- */
	/**
	 * Löscht eine Adresse.
	 * @param	id		PathVariable	id der Adresse, die gelöscht werden soll
	 * @return	String	Redirect auf die Adressbuchseite
	 */
	@RequestMapping(value=Constants.linkAddressesDelete, method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		// User speichern, wenn dieser zur Registrierung zugelassen wurde
		this.dataAccessAddresses.delete(id);
		return Constants.redirectAddresses;
	}
}
