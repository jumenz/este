package fhwedel.medienprojekt.fussball.controller;

/** externe Klassen */
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.PostView;
import fhwedel.medienprojekt.fussball.model.post.forum.ForumEntry;

/**
 * Controller zur Anzeige des Forums.
 * @author Ellen
 *
 */
@Controller
public class ForumController {
	
	/**
	 * Lädt das Forum
	 * @return string page name
	 */
	@RequestMapping(value="/forum/", method=RequestMethod.GET)
	public String displayForum(Model model) {
		PostView<ForumEntry> view = new PostView<ForumEntry>();
		
		// TODO Einträge aus Datenbank auslesen
		ForumEntry entry = new ForumEntry("Erster Eintrag", "Etwas Text", "Author Eins", new Date());
		entry.setTopic("Forum Eintrag");
		view.addEntry(entry);
		
		// In jsp zugreifbar machen
		model.addAttribute("forumModel", view);
		
		return "forum";
	}
	
	/**
	 * Lädt das Formular zum Erstellen eines neuen Foreneintrags.
	 * @param 	model	Model
	 * @return	Name der jsp
	 */
	@RequestMapping(value="/forum/neuer-eintrag/", method=RequestMethod.GET)
	public String displayNewForumEntryForm(Model model) {
		// Neues ForumEntry Objekt in jsp zugreifbar machen
		model.addAttribute(new ForumEntry());
		// Formular laden
		return "forumNewEntry";
	}
}
