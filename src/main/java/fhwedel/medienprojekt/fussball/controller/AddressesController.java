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
 * @author Julia
 **/

@Controller
public class AddressesController {
	
	/* ---------------- Klassenvariablen --------------------- */
	/** Service für die Datenbankarbeit */
	@Autowired
	private DataAccessAddresses dataAccess;
	
	/* --------------------- Anzeige -------------------------------- */
	/**
	 * Bereitet das Anzeigen der Registerseite vor.
	 * @param 	model	Model
	 * @return	String	Viewname der JSP
	 */
	private String prepareAddressesDisplay(Model model) {
		AddressView<Address> addresses = new AddressView<Address>();
		// Einträge aus der Datenbank auslesen
		ArrayList<Address> list = this.dataAccess.getAll();
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
	 * @param	model	Model
	 * @return	String	Name des JSP
	 */
	@RequestMapping(value=Constants.linkAddresses, method=RequestMethod.GET)
	public String displayAddresses(Model model) {
		return this.prepareAddressesDisplay(model);
	}

	
	/* --------------- neue Adresse eintragen ----------- */	
	/**
	 * Neue Adresse hinzufügen.
	 * 
	 * @param 	address				neue Adresse
	 * @param 	bindingResult		BindingResult
	 * @param 	model				Model
	 * @return	String				Redirect auf Adressbuch
	
	@RequestMapping(value=Constants.linkAddressesNew, method=RequestMethod.POST)
	public String add(Address address, BindingResult bindingResult, Model model) {
		// Bei Fehlern wieder auf Formular redirecten
		if(bindingResult.hasErrors()) {
			return this.prepareAddressesDisplay(model);
		}
		
		// User speichern, wenn dieser zur Registrierung zugelassen wurde
		this.dataAccess.save(address);
		
		return Constants.redirectAddresses;
	} */
	
	/* -------------------- neue Adresse eintragen bzw leere Adresse mit Inhalt füllen ------------------------ */
	/**
	 * Lädt die Seite zum bearbeiten einer bestehenden Adresse.
	 * @param 	id		int		ID der Adresse 
	 * @param 	model	Model
	 * @return	String	Viewname zum mappen der JSP
	 
	@RequestMapping(value=Constants.linkAddressesEdit, method=RequestMethod.GET)
	public String loadEditForm(Model model) {
		Address addressEdit = new Address();
		model.addAttribute("addressEditModel", addressEdit);
		return Constants.redirectAddresses;
	}*/
	
	/**
	 * Speichert eine editierte Adresse mit entsprechender ID.
	 * @param id			PathVariable	ID der Adresse
	 * @param address		Address			Adresse
	 * @param bindingResult	BindingResult
	 * @return	String		Redirect auf die Adressbuchseite
	 
	@RequestMapping(value=Constants.linkAddresses, method=RequestMethod.PUT)
	public String edit(Address addressEdit, BindingResult bindingResult) {
	//public String edit(@PathVariable int id, Address address, BindingResult bindingResult) {
		// Bei Fehlern erneut Formular aufrufen
		if(bindingResult.hasErrors()) {
			return Constants.viewNameAddresses;
		}
		
		// Speichern und Spielberichte laden
		this.dataAccess.update(addressEdit);
		
		// jsp zum Erstellen eines neuen Berichts laden
		return Constants.redirectAddresses;
	}*/
	
	/**
	 * Speichert eine editierte Adresse mit entsprechender ID.
	 * @param id			PathVariable	ID der Adresse
	 * @param updateAddress	Address			Adresse
	 * @param bindingResult	BindingResult
	 * @return	String		Redirect auf die Adressbuchseite
	 */
	@RequestMapping(value=Constants.linkAddressesEdit + "{id}/", method=RequestMethod.POST)
	public String edit(@PathVariable int id, Address updateAddress, BindingResult bindingResult) {
	//public String edit(@PathVariable int id, Address address, BindingResult bindingResult) {
		// Bei Fehlern erneut Formular aufrufen
		if(bindingResult.hasErrors()) {
			return Constants.viewNameAddresses;
		}
		
		// Speichern und Spielberichte laden
		this.dataAccess.update(id, updateAddress);
		
		// jsp zum Erstellen eines neuen Berichts laden
		return Constants.redirectAddresses;
	}
	
	/* --------------------Adresse löschen --------------------------- */
	/**
	 * Löscht eine Email-Adresse auf der Permission Tabelle, der zugehörige User
	 * wird ebenfalls gelöscht, falls einer vorhanden ist.
	 * @param	id		PathVariable	id der Adresse, die gelöscht werden soll
	 * @return	String	Redirect auf die Adressbuchseite
	 */
	@RequestMapping(value=Constants.linkAddressesDelete + "{id}/", method=RequestMethod.POST)
	public String delete(@PathVariable int id) {
		// User speichern, wenn dieser zur Registrierung zugelassen wurde
		this.dataAccess.delete(id);
		
		return Constants.redirectAddresses;
	}

}
