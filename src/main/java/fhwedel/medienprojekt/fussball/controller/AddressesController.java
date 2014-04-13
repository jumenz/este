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
import fhwedel.medienprojekt.fussball.model.user.User;
import fhwedel.medienprojekt.fussball.model.user.addresses.Address;
import fhwedel.medienprojekt.fussball.model.user.addresses.AddressView;
import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessAddresses;
import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessPermissions;
import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessUsers;
import fhwedel.medienprojekt.fussball.service.dataErrors.DataErrorsAddresses;
import fhwedel.medienprojekt.fussball.service.dataErrors.DataErrorsUsers;


/**
 * AddressesController
 * 
 * @author @author Julia Menzel minf9950
 **/

@Controller
public class AddressesController {
	
	/* ---------------- Klassenvariablen --------------------- */
	/** Service für die Datenbankarbeit */
	@Autowired
	private DataAccessAddresses dataAccessAddresses;
	
	@Autowired
	private DataAccessUsers dataAccessUsers;

	@Autowired
	private DataAccessPermissions dataAccessPermissions;
	
	/** Service zum prüfen von Errors */
	@Autowired
	private DataErrorsAddresses dataErrorsAddresses;

	@Autowired
	private DataErrorsUsers dataErrorsUsers;
	
	/* --------------------- Anzeige -------------------------------- */
	/**
	 * Bereitet das Anzeigen der Registerseite vor.
	 * @param 	model	Model
	 * @return	String	Viewname der JSP
	 */
	private String prepareAddressesDisplay(Model model) {
		AddressView<Address> addresses = new AddressView<Address>();
		// Adresseinträge aus der Datenbank auslesen
		ArrayList<Address> list = this.dataAccessAddresses.getAll();
		for(int i=0; i<list.size(); i++) {
			addresses.addEntry(list.get(i));
		}
		
		ArrayList<User> users = this.dataAccessUsers.getAll();
		
		// In jsp zugreifbar machen
		model.addAttribute("addressModel", addresses);
		model.addAttribute("userModel", users);
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
	 * @return	String	Viewname des Bearbeitungsformulars
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
	 * @return
	 */
	@RequestMapping(value=Constants.linkAddressEdit, method=RequestMethod.POST)
	public String edit(@ModelAttribute("addressEditModel") Address address, BindingResult bindingResult) {
		// Bei Fehlern erneut Formular aufrufen
		if(bindingResult.hasErrors()|| this.dataErrorsAddresses.hasErrors(address, bindingResult)) {
			return Constants.viewNameAddressEdit;
		}
		// Speichern und Adressbuch laden
		this.dataAccessAddresses.update(address);
		
		// jsp zum Adressbuch
		return Constants.redirectAddresses;
	}
	
	/**
	 * Speichert eine editierte Adresse mit entsprechender ID.
	 * @param 	id				int				Id der bearbeiteten Adresse
	 * @param	address			Address			bearbeitete Adresse
	 * @param 	bindingResult	BindingResult	
	 * @return
	 
	@RequestMapping(value=Constants.linkAddressEdit, method=RequestMethod.POST)
	public String edit(@PathVariable int id, @ModelAttribute("addressEditModel") Address address, BindingResult bindingResult) {
		// Bei Fehlern erneut Formular aufrufen
		if(bindingResult.hasErrors()|| this.dataErrorsAddresses.hasErrors(address, bindingResult)) {
			return Constants.viewNameAddressEdit;
		}
		// Speichern und Adressbuch laden
		this.dataAccessAddresses.update(id, address);
		
		// jsp zum Adressbuch
		return Constants.redirectAddresses;
	}*/
	
	/* -------------------- Adresse löschen --------------------------- */
	/**
	 * Löscht einen User und seine Adresse aufgehend von einer ID.
	 * @param	id		PathVariable	id des zu löschenden Users und seiner der Adresse
	 * @return	String	Redirect auf die Adressbuchseite
	 */
	@RequestMapping(value=Constants.linkAddressDelete, method=RequestMethod.GET) 
	public String deleteAccount(@PathVariable int id) {
		this.dataAccessAddresses.delete(id);
		this.dataAccessUsers.delete(id);
		this.dataAccessPermissions.remove(id);
		return Constants.redirectAddresses;
	}
}
