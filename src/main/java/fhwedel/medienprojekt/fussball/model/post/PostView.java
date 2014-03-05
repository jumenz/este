package fhwedel.medienprojekt.fussball.model.post;

import java.util.ArrayList;
import java.util.List;

import fhwedel.medienprojekt.fussball.model.post.Post;

public class PostView<E extends Post> {
	/* ---------- Variablen ------------------ */
	private List<E> entries = new ArrayList<E>();
	
	/* ---------- Funktionen ----------------- */
	/* --------- Konstruktor ----------------- */
	public PostView() {}
	public PostView(List<E> entryList) {
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
