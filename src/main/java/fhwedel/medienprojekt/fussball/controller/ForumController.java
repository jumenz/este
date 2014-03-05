package fhwedel.medienprojekt.fussball.controller;

/** externe Klassen */
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@RequestMapping("/forum/")
	public String displayForum(Model model) {
		PostView<ForumEntry> view = new PostView<ForumEntry>();
		
		// TODO Einträge aus Datenbank auslesen
		ForumEntry entry = new ForumEntry("Erster Eintrag", "Etwas Text", "Author Eins", new DateTime());
		entry.setTopic("Forum Eintrag");
		view.addEntry(entry);
		
		// In jsp zugreifbar machen
		model.addAttribute("forumModel", view);
		
		return "forum";
	}
}
