package fhwedel.medienprojekt.fussball.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	 * Lädt das Formular zum editieren einer Adresse.
	 * @param 	id		int		ID der Adresse, die bearbeitet werden soll
	 * @param 	model	Model	
	 * @return	String	Viewname des Formulars
	 */
	@RequestMapping(value=Constants.linkAddressEdit, method=RequestMethod.GET)
	public String loadEditForm(@PathVariable int id, Model model) {
		// Adresse auslesen
		model.addAttribute("addressEditModel", this.dataAccessAddresses.getById(id));
		return Constants.viewNameAddressEdit;
	}

	/**
	 * Speichert eine editierte Adresse mit entsprechender ID.
	 * @param 	id				int				Id der bearbeiteten Adresse
	 * @param	address			Address			bearbeitete Adresse
	 * @param 	bindingResult	BindingResult	
	 * @return
	 */
	@RequestMapping(value=Constants.linkAddressEdit, method=RequestMethod.POST)
	public String edit(@PathVariable int id, @ModelAttribute("addressEditModel") Address address, BindingResult bindingResult) {
		// Bei Fehlern erneut Formular aufrufen
		if(bindingResult.hasErrors()) {
		//if(bindingResult.hasErrors() || this.dataErrorsAddresses.hasErrors(addressEditModel, bindingResult)) {
			return Constants.viewNameAddressEdit;
		}
		
		// Speichern und Adressbuch laden
		this.dataAccessAddresses.update(id, address);
		
		// jsp zum Adressbuch
		return Constants.redirectAddresses;
	}
	
	/* -------------------- Adresse löschen --------------------------- */
	/**
	 * Löscht eine Adresse.
	 * @param	id		PathVariable	id der Adresse, die gelöscht werden soll
	 * @return	String	Redirect auf die Adressbuchseite
	 */
	@RequestMapping(value=Constants.linkAddressDelete, method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		// User speichern, wenn dieser zur Registrierung zugelassen wurde
		this.dataAccessAddresses.delete(id);
		return Constants.redirectAddresses;
	}
}
