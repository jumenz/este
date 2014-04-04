package fhwedel.medienprojekt.fussball.model.user.addresses;

import java.util.ArrayList;
import java.util.List;

import fhwedel.medienprojekt.fussball.model.user.addresses.Address;

public class AddressView<E extends Address> {
	/* ---------- Variablen ------------------ */
	private List<E> entries = new ArrayList<E>();
	
	/* ---------- Funktionen ----------------- */
	/* --------- Konstruktor ----------------- */
	public AddressView() {}
	public AddressView(List<E> entryList) {
		this.entries = entryList;
	}
	
	/* --------- getter / setter ------------- */
	public List<E> getEntries() {
		return entries;
	}

	public void setEntries(List<E> entries) {
		this.entries = entries;
	}
	
	/* ---------- weitere Funktionen --------- */
	public void addEntry (E entry){
		entries.add(entry);
	}
}
