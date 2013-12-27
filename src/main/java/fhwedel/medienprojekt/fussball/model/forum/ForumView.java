package fhwedel.medienprojekt.fussball.model.forum;

import java.util.ArrayList;
import java.util.List;

public class ForumView {
	
	private List<ForumEntry> entries = new ArrayList<ForumEntry>();

	public List<ForumEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<ForumEntry> entries) {
		this.entries = entries;
	}
	
	public void addEntry (ForumEntry entry){
		entries.add(entry);
	}

}
