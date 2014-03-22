package fhwedel.medienprojekt.fussball.controller;

/** externe Klassen */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import java.util.Date;

/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.PostView;
import fhwedel.medienprojekt.fussball.model.post.forum.ForumEntry;
import fhwedel.medienprojekt.fussball.service.DataAccessForum;


/**
 * Controller zur Anzeige des Forums.
 * @author Ellen
 *
 */
@Controller
public class ForumController {

	/** Service für die Datenbankarbeit */
	@Autowired
	private DataAccessForum dataAccess;

	/**
	 * Lädt das Forum
	 * @return string page name
	 */
	@RequestMapping(value="/forum/", method=RequestMethod.GET)
	public String displayForum(Model model) {
		PostView<ForumEntry> view = new PostView<ForumEntry>();
		
		// Einträge aus der Datenbank auslesen
		ArrayList<ForumEntry> list = this.dataAccess.getAll();
		for(int i=0; i<list.size(); i++) {
			view.addEntry(list.get(i));
		}
		
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
	
	/**
	 * Speichert einen neuen Foreneintrag.
	 * 
	 */
	@RequestMapping(value="/forum/neuer-eintrag/", method=RequestMethod.POST)
	public String saveNewForumEntry(ForumEntry newEntry, BindingResult bindingResult) {
		// Bei Fehlern wieder auf Formular redirecten
		if(bindingResult.hasErrors()) {
			return "forumNewEntry";
		}
		
		// sonst speichern und Forum laden
		this.dataAccess.save(newEntry);
		
		return "redirect:/forum/";
	}
}
