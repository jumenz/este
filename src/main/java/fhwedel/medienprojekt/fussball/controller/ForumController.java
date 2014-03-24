package fhwedel.medienprojekt.fussball.controller;

/** externe Klassen */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;




/** eigene Klassen */
import fhwedel.medienprojekt.fussball.model.post.PostView;
import fhwedel.medienprojekt.fussball.model.post.comment.Comment;
import fhwedel.medienprojekt.fussball.model.post.forum.ForumEntry;
import fhwedel.medienprojekt.fussball.service.DataAccessForum;
import fhwedel.medienprojekt.fussball.service.AbstractDataAccessPost;


/**
 * Controller zur Anzeige des Forums.
 * @author Ellen
 *
 */
@Controller
public class ForumController {
	/* ------------------ Klassenvariablen ------------------- */
	/** Service für die Datenbankarbeit */
	@Autowired
	private DataAccessForum dataAccess;

	
	/* ------------------ Methoden --------------------------- */
	/* ------------------ Anzeige ---------------------------- */
	/**
	 * Lädt das Forum
	 * @param Model
	 * @return string page name
	 */
	@RequestMapping(value="/forum/", method=RequestMethod.GET)
	public String displayForum(Model model) {
		PostView<ForumEntry> view = new PostView<ForumEntry>();
		
		// Einträge aus der Datenbank auslesen
		ArrayList<ForumEntry> list = this.dataAccess.getAll();

		// Kommentarliste laden
		for (int j=0; j<list.size(); j++) {
			Integer id = list.get(j).getId();
			ArrayList<Comment> comments = this.dataAccess.getComments(id);
			list.get(j).setComments(comments);
		}
		
		for(int i=0; i<list.size(); i++) {
			view.addEntry(list.get(i));
		}
		
		// In jsp zugreifbar machen
		model.addAttribute("forumModel", view);
		// Neuen Kommentar anfügen, um Speichern zu ermöglichen
		model.addAttribute("newComment", new Comment());
		
		return "forum";
	}
	
	// TODO vorherige und folgende Funktion zusammenfassen
	
	/**
	 * Liefert Foreneinträge, die mit bestimmtem String beginnen.
	 * 
	 */
	@RequestMapping(value="/forum/{sub}", method=RequestMethod.GET)
	public String getForumEntriesStartingWith(@PathVariable String sub, Model model) {
		PostView<ForumEntry> view = new PostView<ForumEntry>();
		
		// Einträge aus der Datenbank auslesen, die mit Substring beginnen
		ArrayList<ForumEntry> list = this.dataAccess.getAllStartingWith(sub);
		for(int i=0; i<list.size(); i++) {
			view.addEntry(list.get(i));
		}
		
		// In jsp zugreifbar machen
		model.addAttribute("forumModel", view);
		// Neuen Kommentar anfügen
		model.addAttribute("comment", new Comment());
		
		return "forum";
	}
	
	/**
	 * Liefert Foreneinträge, die mit bestimmtem String beginnen.
	 * 
	 */
	@RequestMapping(value="/forum/~{sub}", method=RequestMethod.GET)
	public String getForumEntriesIncluding(@PathVariable String sub, Model model) {
		PostView<ForumEntry> view = new PostView<ForumEntry>();
		
		// Einträge aus der Datenbank auslesen, die den Substring enthalten
		ArrayList<ForumEntry> list = this.dataAccess.getAllIncluding(sub);
		for(int i=0; i<list.size(); i++) {
			view.addEntry(list.get(i));
		}
		
		// In jsp zugreifbar machen
		model.addAttribute("forumModel", view);
		// Neuen Kommentar anfügen
		model.addAttribute("comment", new Comment());
		
		return "forum";
	}
	
	/**
	 * Ermöglicht die Suche über das Suchfeld der Sidebar und leitet auf die 
	 * URL der Form "/forum/~<Sucheingabe>" weiter
	 * @param 	src		String nach dem gesucht wird
	 * @return	String	url
	 */
	@RequestMapping(value="/forum/?search={src}", method=RequestMethod.GET)
	public String searchEntries(@PathVariable String src) {
		// Auf entsprechenden Pfad weiterleiten
		return "redirect:/forum/~" + src;
		// TODO geht noch nicht
	}
	
	/* ------------------ Neue Einträge -------------------------------- */
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
	
	/* --------------------- Kommentare ----------------------------*/
	/**
	 * Speichert einen neuen Foreneintrag.
	 * 
	 */
	@RequestMapping(value="/forum/neuer-kommentar/{id}", method=RequestMethod.POST)
	public String saveNewForumComment(@PathVariable int id, Comment newComment, BindingResult bindingResult) {
		// Bei Fehlern wieder auf Formular redirecten
		if(bindingResult.hasErrors()) {
			return "forum";
		}
		
		// sonst speichern und Forum laden
		this.dataAccess.saveComment(newComment, id);
		
		return "redirect:/forum/";
	}

}
