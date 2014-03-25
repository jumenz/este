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
import fhwedel.medienprojekt.fussball.service.dataAccess.AbstractDataAccessPost;
import fhwedel.medienprojekt.fussball.service.dataAccess.DataAccessForum;


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
	
	/** view name der Forums */
	final String forumViewName = "forum";
	
	/** view name für einen neuen Foreneintrag */
	final String forumNewEntryViewName = "forumNewEntry";
	
	/** Redirect auf die Forumsseite */
	final String forumRedirect ="redirect:/forum/";
	
	
	/* ------------------ Methoden --------------------------- */
	/* ------------------ Anzeige ---------------------------- */
	/**
	 * Hilfsfunktion.
	 * Fügt die Liste an einträgen dem Model an und stellt ein neues
	 * Comment Object bereit.
	 * @param 	list	ArrayList<ForumEntry>	Liste mit Foreneinträgen
	 * @param	model	Model
	 */
	public String prepareForumView(ArrayList<ForumEntry> list, Model model) {
		PostView<ForumEntry> view = new PostView<ForumEntry>();
		for(int i=0; i<list.size(); i++) {
			// Einträge hinzufügen
			view.addEntry(list.get(i));
		}
		// In jsp zugreifbar machen
		model.addAttribute("forumModel", view);
		// Neuen Kommentar anfügen, um Speichern zu ermöglichen
		model.addAttribute("newComment", new Comment());
		
		return this.forumViewName;
	}
	
	/**
	 * Lädt das Forum
	 * @param 	mode	Model
	 * @return  String 	Viewname
	 */
	@RequestMapping(value="/forum/", method=RequestMethod.GET)
	public String displayForum(Model model) {
		// Foreneinträge und Kommentare laden
		return this.prepareForumView(this.dataAccess.getAll(), model);
	}
	
	/**
	 * Liefert Foreneinträge, die mit bestimmtem String beginnen.
	 * @param	sub		String		gesuchter Anfangsstring
	 * @param	model	Model
	 */
	@RequestMapping(value="/forum/{sub}", method=RequestMethod.GET)
	public String getForumEntriesStartingWith(@PathVariable String sub, Model model) {
		// Einträge aus der Datenbank auslesen, die mit Substring beginnen
		return this.prepareForumView(this.dataAccess.getAllStartingWith(sub), model);
	}
	
	/**
	 * Liefert Foreneinträge, die mit bestimmtem String beginnen.
	 * @param	sub		String		gesuchter Substring
	 * @param	model	Model
	 */
	@RequestMapping(value="/forum/~{sub}", method=RequestMethod.GET)
	public String getForumEntriesIncluding(@PathVariable String sub, Model model) {
		return this.prepareForumView(this.dataAccess.getAllIncluding(sub), model);
	}
	
	/**
	 * Ermöglicht die Suche über das Suchfeld der Sidebar und leitet auf die 
	 * URL der Form "/forum/~<Sucheingabe>" weiter
	 * @param 	src		String nach dem gesucht wird
	 * @return	String	url auf die Redirect ausgeführt wird
	 */
	@RequestMapping(value="/forum/?search={src}", method=RequestMethod.GET)
	public String searchEntries(@PathVariable String src) {
		// Auf entsprechenden Pfad weiterleiten
		return this.forumRedirect +"~" + src;
		// TODO geht noch nicht
	}
	
	/* ------------------ Neue Einträge -------------------------------- */
	/**
	 * Lädt das Formular zum Erstellen eines neuen Foreneintrags.
	 * @param 	model	Model
	 * @return	String	viewname
	 */
	@RequestMapping(value="/forum/neuer-eintrag/", method=RequestMethod.GET)
	public String displayNewForumEntryForm(Model model) {
		// Neues ForumEntry Objekt in jsp zugreifbar machen
		model.addAttribute(new ForumEntry());
		// Formular laden
		return this.forumNewEntryViewName;
	}
	
	/**
	 * Speichert einen neuen Foreneintrag.
	 * @param	entry			ForumEntry		Eintrag der gespeichert werden soll
	 * @param	bindingResult	BindingResult
	 */
	@RequestMapping(value="/forum/neuer-eintrag/", method=RequestMethod.POST)
	public String saveNewForumEntry(ForumEntry newEntry, BindingResult bindingResult) {
		// Bei Fehlern wieder auf Formular redirecten
		if(bindingResult.hasErrors()) {
			return this.forumNewEntryViewName;
		}
		
		// sonst speichern und Forum laden
		this.dataAccess.save(newEntry);
		
		return this.forumRedirect;
	}
	
	/* --------------------- Kommentare ----------------------------*/
	/**
	 * Speichert einen neuen Kommentar
	 * @param 	id				int				id des zugehörigen Foreneintrags
	 * @param 	newComment		Comment			zu speichernder Kommentar
	 * @param 	bindingResult	BindingResult
	 */
	@RequestMapping(value="/forum/neuer-kommentar/{id}", method=RequestMethod.POST)
	public String saveNewForumComment(@PathVariable int id, Comment newComment, BindingResult bindingResult) {
		// Bei Fehlern wieder auf Formular redirecten
		if(bindingResult.hasErrors()) {
			return this.forumViewName;
		}
		
		// sonst speichern und Forum laden
		this.dataAccess.saveComment(newComment, id);
		
		return this.forumRedirect;
	}

}
